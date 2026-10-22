Jawaban Eksperimen P05 – Event Handling



1\. Jawaban Eksperimen Praktikum 3: Konversi Suhu



Eksperimen 1



Pesan "item berubah" tercetak sebanyak dua kali setiap pilihan satuan diganti. Hal ini karena event itemStateChanged dipanggil saat pilihan lama dilepas dan pilihan baru dipilih. Oleh karena itu, perlu pemeriksaan ItemEvent.SELECTED agar proses hanya dilakukan satu kali.



Eksperimen 2



Hasil konversi terlambat satu karakter karena event keyPressed terjadi sebelum karakter yang ditekan masuk ke dalam text field. Akibatnya, program membaca teks sebelumnya. Event keyReleased lebih sesuai karena karakter sudah masuk ketika tombol keyboard dilepas.



Eksperimen 3



Ketika huruf dimasukkan tanpa blok try-catch, program menghasilkan error NumberFormatException di jendela Output karena huruf tidak dapat diubah menjadi angka menggunakan Double.parseDouble().



2\. Jawaban Eksperimen Praktikum 4: Kalkulator Sederhana



Eksperimen 1



Pesan "kali" tercetak dua kali karena tombol perkalian memiliki dua event, yaitu event actionPerformed yang dibuat melalui GUI Builder dan lambda yang ditulis di konstruktor. Sebaiknya satu tombol hanya menggunakan satu cara agar aksi tidak dijalankan dua kali.



Eksperimen 2



Untuk menambahkan tombol modulus (%), perubahan dilakukan pada tab Design dengan menambahkan tombol baru dan mengatur teksnya menjadi %. Pada tab Source, tombol dihubungkan ke method perhitungan dengan operator modulus % untuk menghitung sisa hasil pembagian.



Eksperimen 3



Setelah tombol Hapus ditekan, kursor langsung berada di isian pertama karena method hapus() menggunakan requestFocusInWindow(). Perintah tersebut mengembalikan fokus ke kolom angka pertama agar pengguna bisa langsung memasukkan angka baru.



3\. Peta Event Form Anggota Perpustakaan



Komponen	Jenis Event	Aksi

Checkbox Setuju	itemStateChanged	Tombol Daftar aktif jika checkbox dicentang dan nonaktif jika tidak dicentang.

Tombol Batal	actionPerformed	Mengosongkan semua isian, mengembalikan pilihan ke keadaan awal, dan mengarahkan fokus ke kolom NPM.

Tombol Daftar	actionPerformed	Menampilkan ringkasan data anggota menggunakan JOptionPane.

Isian NPM	keyReleased	Menampilkan jumlah digit NPM yang sudah diketik, misalnya “8 dari 10 digit”.

Form JFrame	windowClosing	Menampilkan dialog konfirmasi sebelum aplikasi ditutup. Jika memilih Yes, aplikasi ditutup; jika No, form tetap terbuka.



4\. Deklarasi Penggunaan AI



Saya menggunakan ChatGPT sebagai alat bantu untuk memahami materi event handling, membantu menyusun jawaban eksperimen, dan memahami penerapan event pada program Java Swing. Saya tetap memeriksa dan menyesuaikan jawaban dengan modul praktikum serta program yang dibuat.

