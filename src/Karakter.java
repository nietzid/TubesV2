import java.util.ArrayList;

public class Karakter extends ElemenGame{
    //atribut
    private int hp;
    private int def;
    private int att;
    private int level;
    private int exp;
    private int slot = 0;
    private int maxSlot;
    private boolean isAlive = true;
    protected Wilayah lokasi;
    private ArrayList<Item> tas = new ArrayList<>();
    private ArrayList<Item> equipment = new ArrayList<>();

    //constructor
    public Karakter(String nama, String deskripsi, int hp, int def, int att) {
        super(nama,deskripsi);
        this.hp = hp;
        this.def = def;
        this.att = att;
        this.exp = 0;
        this.level = 1;
        maxSlot = 4;
    }

    public void initArrAksi (){
        super.initArrAksi();
        arrAksi.add(new Aksi("Lihat info player",201,this));
        arrAksi.add(new Aksi("Lihat isi tas",301,this));
        arrAksi.add(new Aksi("Lihat perlengkapan yang digunakan ",401,this));
    }

    public void prosesAksi(int idAksi){
        if (idAksi == 201){
            this.infoPlayer();
        }
        else if (idAksi == 301){
            this.lihatTas();
        }else if (idAksi == 401){
            this.lihatPerlengkapan();
        }
        else
            super.prosesAksi(idAksi);
    }

    public void serang(Karakter karakter) {
        int temp = att-karakter.def;
        this.infoPlayer();
        if(temp > 0){
            karakter.hp -= temp;
            System.out.println(this.nama + " Berhasil menyerang " + karakter.getNama() + " sebesar " + (att-karakter.getDef()));
            System.out.println("");
        }else
            System.out.println(this.nama + " Gagal menyerang " + karakter.getNama() );
        System.out.println();
    }

    public void addItem(Item item) {
        item.setDiambil(true);
        tas.add(item);
    }

    public void removeItem(Item item) {
        tas.remove(item);
    }

    public void pungutItem(Item item){
        Wilayah wilayah = item.getLokasi();
        wilayah.removeItem(item);
        tas.add(item);
        item.setPemilik(this);
        item.setDiambil(true);
    }

    public void dropItem(Item item){
        boolean isFind = false;
        for (int i = 0; i < tas.size(); i++){
            if ( tas.get(i).equals(item)){
                lokasi.addItem(item);
                tas.remove(item);
                item.setPemilik(null);
                item.setLokasi(lokasi);
                item.setDiambil(false);
                isFind = true;

            }
        }
        if (!isFind){
            for (int i = 0; i < equipment.size(); i++){
                if ( equipment.get(i).equals(item)){
                    lokasi.addItem(item);
                    equipment.remove(item);
                    item.setPemilik(null);
                    item.setLokasi(lokasi);
                    item.setDiambil(false);
                }
            }
        }
    }

    public void TastoEquip(Item item){
        item.setDipegang(true);
        if (maxSlot-slot >0 ) {
            equipment.add(item);
            tas.remove(item);
            slot++;
        } else System.out.println("Slot Equipment Penuh");
    }

    public void EquiptoTas(Item item){
        item.setDipegang(false);
        tas.add(item);
        equipment.remove(item);
    }

    public void BattleSystem(Karakter bot){ //selipin lv up + npc
        while (this.getHp() > 0 && bot.getHp() > 0){
            int index = (int)(Math.random() * lokasi.getArrNPC().size());
            lokasi.getArrNPC().get(index).serang(bot);
            this.serang(bot);
            bot.serang(this);
        }
        if(bot.getHp() <=0){
            setExp(getExp() + bot.getExp());
            lokasi.getLoot().addAll(bot.tas);
            lokasi.getLoot().addAll(bot.getEquipment());
            lokasi.getMonsterDisini().remove(bot);
            System.out.println(bot.getNama() + " Meninggal");
            lvup();
        }
        else{
            isAlive = false;
            System.out.println(bot.getNama() + " Meninggal");
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
        System.out.println("Nama Player = " + nama);
        System.out.println("Level = " + level);
        System.out.println("Experience Points  = " + exp);
        System.out.println("Health Points  = " + hp);
        System.out.println("Attack Points  = " + att);
        System.out.println("Defense   = " + def);
    }

    public void lihatTas(){
        System.out.println("Item yang ada di dalam tas");
        cc = 1;
        for (Item item: tas){
            System.out.printf("%d. %s (%s)\n",cc,item.getNama(),item.getKemampuan());
            cc++;
        }
        System.out.println("0. Kembali");
        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        if(pilih!=0) {
            Item selectedItem = tas.get(pilih - 1);
            selectedItem.pilihanAksi();
        }
    }

    public void lihatPerlengkapan(){
        System.out.println("Perlengkapan sedang yang digunakan");
        cc = 1;
        for (Item item : equipment) {
            System.out.printf("%d. %s (%s)\n", cc, item.getNama(),item.getKemampuan());
            cc++;
        }
        System.out.println("0. Kembali");
        System.out.println("Masukkan pilihan: ");
        int pilih = in.nextInt();
        if(pilih!=0) {
            Item selectedItem = equipment.get(pilih - 1);
            selectedItem.pilihanAksi();
        }
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
        for (Item item: tas) {
            item.setDiambil(true);
        }
    }

    public ArrayList<Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Item> equipment) {
        this.equipment = equipment;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}