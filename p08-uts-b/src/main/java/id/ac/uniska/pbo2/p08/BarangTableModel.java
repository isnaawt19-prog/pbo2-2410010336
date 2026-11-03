package id.ac.uniska.pbo2.p08;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabel daftar belanja. Juga menghitung total, diskon, dan bayar.
 */
public class BarangTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private static final long BATAS_DISKON = 100_000L;

    private final List<Barang> daftar = new ArrayList<>();

    /** Mengubah angka menjadi format rupiah, misalnya Rp125.000. */
    public static String formatRupiah(long nilai) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols(Locale.ROOT);
        simbol.setGroupingSeparator('.');
        DecimalFormat format = new DecimalFormat("#,##0", simbol);
        return "Rp" + format.format(nilai);
    }

    public void tambah(Barang barang) {
        daftar.add(barang);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    /** Memeriksa nama sudah ada atau belum, tanpa membedakan huruf besar dan kecil. */
    public boolean adaNama(String nama) {
        for (Barang b : daftar) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public long getTotal() {
        long total = 0;
        for (Barang b : daftar) {
            total += b.getSubtotal();
        }
        return total;
    }

    /** Diskon 10 persen (dibulatkan ke bawah) jika total minimal Rp100.000. */
    public long getDiskon() {
        long total = getTotal();
        return total >= BATAS_DISKON ? total / 10 : 0;
    }

    public long getBayar() {
        return getTotal() - getDiskon();
    }

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Barang b = daftar.get(baris);
        switch (kolom) {
            case 0:
                return b.getNama();
            case 1:
                return b.getKategori().getLabel();
            case 2:
                return formatRupiah(b.getHarga());
            case 3:
                return b.getJumlah();
            case 4:
                return formatRupiah(b.getSubtotal());
            default:
                return "";
        }
    }
}
