public class ItemArmor extends Item{
    //atribut khusus
    private int def;

    //constructor
    public ItemArmor(String nama, String deskripsi, int def) {
        super(nama,deskripsi);
        this.def = def;
    }

    //getter setter
    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void printItem(){
        System.out.println("Armor ini memiliki defense power sebesar " + def);
    }

    public void use(Karakter karakter){
        karakter.setDef(karakter.getDef()+def);
    }
}