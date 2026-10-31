package id.ac.uniska.pbo2.p07;

import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import java.time.Year;
import java.util.function.Predicate;
import javax.swing.JComponent;

/**
 * Dialog modal untuk menambah atau mengubah satu buku.
 */
public class DialogBuku extends javax.swing.JDialog {

    private static final int TAHUN_MINIMAL = 1900;

    private final Predicate<String> kodeTerpakai;
    private Buku hasil; // tetap null jika pengguna membatalkan

    /**
     * Membuat dialog tambah atau ubah buku.
     *
     * @param pemilik jendela utama yang dikunci selama dialog terbuka
     * @param judul judul dialog, misalnya Tambah Buku
     * @param awal buku yang akan diubah, atau null untuk buku baru
     * @param kodeTerpakai pemeriksa apakah sebuah kode sudah dipakai buku lain
     */
    public DialogBuku(java.awt.Frame pemilik, String judul, Buku awal, Predicate<String> kodeTerpakai) {
        super(pemilik, judul, true); // true berarti modal
        this.kodeTerpakai = kodeTerpakai;
        initComponents();
        if (awal != null) {
            kodeField.setText(awal.kode());
            judulField.setText(awal.judul());
            penulisField.setText(awal.penulis());
            tahunField.setText(String.valueOf(awal.tahun()));
            statusCombo.setSelectedItem(awal.status());
        }
        penulisField.putClientProperty("JTextField.placeholderText", "Boleh dikosongkan");
        tahunField.putClientProperty("JTextField.placeholderText", TAHUN_MINIMAL + " - " + Year.now().getValue());
        pesanLabel.putClientProperty("FlatLaf.styleClass", "small");
        pesanLabel.setForeground(FlatLaf.isLafDark()
                ? new Color(0xFF8A80) : new Color(0xC62828));
        getRootPane().setDefaultButton(simpanButton);
        pack();
        setLocationRelativeTo(pemilik);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel = new javax.swing.JPanel();
        labelPanel = new javax.swing.JPanel();
        kodeLabel = new javax.swing.JLabel();
        judulLabel = new javax.swing.JLabel();
        penulisLabel = new javax.swing.JLabel();
        tahunLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        isianPanel = new javax.swing.JPanel();
        kodeField = new javax.swing.JTextField();
        judulField = new javax.swing.JTextField();
        penulisField = new javax.swing.JTextField();
        tahunField = new javax.swing.JTextField();
        statusCombo = new javax.swing.JComboBox<>();
        bawahPanel = new javax.swing.JPanel();
        pesanLabel = new javax.swing.JLabel();
        tombolPanel = new javax.swing.JPanel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout());

        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 8, 16));
        formPanel.setLayout(new java.awt.BorderLayout(12, 0));
        labelPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));
        kodeLabel.setText("Kode");
        kodeLabel.setLabelFor(kodeField);
        labelPanel.add(kodeLabel);
        judulLabel.setText("Judul");
        judulLabel.setLabelFor(judulField);
        labelPanel.add(judulLabel);
        penulisLabel.setText("Penulis");
        penulisLabel.setLabelFor(penulisField);
        labelPanel.add(penulisLabel);
        tahunLabel.setText("Tahun terbit");
        tahunLabel.setLabelFor(tahunField);
        labelPanel.add(tahunLabel);
        statusLabel.setText("Status");
        statusLabel.setLabelFor(statusCombo);
        labelPanel.add(statusLabel);
        formPanel.add(labelPanel, java.awt.BorderLayout.WEST);
        isianPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));
        kodeField.setColumns(24);
        isianPanel.add(kodeField);
        isianPanel.add(judulField);
        isianPanel.add(penulisField);
        isianPanel.add(tahunField);
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(StatusBuku.values()));
        isianPanel.add(statusCombo);
        formPanel.add(isianPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);

        bawahPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 16, 16));
        bawahPanel.setLayout(new java.awt.BorderLayout(0, 8));
        pesanLabel.setText(" ");
        bawahPanel.add(pesanLabel, java.awt.BorderLayout.NORTH);
        tombolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 0));
        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(batalButton);
        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(simpanButton);
        bawahPanel.add(tombolPanel, java.awt.BorderLayout.SOUTH);
        getContentPane().add(bawahPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        simpan();
    }//GEN-LAST:event_simpanButtonActionPerformed

    /** Menampilkan pesan kesalahan lalu memindahkan fokus ke isian yang salah. */
    private void tolak(String pesan, JComponent isian) {
        pesanLabel.setText(pesan);
        isian.requestFocusInWindow();
    }

    private void simpan() {
        String kode = kodeField.getText().trim();
        String judul = judulField.getText().trim();
        String tahunTeks = tahunField.getText().trim();
        int tahunMaksimal = Year.now().getValue();

        if (kode.isEmpty()) {
            tolak("Kode wajib diisi", kodeField);
            return;
        }
        if (kodeTerpakai.test(kode)) {
            tolak("Kode " + kode + " sudah dipakai buku lain", kodeField);
            return;
        }
        if (judul.isEmpty()) {
            tolak("Judul wajib diisi", judulField);
            return;
        }
        int tahun;
        try {
            tahun = Integer.parseInt(tahunTeks);
        } catch (NumberFormatException e) {
            tahun = -1; // bukan angka
        }
        if (tahun < TAHUN_MINIMAL || tahun > tahunMaksimal) {
            tolak("Tahun terbit berupa angka " + TAHUN_MINIMAL + " sampai " + tahunMaksimal, tahunField);
            return;
        }
        StatusBuku status = (StatusBuku) statusCombo.getSelectedItem();
        hasil = new Buku(kode, judul, penulisField.getText().trim(), tahun, status);
        dispose();
    }

    /** Menampilkan dialog dan menunggu sampai ditutup. Mengembalikan null jika dibatalkan. */
    public Buku tampilkan() {
        // Pada dialog modal, baris berikut menunggu sampai dialog ditutup
        setVisible(true);
        return hasil;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JPanel bawahPanel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel isianPanel;
    private javax.swing.JTextField judulField;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JTextField kodeField;
    private javax.swing.JLabel kodeLabel;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JTextField penulisField;
    private javax.swing.JLabel penulisLabel;
    private javax.swing.JLabel pesanLabel;
    private javax.swing.JButton simpanButton;
    private javax.swing.JComboBox<StatusBuku> statusCombo;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField tahunField;
    private javax.swing.JLabel tahunLabel;
    private javax.swing.JPanel tombolPanel;
    // End of variables declaration//GEN-END:variables
}
