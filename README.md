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
#### <img width="377" height="297" alt="image" src="https://github.com/user-attachments/assets/f7305e3c-df13-487d-b278-fbaf897dbdee" />

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

# Penjelasan Code Terbaru
```
package models;

public class FasilitasOlahraga extends Fasilitas implements Deskripsi {
    public FasilitasOlahraga(int idFasilitas, String namaFasilitas, String status) {
        super(idFasilitas, namaFasilitas, status);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Olahraga] ID: " + getIdFasilitas() +
                           " | Nama: " + getNamaFasilitas() +
                           " | Status: " + getStatus());
    }

    @Override
    public void tampilkanDeskripsi() {
        System.out.println("Fasilitas olahraga menunjang latihan fisik, seperti treadmill dan barbel.");
    }
}

```
Class FasilitasOlahraga dalam package models adalah subclass dari Fasilitas yang juga mengimplementasikan interface Deskripsi, sehingga selain mewarisi atribut dasar (id, nama, status) dari superclass, class ini wajib mengisi method abstract tampilkanInfo() dari Fasilitas dan tampilkanDeskripsi() dari Deskripsi; pada tampilkanInfo(), informasi fasilitas ditampilkan dengan tambahan label [Olahraga] agar berbeda dengan kategori lain, sedangkan pada tampilkanDeskripsi() diberikan penjelasan khusus bahwa fasilitas ini menunjang latihan fisik seperti treadmill dan barbel, sehingga class ini menunjukkan penerapan konsep inheritance, overriding, dan abstraction dalam OOP.
```
package models;

public abstract class Fasilitas {
    private int idFasilitas;
    private String namaFasilitas;
    private String status; 
    
    public Fasilitas(int idFasilitas, String namaFasilitas, String status) {
       this.idFasilitas = idFasilitas;
       this.namaFasilitas = namaFasilitas;
       this.status = status;
    }

    public int getIdFasilitas() {
        return idFasilitas;
    }
    public void setIdFasilitas(int idFasilitas) {
        this.idFasilitas = idFasilitas;
    }

    public String getNamaFasilitas() {
        return namaFasilitas;
    }
    public void setNamaFasilitas(String namaFasilitas) {
        this.namaFasilitas = namaFasilitas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void tampilkanInfo();
}
```
Kode terbaru Fasilitas di atas merupakan sebuah kelas abstrak dalam package models yang berfungsi sebagai blueprint untuk setiap jenis fasilitas. Kelas ini memiliki tiga atribut utama yaitu idFasilitas, namaFasilitas, dan status yang sudah dilengkapi dengan constructor, getter, serta setter untuk mengelola data. Karena bersifat abstrak, Fasilitas tidak bisa diinstansiasi secara langsung, melainkan harus diturunkan ke subclass. Selain itu, adanya method abstrak tampilkanInfo() mengharuskan setiap subclass untuk memberikan implementasi spesifik, sehingga konsep abstraction dan inheritance dalam OOP dapat diterapkan.

```
package models;

public class FasilitasUmum extends Fasilitas implements Deskripsi {
    public FasilitasUmum(int idFasilitas, String namaFasilitas, String status) {
        super(idFasilitas, namaFasilitas, status);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Umum] ID: " + getIdFasilitas() +
                           " | Nama: " + getNamaFasilitas() +
                           " | Status: " + getStatus());
    }

    @Override
    public void tampilkanDeskripsi() {
        System.out.println("Fasilitas umum mendukung kenyamanan, seperti ruang ganti dan shower.");
    }
}

```
Kode FasilitasUmum di atas adalah subclass dari Fasilitas yang juga mengimplementasikan interface Deskripsi. Pada class ini, constructor digunakan untuk memanggil constructor superclass melalui super(...) agar atribut dasar (idFasilitas, namaFasilitas, dan status) dapat diinisialisasi. Method abstrak tampilkanInfo() dari superclass dioverride untuk menampilkan informasi fasilitas dengan tambahan label [Umum], sedangkan method tampilkanDeskripsi() dari interface diimplementasikan untuk memberikan penjelasan bahwa fasilitas umum mendukung kenyamanan seperti ruang ganti dan shower. Dengan demikian, class ini menunjukkan penerapan konsep inheritance, abstraction, overriding, dan interface implementation dalam OOP.

```
package models;

public interface Deskripsi {
    void tampilkanDeskripsi();
}
```
Kode Deskripsi di atas adalah sebuah interface sederhana dalam package models yang hanya mendefinisikan satu kontrak method, yaitu tampilkanDeskripsi(). Interface ini tidak memiliki implementasi, sehingga setiap class yang mengimplementasikannya (seperti FasilitasOlahraga dan FasilitasUmum) wajib menyediakan isi method tersebut sesuai kebutuhan masing-masing. Dengan cara ini, interface Deskripsi mendukung konsep abstraction dan juga memungkinkan polymorphism, karena method yang sama (tampilkanDeskripsi()) dapat diimplementasikan dengan cara berbeda pada tiap class yang menggunakannya.

```
package service;

import models.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FasilitasService {
    ArrayList<Fasilitas> daftarFasilitas = new ArrayList<>();

```
Class FasilitasService dalam package service berfungsi sebagai pengelola data fasilitas dengan menggunakan ArrayList<Fasilitas> untuk menyimpan berbagai objek fasilitas secara dinamis, di mana berkat sifat abstrak dari class Fasilitas, list ini dapat menampung objek subclass seperti FasilitasOlahraga dan FasilitasUmum sehingga mendukung konsep polymorphism; import Iterator disiapkan untuk menelusuri data dalam list, sedangkan Scanner digunakan untuk menerima input dari pengguna sehingga class ini nantinya bisa dikembangkan untuk menambahkan, menampilkan, mencari, maupun menghapus data fasilitas.

```
    public FasilitasService() {
        daftarFasilitas.add(new FasilitasOlahraga(1, "Treadmill", "Tersedia"));
        daftarFasilitas.add(new FasilitasUmum(2, "Lokerl", "Tersedia"));
    }

    public void tambahFasilitas(Scanner scanner) {
        System.out.println("1. Olahraga | 2. Umum");
        System.out.print("Pilih jenis: ");
        int jenis = scanner.nextInt(); scanner.nextLine();

        System.out.print("Masukkan ID Fasilitas: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Fasilitas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Status Fasilitas: ");
        String status = scanner.nextLine();

        if (jenis == 1) {
            daftarFasilitas.add(new FasilitasOlahraga(id, nama, status));
        } else {
            daftarFasilitas.add(new FasilitasUmum(id, nama, status));
        }

        System.out.println("Fasilitas berhasil ditambahkan!");
```
Constructor FasilitasService langsung menambahkan dua data awal ke dalam daftarFasilitas, sedangkan method tambahFasilitas() digunakan untuk menambah fasilitas baru melalui input pengguna dengan bantuan Scanner; pengguna memilih jenis fasilitas (Olahraga atau Umum), lalu mengisi ID, nama, dan status, setelah itu objek FasilitasOlahraga atau FasilitasUmum dibuat sesuai pilihan dan disimpan ke dalam list, sehingga data fasilitas dapat bertambah secara dinamis.

```
  public void lihatFasilitas() {
        if (daftarFasilitas.isEmpty()) {
            System.out.println("Belum ada fasilitas yang tersimpan.");
        } else {
            System.out.println("\n=== Daftar Fasilitas ===");
            for (Fasilitas f : daftarFasilitas) {
                f.tampilkanInfo(); // Overriding jalan
            }
        }
    }
```
Method lihatFasilitas() berfungsi untuk menampilkan seluruh data fasilitas yang tersimpan dalam daftarFasilitas; jika list masih kosong maka ditampilkan pesan bahwa belum ada fasilitas, sedangkan jika ada data, program akan mencetak judul daftar lalu melakukan perulangan untuk setiap objek Fasilitas dan memanggil tampilkanInfo(), yang merupakan method override di subclass (FasilitasOlahraga atau FasilitasUmum), sehingga konsep polymorphism berjalan karena pemanggilan method disesuaikan dengan tipe objek sebenarnya.

```
public void updateFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Fasilitas f : daftarFasilitas) {
            if (f.getIdFasilitas() == id) {
                System.out.print("Masukkan Nama Baru: ");
                f.setNamaFasilitas(scanner.nextLine());
                System.out.print("Masukkan Status Baru: ");
                f.setStatus(scanner.nextLine());
                System.out.println("Data fasilitas berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }

```
Method updateFasilitas() digunakan untuk memperbarui data fasilitas berdasarkan ID yang dimasukkan pengguna; program meminta input ID, lalu melakukan pencarian dalam daftarFasilitas, dan jika ditemukan objek dengan ID yang sesuai, maka atribut namaFasilitas dan status diperbarui melalui setter, serta ditampilkan pesan sukses, sedangkan jika tidak ada ID yang cocok, program menampilkan pesan bahwa fasilitas tidak ditemukan.

```
   public void cariFasilitas(Scanner scanner) {
        System.out.print("Masukkan Nama Fasilitas yang ingin dicari: ");
        String namaCari = scanner.nextLine().trim();
        cariFasilitas(namaCari); // panggil versi overloading
    }

    public void cariFasilitas(String namaCari) {
        boolean ditemukan = false;
        for (Fasilitas f : daftarFasilitas) {
            if (f.getNamaFasilitas().toLowerCase().contains(namaCari.toLowerCase())) {
                f.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Fasilitas dengan nama '" + namaCari + "' tidak ditemukan.");
        }
    }
```
Method cariFasilitas() dibuat dalam dua versi sebagai bentuk overloading, yaitu versi pertama yang menerima input dari pengguna lewat Scanner dan versi kedua yang langsung menggunakan parameter String untuk nama yang dicari. Cara kerjanya, program akan membandingkan nama fasilitas yang ada di daftarFasilitas dengan kata kunci pencarian, lalu menampilkan detail fasilitas jika ditemukan menggunakan tampilkanInfo(). Jika tidak ada yang cocok, maka akan muncul pesan bahwa fasilitas dengan nama tersebut tidak ditemukan.
```
public void lihatDeskripsi(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas untuk melihat deskripsi: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Fasilitas f : daftarFasilitas) {
            if (f.getIdFasilitas() == id && f instanceof Deskripsi) {
                ((Deskripsi) f).tampilkanDeskripsi(); // Interface dipanggil
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }
}
```
Method lihatDeskripsi() digunakan untuk menampilkan deskripsi fasilitas berdasarkan ID yang dimasukkan pengguna; setelah ID diterima, program mencari objek dalam daftarFasilitas, lalu jika objek tersebut ditemukan dan merupakan instance dari Deskripsi, method tampilkanDeskripsi() dari interface dipanggil dengan melakukan casting, sehingga detail deskripsi fasilitas muncul, sedangkan jika tidak ada ID yang sesuai, program menampilkan pesan bahwa fasilitas tidak ditemukan.

```
package com.mycompany.main;

import service.FasilitasService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FasilitasService fasilitasService = new FasilitasService();
            int pilihan;
            
            do {
                System.out.println("\n=== MENU FASILITAS GYM ===");
                System.out.println("1. Tambah Fasilitas");
                System.out.println("2. Lihat Fasilitas");
                System.out.println("3. Update Fasilitas");
                System.out.println("4. Hapus Fasilitas");
                System.out.println("5. Cari Fasilitas");
                System.out.println("6. Lihat Deskripsi Fasilitas");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> fasilitasService.tambahFasilitas(scanner);
                    case 2 -> fasilitasService.lihatFasilitas();
                    case 3 -> fasilitasService.updateFasilitas(scanner);
                    case 4 -> fasilitasService.hapusFasilitas(scanner);
                    case 5 -> fasilitasService.cariFasilitas(scanner);
                    case 6 -> fasilitasService.lihatDeskripsi(scanner);
                    case 7 -> System.out.println("Keluar dari program...");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 7);
        }
    }
}
```
Class Main adalah titik awal eksekusi program yang menyediakan menu interaktif berbasis console untuk mengelola fasilitas gym. Di dalamnya dibuat objek FasilitasService yang menangani seluruh logika CRUD, lalu program menjalankan perulangan do-while agar menu terus muncul hingga pengguna memilih keluar. Setiap pilihan menu di-handle menggunakan switch, mulai dari menambah, melihat, memperbarui, menghapus, mencari, hingga melihat deskripsi fasilitas. Input pengguna diambil dengan Scanner, dan program baru berhenti jika opsi nomor 7 dipilih. Dengan struktur ini, Main berperan sebagai penghubung antara pengguna dan layanan yang ada di FasilitasService.

#Penjelasan Output Terbaru

#### <img width="518" height="384" alt="image" src="https://github.com/user-attachments/assets/ac7b454e-531c-4e08-a2a3-2463c13124e3" />
ini adalah output terbaru dari menu 1 yaitu tambah fasilitas, disini user dapat menambah fasilitas sesuai dengan jenisnya ada fasilitas olahraga dan umum

#### <img width="681" height="380" alt="image" src="https://github.com/user-attachments/assets/6a01a50b-43a4-463f-81b1-5afbf6648b79" />
ini adalah output terbaru dari menu 2 yaitu lihat fasilitas, disini user dapat melihat fasilitas sesuai dengan jenisnya ada fasilitas olahraga dan umum

#### <img width="711" height="693" alt="image" src="https://github.com/user-attachments/assets/d8f8eb10-fe3f-40c6-8332-63721288aca3" />
ini adalah output dari menu 3 yaitu update fasilitas tidak ada perubahan output karena hanya meminta id dari fasilitas yang ingin diupdate

#### <img width="691" height="618" alt="image" src="https://github.com/user-attachments/assets/5faee819-2050-46e7-aa55-45201c8ef138" />
ini adalah output dari menu 4 yaitu hapus fasilitas tidak ada perubahan output karena hanya meminta id dari fasilitas yang ingin dihapus

#### <img width="700" height="298" alt="image" src="https://github.com/user-attachments/assets/49f817a1-e3f8-48b8-82ff-948998710fa0" />
ini adalah output dari menu 5 yaitu cari fasilitas tidak ada perubahan output karena hanya meminta nama dari fasilitas yang ingin dicari



