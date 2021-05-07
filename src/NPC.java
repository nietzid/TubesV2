import java.util.ArrayList;
import java.util.Scanner;

public class NPC extends ElemenGame{
    private ArrayList<Item> loot = new ArrayList<>();
    private Wilayah wilAktif;
    private boolean isKnow = false;

    public NPC(String nama, String deskripsi, Wilayah wilAktif){
        super(nama, deskripsi);
        this.wilAktif = wilAktif;
    }

    public void interaksi(Karakter karakter){
        System.out.println("halo " +karakter.nama);
        System.out.println("Selamat datang di wilayah " +wilAktif.nama);
        System.out.println("wilayah ini adalah " +wilAktif.deskripsi);
        System.out.println("anda ditugaskan untuk membunuh semua monster yang ada disini");
        System.out.println("agar bisa menyelamatkan seluruh dunia ini");
        System.out.println("untuk bisa membantu mengalahkan musuh anda harus memiliki item yang kuat");
    }

    @Override
    public void initArrAksi() {
        super.initArrAksi();
        arrAksi.add(new Aksi("kenalan dengan NPC", 103, this));
        arrAksi.add(new Aksi("lihat item yang dimiliki NPC",203,this));
        arrAksi.add(new Aksi("minta item dari npc", 303, this));
    }

    public void prosesAksi(int idAksi) {
        if (idAksi == 103) {
            interaksi(Karakter);
            isKnow = true;
        }else if (idAksi == 203) {
            if(isKnow){
                printItem();
            }else {
                System.out.println("kenalan dulu yuk dangan NPC");
            }
        }else if (idAksi == 303){
            if(isKnow){
                giveItem(Item, Karakter);
            }else {
                System.out.println("kenalan dulu yuk dangan NPC");
            }
        }
    }

    public void printItem(){
        for (Item item: loot){
            System.out.printf("%d. %s \n",cc,item.getNama());
            cc++;
        }
    }

    public void giveItem(Item item, Karakter karakter){
        karakter.addItem(item);
        loot.remove(item);
        if (loot.isEmpty()){
            System.out.println("Item sudah diberikan semua");
        }
    }

    public void addItem(Item item){
        loot.add(item);
    }

}
