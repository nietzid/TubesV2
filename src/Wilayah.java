import java.util.ArrayList;

public class Wilayah extends ElemenGame{
    private String misi;
    private ArrayList<Item> loot = new ArrayList<>();
    private ArrayList<Karakter> monsterDisini = new ArrayList<>();
    private ArrayList<Karakter> arrNPC = new ArrayList<>();
    private NPC warga;

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
        arrAksi.add(new Aksi("interaksi dengan NPC",202,this));
        arrAksi.add(new Aksi("Lihat musuh",302,this));
        arrAksi.add(new Aksi("Serang musuh",402,this));
        arrAksi.add(new Aksi("Lihat item tersedia",502,this));
    }

    public void prosesAksi(int idAksi){
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

}
