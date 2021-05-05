import java.util.ArrayList;
import java.util.Scanner;

public class Karakter extends ElemenGame{
    //atribut
    private int hp;
    private int def;
    private int att;
    private int level;
    private int exp;
    private int slot;
    private int maxSlot;
    protected Wilayah lokasi;
    private ArrayList<Item> tas = new ArrayList<>();
    private ArrayList<Item> equipment = new ArrayList<>();

    //constructor
    public Karakter(String nama, String deskripsi, Wilayah lokasi, int hp, int def, int att) {
        super(nama,deskripsi);
        this.hp = hp;
        this.def = def;
        this.att = att;
        this.exp = 0;
        this.level = 1;
        maxSlot = 4;
        this.lokasi = lokasi;
    }

    public void initArrAksi (){
        super.initArrAksi();
        arrAksi.add(new Aksi("Lihat info player",201,this));
        arrAksi.add(new Aksi("Lihat isi tas",301,this));
    }

    public void prosesAksi(int idAksi){
        if (idAksi == 201){
            this.infoPlayer();
        }
        else if (idAksi == 301){
            this.lihatTas();
        }
    }

    public void serang(Karakter karakter) {
        karakter.hp -= att-karakter.def;
    }

    public void addItem(Item item) {
        tas.add(item);
    }

    public void removeItem(Item item) {
        tas.remove(item);
    }

    public void pungutItem(Item item){
        Wilayah wilayah = item.getLokasi();
        wilayah.removeItem(item);
        tas.add(item);
    }

    public void dropItem(Item item){
        boolean isFind = false;
        for (int i = 0; i < tas.size(); i++){
            if ( tas.get(i).equals(item)){
                lokasi.addItem(item);
                tas.remove(item);
                isFind = true;
            }
        }
        if (!isFind){
            for (int i = 0; i < equipment.size(); i++){
                if ( equipment.get(i).equals(item)){
                    lokasi.addItem(item);
                    equipment.remove(item);
                    isFind = true;
                }
            }
        }
    }

    public void TastoEquip(Item item){
        if (maxSlot-slot >0 ) {
            System.out.println("Slot tersisa saat ini " + (maxSlot - slot) + " slot");
            equipment.add(item);
            tas.remove(item);
        } else System.out.println("Slot Equipment Penuh");
    }

    public void EquiptoTas(Item item){
        tas.add(item);
        equipment.remove(item);
    }

    public void BattleSystem(Karakter bot){ //selipin lv up + npc
        while (this.getHp() > 0 && bot.getHp() > 0){
            int index = (int)(Math.random() * lokasi.getArrNPC().size());
            this.serang(lokasi.getArrNPC().get(index));
            bot.serang(this);
        }
        if(bot.getHp() <=0){
            setExp(getExp() + bot.getExp());
            lokasi.getLoot().addAll(bot.tas);
            lokasi.getLoot().addAll(bot.getEquipment());
            lokasi.getMonsterDisini().remove(bot);
            lvup();
        }
        else{
            //disini harusnya game over
        }
    }

    public void lvup(){
        this.level++;
        this.exp=0;
        this.att+=10;
        this.def+=10;
        this.hp+=10;
        if (maxSlot<=8)
            this.maxSlot++;
    }

    public void infoPlayer(){
        System.out.println("level = " + level);
        System.out.println("exp = " + exp);
        System.out.println("hp = " + hp);
        System.out.println("att = " + att);
        System.out.println("def = " + def);
        this.pilihanAksi();
        for (Item item: equipment){
            System.out.printf("%d. %s \n",cc,item.getNama());
            cc++;
        }

        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        Item selectedItem = equipment.get(pilih-1);
        selectedItem.pilihanAksi();
    }

    public void lihatTas(){
        for (Item item: tas){
            System.out.printf("%d. %s \n",cc,item.getNama());
            cc++;
        }
        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        Item selectedItem = tas.get(pilih-1);
        selectedItem.pilihanAksi();
    }

    //getter setter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    public Wilayah getLokasi() {
        return lokasi;
    }

    public void setLokasi(Wilayah lokasi) {
        this.lokasi = lokasi;
    }

    public ArrayList<Item> getTas() {
        return tas;
    }

    public void setTas(ArrayList<Item> tas) {
        this.tas = tas;
    }

    public ArrayList<Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Item> equipment) {
        this.equipment = equipment;
    }
}