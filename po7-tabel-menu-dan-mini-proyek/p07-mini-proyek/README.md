# Katalog Buku Perpustakaan (Mini Proyek P07 PBO 2)

Aplikasi desktop Swing + FlatLaf untuk mengelola katalog buku: tabel, tambah, ubah, hapus, pencarian, dan menu.

- **Nama / NIM / Kelas:** Isnawati / 2410010336 / 5C
- **Mata kuliah:** Pemrograman Berbasis Objek 2 (TIF1508), Pertemuan 7
- **Proyek:** Maven `p07-mini-proyek`, package `id.ac.uniska.pbo2.p07`, JDK 21, FlatLaf 3.5.4
- **Menjalankan:** buka folder proyek di NetBeans, klik kanan proyek, pilih *Run*. Kelas utama: `KatalogBuku`.

## Struktur kelas

| Kelas | Jenis | Tugas |
|---|---|---|
| `KatalogBuku` | JFrame Form (`.form`) | Jendela utama: menu, tombol, tabel, pencarian, status |
| `DialogBuku` | JDialog Form (`.form`) | Dialog modal tambah dan ubah, berisi validasi |
| `BukuTableModel` | AbstractTableModel | Menyimpan `List<Buku>` dan memanggil method `fire...` |
| `Buku` | record | Data satu buku |
| `StatusBuku` | enum | Tersedia atau Dipinjam |

## Peta event

| Komponen | Event | Method handler | Yang dilakukan |
|---|---|---|---|
| `tambahButton`, `tambahItem` (Ctrl+N) | Action: actionPerformed | `tambah()` | Membuka `DialogBuku` kosong, hasilnya ditambahkan ke model |
| `ubahButton`, `ubahItem` (Ctrl+E) | Action: actionPerformed | `ubah()` | Membuka `DialogBuku` berisi data buku terpilih |
| `hapusButton`, `hapusItem` (Ctrl+D) | Action: actionPerformed | `hapus()` | Konfirmasi lalu menghapus buku terpilih |
| `cariField` | Key: keyReleased | `saring()` | Menyaring tabel berdasarkan kode, judul, atau penulis |
| `bukuTable` | Mouse: mouseClicked | `ubah()` | Klik dua kali pada baris membuka dialog ubah |
| `bukuTable` (selection model) | ListSelectionListener (di konstruktor) | `perbaruiTombol()` | Mengaktifkan atau menonaktifkan Ubah dan Hapus |
| `keluarItem` | Action: actionPerformed | `dispose()` | Menutup jendela |
| `tentangItem` | Action: actionPerformed | `JOptionPane` | Menampilkan informasi aplikasi |
| `simpanButton` (di `DialogBuku`) | Action: actionPerformed | `simpan()` | Validasi isian, lalu menutup dialog jika benar |
| `batalButton` (di `DialogBuku`) | Action: actionPerformed | `dispose()` | Menutup dialog tanpa menyimpan |

## Validasi di `DialogBuku`

- Kode wajib diisi dan tidak boleh sama dengan kode buku lain.
- Judul wajib diisi.
- Tahun terbit berupa angka 1900 sampai tahun sekarang.
- Pesan kesalahan tampil merah di dalam dialog dan fokus pindah ke isian yang salah.

## Catatan teknis

- Nomor baris tampilan selalu diubah dengan `convertRowIndexToModel()` sebelum mengubah atau menghapus data, sehingga aman saat tabel diurutkan atau disaring.
- Kolom Tahun bertipe `Integer` (`getColumnClass`) agar diurutkan sebagai angka.

## Video demo

Tautan video demo (maksimal 3 menit): **ISI_TAUTAN_VIDEO_DI_SINI**

## Deklarasi penggunaan AI

Saya menggunakan Claude (Anthropic) untuk membantu menyusun kode proyek ini, membuat file `.form`, dan menulis draf README serta jawaban eksperimen. Seluruh kode saya jalankan, pelajari, dan uji sendiri sebelum dikumpulkan.
