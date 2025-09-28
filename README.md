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

## Struktur Packages
### package com.mycompany.main
1. Main
- Titik awal eksekusi program.
- Menyediakan menu berbasis console untuk mengelola data.
- Memanggil layanan dari FasilitasService.

### package models
1. Fasilitas → abstract class dengan atribut idFasilitas, namaFasilitas, status, serta method abstract tampilkanInfo().
2. Deskripsi → interface dengan method tampilkanDeskripsi().
3. FasilitasOlahraga → subclass Fasilitas + implementasi Deskripsi, override tampilkanInfo() dengan label [Olahraga].
4. FasilitasUmum → subclass Fasilitas + implementasi Deskripsi, override tampilkanInfo() dengan label [Umum].

### package service
1. FasilitasService
- Menyimpan data fasilitas dalam ArrayList.
- Menyediakan operasi CRUD (tambah, lihat, update, hapus, cari).
- Overloading cariFasilitas() → pencarian bisa dengan Scanner atau langsung dengan String.
- Memanfaatkan polymorphism saat memanggil tampilkanInfo().
- Mendukung abstraksi dengan pemanggilan interface Deskripsi.
