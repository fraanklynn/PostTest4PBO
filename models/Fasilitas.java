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
