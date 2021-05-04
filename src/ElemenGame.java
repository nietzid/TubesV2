import java.util.ArrayList;
import java.util.Scanner;

public class ElemenGame {
    public Scanner in = new Scanner(System.in);
    //variabel
    protected String nama;
    protected String deskripsi;

    protected int cc;
    protected ArrayList<ElemenGame> arrElGame = new ArrayList<>();
    //array untuk isi dari aksi-aksi
    protected ArrayList<Aksi> arrAksi = new ArrayList<>();

    //contructor
    public ElemenGame(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    //prosedur untuk mengisi aksi
    public void initArrAksi (){
        ArrayList<Aksi> arrAksi = new ArrayList<>();
        arrAksi.add(new Aksi("Deskripsikan",101,this));

    }

    //prosedur proses aksi
    public void prosesAksi(int idAksi){
        if (idAksi == 101){
            System.out.printf("Deskripsi: %s \n",deskripsi);
        }
    }

    //prosedur pilihanAksi
    public void pilihanAksi(){

        System.out.println(getNama());
        arrAksi.addAll(getArrAksi());

        //perulangan untuk menampilkan aksi-aksi yang ditampung di arraylist Aksi
        for (Aksi aksi: getArrAksi()){
            System.out.printf("%d. %s \n",cc,aksi.getNamaAksi());
            cc++;
        }

        if (arrElGame.size() > 0){
            System.out.printf("item %s memiliki \n: ",nama);
            for (ElemenGame elemen: arrElGame){
                initArrAksi();
            }
        }
        System.out.println("Pilihan dari aksi: ");
        cc=1;
        arrAksi.clear();
        initArrAksi();

        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();

        System.out.println("****************************");
        arrAksi.get(pilih-1).eksekusiAksi();
    }

    //prosedur tambahElemen
    public void tambahElemen(ElemenGame elemen){
        arrElGame.add(elemen);
    }

    //prosedur hapusElemen
    public void hapusElemen(ElemenGame elemen){
        arrElGame.remove(elemen);
    }

    //prosedur cariElemen
    public ElemenGame cariElemen(String namaElemen){
        for (ElemenGame elemen:arrElGame){
            if (namaElemen.equals(elemen.getNama())){
                return elemen;
            }
        }
        return null;
    }

    //setter dan getter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public ArrayList<Aksi> getArrAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<Aksi> arrAksi) {
        this.arrAksi = arrAksi;
    }

}