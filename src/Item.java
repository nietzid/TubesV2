import java.util.*;
public class Item extends ElemenGame{
    protected Karakter pemilik;
    protected Wilayah lokasi;
    protected boolean isDiambil = false;
    protected boolean isDipegang = false;
    protected String kemampuan;

    public Item(String nama, String deskripsi,  Karakter pemilik) {
        super(nama,deskripsi);
        this.pemilik = pemilik;
    }
    public Item(String nama, String deskripsi,  Wilayah lokasi) {
        super(nama,deskripsi);
        this.lokasi = lokasi;
    }
    public Item(String nama, String deskripsi) {
        super(deskripsi,nama);
    }

    //prosedur untuk mengisi arrAksi
    public void initArrAksi (){
        super.initArrAksi();
        arrAksi.add(new Aksi("Lihat Status Item",102,this));
        if(this.isDiambil){
            if(this.isDipegang){
                arrAksi.add(new Aksi("Lepaskan (Simpan kedalam tas)",201,this));
            }
            else{
                arrAksi.add(new Aksi("Gunakan",202,this));
            }
            arrAksi.add(new Aksi("Buang Item",301,this));
        }
        else{
            arrAksi.add(new Aksi("Pungut Item",302,this));
        }
    }

    //prosedur proses aksi //blm selesai
    public void prosesAksi(int idAksi){
        if (idAksi == 102){
            this.printItem();
        }
        else if (idAksi == 201){
            this.disuse();
        }
        else if (idAksi == 202){
            this.use();
        }
        else if (idAksi == 301){
            pemilik.dropItem(this);
        }
        else if (idAksi == 302){
            lokasi.getKarakterAktif().pungutItem(this);
        }
        else{
            super.prosesAksi(idAksi);
        }
    }

    public void use(){
        System.out.println(this.nama + " digunakan!");
        pemilik.TastoEquip(this);
    }

    public void disuse(){
        System.out.println(this.nama + " disimpan ke dalam tas!");
        pemilik.EquiptoTas(this);
    }

    public void printItem(){
        System.out.println("Item ini bernama " + nama );
    }

    public Karakter getPemilik() {
        return pemilik;
    }

    public void setPemilik(Karakter pemilik) {
        this.pemilik = pemilik;
    }

    public Wilayah getLokasi() {
        return lokasi;
    }

    public void setLokasi(Wilayah lokasi) {
        this.lokasi = lokasi;
    }

    public boolean isDipegang() {
        return isDipegang;
    }

    public void setDipegang(boolean dipegang) {
        isDipegang = dipegang;
    }

    public boolean isDiambil() {
        return isDiambil;
    }

    public void setDiambil(boolean diambil) {
        isDiambil = diambil;
    }

    public String getKemampuan() {
        return kemampuan;
    }

    public void setKemampuan(String kemampuan) {
        this.kemampuan = kemampuan;
    }
}