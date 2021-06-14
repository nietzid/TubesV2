public class ItemArmor extends Item{
    //atribut khusus
    private int def;

    //constructor
    public ItemArmor(String nama, String deskripsi, Karakter pemilik, int def) {
        super(nama,deskripsi,pemilik);
        this.def = def;
        kemampuan = "+" + def + " Defense";
    }
    public ItemArmor(String nama, String deskripsi, Wilayah lokasi, int def) {
        super(nama,deskripsi,lokasi);
        this.def = def;
        kemampuan = "+" + def + " Defense";
    }

    public void prosesAksi(int idAksi) {
        if (idAksi == 102) {
            this.printItem();
        }
        else if (idAksi == 201){
            this.disuse();
        }
        else if (idAksi == 202) {
            this.use();
        }
        else{
            super.prosesAksi(idAksi);
        }
    }

    public void use(){
        super.use();
        pemilik.setDef(pemilik.getDef()+def);
    }

    public void disuse(){
        super.disuse();
        pemilik.setDef(pemilik.getDef()-def);
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
}