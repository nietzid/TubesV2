public class ItemSenjata extends Item{
    //atribut khusus
    private int att;

    //constructor
    public ItemSenjata(String nama, String deskripsi, int att) {
        super(nama,deskripsi);
        this.att = att;
    }

    //getter setter
    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public void printItem(){
        System.out.println("Senjata ini memiliki kekuatan sebesar " + att );
    }

    public void use(Karakter karakter){
        karakter.setAtt(karakter.getAtt()+att);
    }
}
