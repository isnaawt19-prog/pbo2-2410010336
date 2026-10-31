package id.ac.uniska.pbo2.p07;

/**
 * Data satu buku. Perubahan dilakukan dengan mengganti object lama dengan object baru.
 */
public record Buku(String kode, String judul, String penulis, int tahun, StatusBuku status) {
}
