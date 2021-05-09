import java.util.ArrayList;
import java.util.Random;

public class Wilayah extends ElemenGame{
    private String misi;
    private ArrayList<Item> loot = new ArrayList<>();
    private ArrayList<Karakter> monsterDisini = new ArrayList<>();
    private ArrayList<Karakter> arrNPC = new ArrayList<>();
    private ArrayList<NPC> arrWarga = new ArrayList<>();
    protected Karakter karakterAktif;

    public Wilayah (String nama,String deskripsi, String misi){
        super(nama,deskripsi);
        this.misi = misi;
    }

    public void addItem(Item item){
        loot.add(item);
        item.setDiambil(false);
    }

    public void removeItem(Item item){
        loot.remove(item);
        item.setLokasi(null);
    }

    public void initArrAksi (){
        super.initArrAksi();
        arrAksi.add(new Aksi("Interaksi dengan NPC",202,this));
        arrAksi.add(new Aksi("Lihat musuh",302,this));
        arrAksi.add(new Aksi("Serang musuh",402,this));
        arrAksi.add(new Aksi("Lihat item tersedia",502,this));
    }

    public void prosesAksi(int idAksi){
        if (idAksi == 202) {
            this.arrWarga.get(0).interaksi(karakterAktif);
        }
        else if (idAksi == 302) {
            this.lihatMusuh();
        }
        else if (idAksi == 402) {
            this.karakterAktif.BattleSystem(pilihMusuh());
        }
        else if (idAksi == 502) {
            this.lihatItem();
        }
        else
            super.prosesAksi(idAksi);
    }

    public void lihatMusuh(){
        cc = 1;
        for (Karakter o: monsterDisini) {
            System.out.print(cc + ". ");
            o.infoPlayer();
        }
    }

    public void lihatItem(){
        cc = 1;
        for (Item item: loot){
            System.out.printf("%d. %s \n",cc,item.getNama());
            cc++;
        }
        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        Item selectedItem = loot.get(pilih-1);
        selectedItem.pilihanAksi();
    }

    public Karakter pilihMusuh(){
        this.lihatMusuh();
        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        return monsterDisini.get(pilih-1);
    }

    public void addMonster(Karakter monster){
        monsterDisini.add(monster);
    }

    public void removeMonster(Karakter monster){
        monsterDisini.add(monster);
    }

    //Ssetter getter semuanya pokonya semuanya banget
    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Item> loot) {
        this.loot = loot;
    }

    public ArrayList<Karakter> getMonsterDisini() {
        return monsterDisini;
    }

    public void setMonsterDisini(ArrayList<Karakter> monsterDisini) {
        this.monsterDisini = monsterDisini;
        for (Karakter monster : monsterDisini) {
            monster.setLokasi(this);
        }
    }

    public ArrayList<Karakter> getArrNPC() {
        return arrNPC;
    }

    public void setArrNPC(ArrayList<Karakter> arrNPC) {
        this.arrNPC = arrNPC;
    }

    public Karakter getKarakterAktif() {
        return karakterAktif;
    }

    public void setKarakterAktif(Karakter karakterAktif) {
        this.karakterAktif = karakterAktif;
    }

    public ArrayList<NPC> getArrWarga() {
        return arrWarga;
    }

    public void setArrWarga(ArrayList<NPC> arrWarga) {
        this.arrWarga = arrWarga;
    }
}
