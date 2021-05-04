public class ItemPotion extends Item{
    //atribut khusus
    private int nilaiEfek;

    //constructor
    public ItemPotion(String nama, String deskripsi, int nilaiEfek) {
        super(nama,deskripsi);
        this.nilaiEfek = nilaiEfek;
    }

    //getter setter
    public int getNilaiEfek() {
        return nilaiEfek;
    }

    public void setNilaiEfek(int nilaiEfek) {
        this.nilaiEfek = nilaiEfek;
    }

    public void printItem(){
        System.out.println("Potion ini dapat memulihkan hp sebesar " + nilaiEfek );
    }

    public void use(Karakter karakter){
        karakter.setHp(karakter.getHp()+nilaiEfek);
    }
}