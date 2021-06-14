import java.util.ArrayList;
import java.util.Scanner;

public class ElemenGame {
    public Scanner in = new Scanner(System.in);
    //variabel
    protected String nama;
    protected String deskripsi;
    protected int cc;
    //array untuk isi dari aksi-aksi
    protected ArrayList<Aksi> arrAksi = new ArrayList<>();

    //contructor
    public ElemenGame(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    //prosedur untuk mengisi aksi
    public void initArrAksi (){
        arrAksi.clear();
        arrAksi.add(new Aksi("Kembali",001,this));
        arrAksi.add(new Aksi("Deskripsikan",101,this));
    }

    //prosedur proses aksi
    public void prosesAksi(int idAksi){
        if (idAksi == 101){
            System.out.println("__________----------***********----------__________");
            System.out.printf("Deskripsi: %s \n",deskripsi);
        }else if (idAksi == 001){
            System.out.println();
        }
    }

    //prosedur pilihanAksi
    public void pilihanAksi(){
        initArrAksi();
        System.out.println(" ");
        System.out.println("Pilihan aksi dari " + this.nama+ " : ");
        cc=1;
        //perulangan untuk menampilkan aksi-aksi yang ditampung di arraylist Aksi
        for (Aksi aksi: arrAksi){
            System.out.printf("%d. %s \n",cc,aksi.getNamaAksi());
            cc++;
        }
        System.out.print("Masukkan pilihan: ");
        int pilih = in.nextInt();

        arrAksi.get(pilih-1).eksekusiAksi();
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