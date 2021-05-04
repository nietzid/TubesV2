public class Item extends ElemenGame{
    public Item(String deskripsi, String nama) {
        super(deskripsi,nama);
    }

    public void printItem(){
        System.out.printf("############ %s ############\n", getNama());
        System.out.println(""+getDeskripsi());
    }

    public void use(Karakter karakter){
        karakter.TastoEquip();
    }
}