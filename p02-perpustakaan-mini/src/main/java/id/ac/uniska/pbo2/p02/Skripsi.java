package id.ac.uniska.pbo2.p02;

/**
 * Koleksi skripsi yang hanya dapat dibaca di tempat.
 */
public class Skripsi extends Koleksi {

    private final String penulis;
    private final String programStudi;

    public Skripsi(String kode, String judul, int tahunTerbit,
                   String penulis, String programStudi) {
        super(kode, judul, tahunTerbit);
        this.penulis = penulis;
        this.programStudi = programStudi;
    }

    @Override
    public int batasHariPinjam() {
        return 0;
    }

    @Override
    public boolean pinjam() {
        return false;
    }

    @Override
    public long hitungDenda(int hariTerlambat) {
        return 0;
    }

    @Override
    public String keterangan() {
        return "Skripsi karya " + penulis
                + ", Program Studi " + programStudi;
    }
}