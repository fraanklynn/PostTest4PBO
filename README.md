# PostTest4PBO
## Deskripsi Program
Program ini merupakan aplikasi manajemen fasilitas gym berbasis console yang menerapkan konsep OOP (Encapsulation, Inheritance, Polymorphism, dan Abstraction) di Java.
1. Encapsulation: atribut pada class Fasilitas dibuat private dengan akses melalui getter & setter.
2. Inheritance: class FasilitasOlahraga dan FasilitasUmum mewarisi Fasilitas.
3. Polymorphism:
- Overriding → tampilkanInfo() ditimpa di subclass.
- Overloading → method cariFasilitas() memiliki dua versi berbeda (dengan Scanner dan dengan String).
- Abstraction: Fasilitas dijadikan abstract class, sementara interface Deskripsi digunakan agar subclass bisa memberikan detail deskripsi tambahan.

Pengelolaan data dilakukan melalui class FasilitasService dengan fitur CRUD (Tambah, Lihat, Update, Hapus, Cari) menggunakan ArrayList, sedangkan class Main menyediakan menu interaktif berbasis teks. Dengan penerapan abstraksi dan interface, program lebih fleksibel, reusable, dan sesuai prinsip OOP tingkat lanjut.

## Alur Program
Program dimulai dari class Main yang menampilkan menu utama.
Pengguna memilih salah satu opsi menu:

1. Tambah Fasilitas → Input ID, nama, status, dan jenis (Olahraga/Umum), lalu data disimpan.
2. Lihat Fasilitas → Menampilkan seluruh data fasilitas.
3. Update Fasilitas → Input ID, lalu masukkan nama & status baru.
4. Hapus Fasilitas → Input ID, data dengan ID sesuai akan dihapus.
5. Cari Fasilitas → Input nama, program menampilkan hasil pencarian.
6. Lihat Deskripsi Fasilitas → Input ID, menampilkan deskripsi dari fasilitas (menggunakan interface Deskripsi).
7. Keluar → Program berhenti.

Semua logika CRUD dijalankan di dalam FasilitasService.
Fasilitas hanya digunakan untuk menyimpan atribut dasar dan method abstract.
