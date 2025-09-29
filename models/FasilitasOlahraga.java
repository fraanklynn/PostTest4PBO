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
        System.out.println("Fasilitas olahraga dapat membantu dalam meningkatkan kualitas fisik.");
    }
}
