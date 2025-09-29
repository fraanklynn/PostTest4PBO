package service;

import models.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FasilitasService {
    ArrayList<Fasilitas> daftarFasilitas = new ArrayList<>();

    public FasilitasService() {
        daftarFasilitas.add(new FasilitasOlahraga(1, "Treadmill", "Tersedia"));
        daftarFasilitas.add(new FasilitasUmum(2, "Loker", "Tersedia"));
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
    }

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

    public void hapusFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Fasilitas> it = daftarFasilitas.iterator();
        while (it.hasNext()) {
            Fasilitas f = it.next();
            if (f.getIdFasilitas() == id) {
                it.remove();
                System.out.println("Fasilitas berhasil dihapus!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }

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

    public void lihatDeskripsi(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas untuk melihat deskripsi: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Fasilitas f : daftarFasilitas) {
            if (f.getIdFasilitas() == id && f instanceof Deskripsi) {
                ((Deskripsi) f).tampilkanDeskripsi(); 
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }
}
