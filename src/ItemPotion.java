public class ItemPotion extends Item{
    //atribut khusus
    private int efek;

    //constructor
    public ItemPotion(String nama, String deskripsi, Karakter pemilik, int efek) {
        super(nama,deskripsi,pemilik);
        this.efek = efek;
        kemampuan = "+" + efek + " HP";
    }
    public ItemPotion(String nama, String deskripsi, Wilayah lokasi, int efek) {
        super(nama,deskripsi,lokasi);
        this.efek = efek;
        kemampuan = "+" + efek + " HP";
    }

    public void prosesAksi(int idAksi) {
        if (idAksi == 102) {
            this.printItem();
        }
        else if (idAksi == 201) {
            this.use();
        }
        else{
            super.prosesAksi(idAksi);
        }
    }

    public void use(){
        super.use();
        pemilik.setHp(pemilik.getHp()+efek);
    }

    //getter setter
    public int getEfek() {
        return efek;
    }

    public void setEfek(int efek) {
        this.efek = efek;
    }

    public void printItem(){
        System.out.println("Potion ini dapat memulihkan hp sebesar " + efek );
    }
}