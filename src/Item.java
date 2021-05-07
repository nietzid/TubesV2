import java.util.*;
public class Item extends ElemenGame{
    protected Karakter pemilik;
    protected Wilayah lokasi;
    protected boolean isDiambil;
    protected boolean isDipegang;

    public Item(String deskripsi, String nama, Karakter pemilik) {
        super(deskripsi,nama);
        this.isDiambil = true;
        this.pemilik = pemilik;
    }
    public Item(String deskripsi, String nama, Wilayah lokasi) {
        super(deskripsi,nama);
        this.isDiambil = false;
        this.lokasi = lokasi;
    }

    //prosedur untuk mengisi arrAksi
    public void initArrAksi (){
        super.initArrAksi();
        arrAksi.add(new Aksi("Lihat Status Item",102,this));
        if(this.isDipegang){
            arrAksi.add(new Aksi("Lepaskan",201,this));
        }
        else{
            arrAksi.add(new Aksi("Gunakan",202,this));
        }
        if(this.isDiambil){
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
        if (idAksi == 201){
            this.disuse();
        }
        if (idAksi == 202){
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
        pemilik.TastoEquip(this);
    }

    public void disuse(){
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
}