import java.util.ArrayList;
import java.util.Scanner;

public class ElemenGame {
        public Scanner in = new Scanner(System.in);
        //variabel
        private String deskripsi;
        private String nama;

        private int cc;
        private ArrayList<ElemenGame> arrElGame = new ArrayList<>();
        //array untuk isi dari aksi-aksi
        private ArrayList<Aksi> arrAksi = new ArrayList<>();

        //contructor
        public ElemenGame(String deskripsi, String nama) {
            this.deskripsi = deskripsi;
            this.nama = nama;
        }

        //prosedur tampil aksi
        private void initArrAksi (ElemenGame objElemenGame){
            System.out.println(objElemenGame.getNama());
            arrAksi.addAll(objElemenGame.getArrAksi());

            //perulangan untuk menampilkan aksi-aksi yang ditampung di arraylist objElemenGame
            for (Aksi aksi: objElemenGame.getArrAksi()){
                System.out.printf("%d. %s \n",cc,aksi.getNamaAksi());
                cc++;
            }

            if (objElemenGame.arrElGame.size() > 0){
                System.out.printf("item %s memiliki \n: ",objElemenGame,nama);
                for (ElemenGame elemen: objElemenGame.arrElGame){
                    initArrAksi(elemen);
                }
            }
        }

        //prosedur proses aksi
        public void prosesAksi(int idAksi){
            if (idAksi == 101){
                System.out.printf("Deskripsi: %s \n",deskripsi);
            }
        }

        //prosedur pilihanAksi
        public void pilihanAksi(){
            System.out.println("Pilihan dari aksi: ");

            cc=1;
            arrAksi.clear();
            initArrAksi(this);

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
        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

    public ArrayList<Aksi> getArrAksi() {
        ArrayList<Aksi> arrAksi = new ArrayList<>();
        arrAksi.add(new Aksi("Deskripsikan",101,this));
        return arrAksi;
    }

    public void setArrAksi(ArrayList<Aksi> arrAksi) {
        this.arrAksi = arrAksi;
    }



}

