import java.util.ArrayList;

public class Item extends ElemenGame{
    public Item(String deskripsi, String nama) {
        super(deskripsi,nama);
    }

    //prosedur untuk mengisi aksi
    public void initArrAksi (){
        ArrayList<Aksi> arrAksi = new ArrayList<>();
        arrAksi.add(new Aksi("Deskripsikan",201,this));
    }

    //prosedur proses aksi
    public void prosesAksi(int idAksi){
        if (idAksi == 201){
            System.out.printf("Deskripsi: %s \n",deskripsi);
        }
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
    }
}