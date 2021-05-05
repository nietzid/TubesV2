public class Karakter extends ElemenGame{
    //atribut
    private int hp;
    private int def;
    private int att;
    private int level;
    private int exp;

    //constructor
    public Karakter(String nama, String deskripsi) {
        super(nama,deskripsi);
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

    public void TastoEquip(){

    }
    public void EquiptoTas(){

    }
}