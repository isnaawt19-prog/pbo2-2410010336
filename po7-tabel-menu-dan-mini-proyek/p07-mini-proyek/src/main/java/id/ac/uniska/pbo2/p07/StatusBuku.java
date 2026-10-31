package id.ac.uniska.pbo2.p07;

/**
 * Status peminjaman buku. Nilai dari toString() dipakai sebagai teks di JComboBox dan tabel.
 */
public enum StatusBuku {

    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String label;

    StatusBuku(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
