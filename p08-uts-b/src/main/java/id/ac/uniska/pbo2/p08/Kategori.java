package id.ac.uniska.pbo2.p08;

/**
 * Kategori barang yang tersedia pada form.
 */
public enum Kategori {
    ALAT_TULIS("Alat Tulis"),
    MAKANAN("Makanan"),
    MINUMAN("Minuman"),
    LAINNYA("Lainnya");

    private final String label;

    Kategori(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /** Mencari kategori berdasarkan teks yang tampil di JComboBox. */
    public static Kategori dariLabel(String label) {
        for (Kategori k : values()) {
            if (k.label.equals(label)) {
                return k;
            }
        }
        return LAINNYA;
    }

    @Override
    public String toString() {
        return label;
    }
}
