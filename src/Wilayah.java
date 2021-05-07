import java.util.ArrayList;
import java.util.Random;

public class Wilayah extends ElemenGame{
    private String misi;
    private ArrayList<Item> loot = new ArrayList<>();
    private ArrayList<Karakter> monsterDisini = new ArrayList<>();
    private ArrayList<Karakter> arrNPC = new ArrayList<>();
    private NPC warga;
    protected Karakter karakterAktif;

    public Wilayah (String nama,String deskripsi, String misi, NPC warga){
        super(nama,deskripsi);
        this.misi = misi;
        this.warga = warga;
    }

    public void addItem(Item item){
        loot.add(item);
    }

    public void removeItem(Item item){
        loot.remove(item);
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
            this.warga.interaksi(karakterAktif);
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
        cc = 0;
        for (Karakter o: monsterDisini) {
            System.out.print(cc + ". ");
            o.infoPlayer();
        }
    }

    public void lihatItem(){
        cc=1;
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
    }

    public ArrayList<Karakter> getArrNPC() {
        return arrNPC;
    }

    public void setArrNPC(ArrayList<Karakter> arrNPC) {
        this.arrNPC = arrNPC;
    }

    public NPC getWarga() {
        return warga;
    }

    public void setWarga(NPC warga) {
        this.warga = warga;
    }

    public Karakter getKarakterAktif() {
        return karakterAktif;
    }

    public void setKarakterAktif(Karakter karakterAktif) {
        this.karakterAktif = karakterAktif;
    }
}
