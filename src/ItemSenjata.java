public class ItemSenjata extends Item{
    //atribut khusus
    private int att;

    //constructor
    public ItemSenjata(String nama, String deskripsi, Karakter pemilik, int att) {
        super(nama,deskripsi,pemilik);
        this.att = att;
    }
    public ItemSenjata(String nama, String deskripsi, Wilayah lokasi, int att) {
        super(nama,deskripsi,lokasi);
        this.att = att;
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
        pemilik.setAtt(pemilik.getAtt()+att);
    }

    public void disuse(){
        super.disuse();
        pemilik.setAtt(pemilik.getAtt()-att);
    }

    //getter setter
    public int getAtt() { return att; }

    public void setAtt(int att) {
        this.att = att;
    }

    public void printItem(){
        System.out.println("Senjata ini memiliki kekuatan sebesar " + att );
    }
}
