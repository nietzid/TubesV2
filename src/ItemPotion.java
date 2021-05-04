public class ItemPotion extends Item{
    //atribut khusus
    private int efek;

    //constructor
    public ItemPotion(String nama, String deskripsi, int efek) {
        super(nama,deskripsi);
        this.efek = efek;
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

    public void use(Karakter karakter){
        karakter.setHp(karakter.getHp()+efek);
    }
}