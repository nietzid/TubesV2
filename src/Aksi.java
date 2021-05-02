public class Aksi {
    //variabel
    private String namaAksi;
    private int idAksi;
    private ElemenGame objAksi;

    public void eksekusiAksi(){
        objAksi.prosesAksi(idAksi);
    }

    //konstruktor

    public Aksi(String namaAksi, int idAksi, ElemenGame objAksi) {
        this.namaAksi = namaAksi;
        this.idAksi = idAksi;
        this.objAksi = objAksi;
    }

    //setter dan getter

    public String getNamaAksi() {
        return namaAksi;
    }

    public void setNamaAksi(String namaAksi) {
        this.namaAksi = namaAksi;
    }

    //note:uml kurng konstruktor dan setter getter
}
