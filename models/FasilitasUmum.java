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
        System.out.println("Fasilitas umum mendukung kenyamanan setiap pemakai fasilitas");
    }
}
