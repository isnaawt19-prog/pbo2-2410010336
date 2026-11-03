//Nama : Isnawati
//NPM : 2410010336


package id.ac.uniska.pbo2.p08;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Jendela utama aplikasi Daftar Belanja (UTS PBO 2 Paket B).
 */
public class FormDaftarBelanja extends javax.swing.JFrame {

    private static final long HARGA_MAKS = 10_000_000L;

    private final BarangTableModel modelBarang = new BarangTableModel();

    /**
     * Creates new form FormDaftarBelanja
     */
    public FormDaftarBelanja() {
        initComponents();
        siapkanTampilan();
        perbaruiRingkasan();
    }

    /** Pengaturan yang tidak tersedia di jendela Properties. */
    private void siapkanTampilan() {
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(12, 12, 12, 12));
        ((java.awt.BorderLayout) getContentPane().getLayout()).setVgap(8);
        ((java.awt.GridLayout) panelForm.getLayout()).setHgap(8);
        ((java.awt.GridLayout) panelForm.getLayout()).setVgap(6);
        txtNama.putClientProperty("JTextField.placeholderText", "Contoh: Pulpen");
        txtHarga.putClientProperty("JTextField.placeholderText", "Contoh: 3500");
        lblPesan.setForeground(Color.RED);
        tblBarang.setModel(modelBarang);

        DefaultTableCellRenderer kanan = new DefaultTableCellRenderer();
        kanan.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int kolom = 2; kolom <= 4; kolom++) {
            tblBarang.getColumnModel().getColumn(kolom).setCellRenderer(kanan);
        }

        // Enter sama dengan menekan tombol Tambah.
        getRootPane().setDefaultButton(btnTambah);
        setLocationRelativeTo(null);
    }

    /** Memperbarui label ringkasan dari model tabel. */
    private void perbaruiRingkasan() {
        lblRingkasan.setText("Total " + BarangTableModel.formatRupiah(modelBarang.getTotal())
                + ", diskon " + BarangTableModel.formatRupiah(modelBarang.getDiskon())
                + ", bayar " + BarangTableModel.formatRupiah(modelBarang.getBayar()));
    }

    /** Mengembalikan form ke keadaan awal. */
    private void kosongkanForm() {
        txtNama.setText("");
        txtHarga.setText("");
        cmbKategori.setSelectedIndex(0);
        spnJumlah.setValue(1);
        lblPesan.setText("");
    }

    /** Menampilkan pesan kesalahan dan memindahkan kursor ke isian yang salah. */
    private void tampilkanKesalahan(String pesan, javax.swing.JTextField isian) {
        lblPesan.setText(pesan);
        isian.requestFocusInWindow();
        isian.selectAll();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        panelForm = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblKategori = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        lblHarga = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        spnJumlah = new javax.swing.JSpinner();
        panelAksi = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        lblPesan = new javax.swing.JLabel();
        scrollTabel = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        lblRingkasan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Belanja");
        getContentPane().setLayout(new java.awt.BorderLayout());

        panelAtas.setLayout(new java.awt.BorderLayout());

        panelForm.setLayout(new java.awt.GridLayout(4, 2));

        lblNama.setText("Nama Barang");
        panelForm.add(lblNama);
        panelForm.add(txtNama);

        lblKategori.setText("Kategori");
        panelForm.add(lblKategori);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alat Tulis", "Makanan", "Minuman", "Lainnya" }));
        panelForm.add(cmbKategori);

        lblHarga.setText("Harga (Rp, tanpa titik)");
        panelForm.add(lblHarga);
        panelForm.add(txtHarga);

        lblJumlah.setText("Jumlah");
        panelForm.add(lblJumlah);

        spnJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        panelForm.add(spnJumlah);

        panelAtas.add(panelForm, java.awt.BorderLayout.CENTER);

        panelAksi.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        panelAksi.add(btnTambah);

        btnBersihkan.setText("Bersihkan");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });
        panelAksi.add(btnBersihkan);

        lblPesan.setForeground(new java.awt.Color(255, 0, 0));
        panelAksi.add(lblPesan);

        panelAtas.add(panelAksi, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelAtas, java.awt.BorderLayout.NORTH);

        scrollTabel.setViewportView(tblBarang);

        getContentPane().add(scrollTabel, java.awt.BorderLayout.CENTER);

        lblRingkasan.setText("Total Rp0, diskon Rp0, bayar Rp0");
        getContentPane().add(lblRingkasan, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama = txtNama.getText().trim();
        String teksHarga = txtHarga.getText().trim();

        // Aturan 1: nama wajib diisi (spasi saja dianggap kosong).
        if (nama.isEmpty()) {
            tampilkanKesalahan("Nama barang wajib diisi", txtNama);
            return;
        }

        // Aturan 2: nama belum ada di daftar (huruf besar/kecil dianggap sama).
        if (modelBarang.adaNama(nama)) {
            tampilkanKesalahan("Barang " + nama + " sudah ada di daftar", txtNama);
            return;
        }

        // Aturan 3: harga angka bulat 1 sampai 10000000 tanpa titik.
        long harga = -1;
        if (teksHarga.matches("\\d{1,9}")) {
            harga = Long.parseLong(teksHarga);
        }
        if (harga < 1 || harga > HARGA_MAKS) {
            tampilkanKesalahan("Harga harus angka 1 sampai 10000000", txtHarga);
            return;
        }

        Kategori kategori = Kategori.dariLabel((String) cmbKategori.getSelectedItem());
        int jumlah = (Integer) spnJumlah.getValue();

        modelBarang.tambah(new Barang(nama, kategori, harga, jumlah));
        kosongkanForm();
        perbaruiRingkasan();
        txtNama.requestFocusInWindow();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        kosongkanForm();
        txtNama.requestFocusInWindow();
    }//GEN-LAST:event_btnBersihkanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormDaftarBelanja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JLabel lblRingkasan;
    private javax.swing.JPanel panelAksi;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelForm;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JSpinner spnJumlah;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
