import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    protected ArrayList<Aksi> arrAksi = new ArrayList<>();
    Wilayah wilAktif;
    //bikin player
    Karakter player = new Karakter("Arfi", "Seorang Petualang", 1000, 90, 100);
    ArrayList<Item> tasPlayer = new ArrayList<>();
    ItemSenjata pedang = new ItemSenjata("Pedang Pendek", "Sebuah pedang yang tidak panjang", player, 30);
    ItemPotion ramuanSehat = new ItemPotion("Ramuan Kesehatan", "Sebuah ramuan untuk menambahkan kesehatan", player, 35);

    //bikin NPC
    ArrayList<Karakter> listNPC = new ArrayList<>();
    Karakter npc1 = new Karakter("Oik", "Teman sang petualang yang membantu melawan musuh", 800, 90, 70);
    ArrayList<Item> tasNPC1 = new ArrayList<>();
    ItemSenjata pedangKayu = new ItemSenjata("Pedang kayu", "Sebuah pedang kayu", npc1, 20);
    ItemArmor perisai = new ItemArmor("Perisai", "Perisai biasa", npc1, 10);

    Karakter npc2 = new Karakter("Howl", "Teman sang petualang yang membantu melawan musuh", 800, 90, 70);
    ArrayList<Item> tasNPC2 = new ArrayList<>();
    ItemSenjata tongkatSihir = new ItemSenjata("Tongkat Sihir", "Tongkat sihir untuk memberi damage kepada musuh", npc2, 50);
    ItemArmor jubah = new ItemArmor("Jubah", "Sebuah jubah pelindung", npc2, 10);

    Karakter npc3 = new Karakter("Alice", "", 800, 90, 70);
    ArrayList<Item> tasNPC3 = new ArrayList<>();
    ItemArmor perisaiBesi = new ItemArmor("Perisai Besi", "Sebuah perisai besi", npc1, 10);
    ItemSenjata pedangPanjang = new ItemSenjata("Pedang Besi", "Pedang besi panjang", npc3, 80);

    //bikin Wilayah
    ArrayList<Wilayah> arrWilayah = new ArrayList<>();
    //wilayah 1
    Wilayah wilayah1 = new Wilayah("Epilysi", "Wilayah pemukiman warga Katara yang gelap gulita, hanya terdapat beberapa gubuk tak berpenghuni.", "Basmi monster yang kamu temui, dan cari petunjuk serta akses untuk menuju wilayah selanjutnya.");
    ArrayList<NPC> arrWarga1 = new ArrayList<>();
    NPC wargaWil1 = new NPC("Budi", "Warga yang ada di wilayah 1", wilayah1);
    ArrayList<Karakter> listMonster1 = new ArrayList<>();
    Karakter monsterKatak = new Karakter("Monster Katak", "Monster katak raksasa dengan mata merah dan lidah panjang", 200, 50, 30);
    Karakter pocong = new Karakter("Pocong", "Terlihat mengemaskan walau ternyata menyeramkan", 250, 50, 90);
    ArrayList<Item> listItem1 = new ArrayList<>();
    ItemSenjata panah = new ItemSenjata("Geenna Arrow", "Sebuah panah degan ujung busurnya terdapat api", wilayah1, 80);
    ItemSenjata pisau = new ItemSenjata("Pisau", "Sebuah pisau biasa", wilayah1, 40);
    ItemPotion ramuan1 = new ItemPotion("Ramuan Biasa", "Ramuan untuk menambah kesehatan", wilayah1, 15);
    Item sendal = new Item("Sandal legendaris", "Sebuah sandal yang pernah dipakai Superman");
    ItemSenjata panahKayu = new ItemSenjata("Panah Kayu", "Sebuah panah yang tidak sengaja ditemukan", monsterKatak, 20);
    ItemArmor perisaiKayu = new ItemArmor("Perisai Kayu", "Sebuah perisai yang terbuat dari kayu", pocong, 33);

    //wilayah2
    Wilayah wilayah2 = new Wilayah("Limni", "Terdapat danau mati yang berwarna merah dan dikelilingi hutan misterius.", "Temukan item di dasar danau, basmi semua monster yang ada dan cari akses untuk menuju wilayah selanjutnya");
    ArrayList<NPC> arrWarga2 = new ArrayList<>();
    NPC wargaWil2 = new NPC("Andi", "Seorang warga penjaga danau", wilayah2);
    ArrayList<Karakter> listMonster2 = new ArrayList<>();
    Karakter naga = new Karakter("Naga Lit", "Naga dengan serangan semburan api", 300, 70, 90);
    Karakter silumanUlar = new Karakter("Nagini", "Siluman ular yang dapat melilit lawannya", 550, 80, 100);
    ArrayList<Item> listItem2 = new ArrayList<>();
    ItemPotion gillyweed =  new ItemPotion("Gillyweed", "Tumbuhan yang bisa membuat manusia bernapas di dalam air", wilayah2, 70);
    ItemSenjata trisula = new ItemSenjata("Trisula Poseiden", "Trisula ajaib yang bisa melawan musuh", wilayah2, 90);
    Item penggaris = new Item("Penggaris", "Penggaris 30 cm yang sangat berguna");
    ItemSenjata katapel = new ItemSenjata("Katapel", "Senjara jarak jauh yang tidak begitu kuat", naga, 40);
    ItemSenjata palu = new ItemSenjata("Palu", "Palu yang mendapat kekuatan ajaib", silumanUlar, 41);


    //wilayah 3
    Wilayah wilayah3 = new Wilayah("Vouno", "Wilayah yang terdapat pegunungan dengan pohon yang sangat tinggi juga gelap gulita.", "Cari dan tebang pohon kehidupan iblis, basmi semua monster dan temukan akses untuk menuju wilayah selanjutnya");
    ArrayList<NPC> arrWarga3 = new ArrayList<>();
    NPC wargaWil3 = new NPC("Wuddy", "Seorang warga yang tinggal di dekat pegunungan", wilayah3);
    ArrayList<Karakter> listMonster3 = new ArrayList<>();
    Karakter troll = new Karakter("Troll", "Monster berwarna hijau tinggi juga memiliki lendir", 400, 90, 90); //bisa lansung diisi disini
    Karakter kuyang = new Karakter("Kuyang", "Hantu yang hanya memiliki kepala", 500, 90, 100);
    ArrayList<Item> listItem3 = new ArrayList<>();
    ItemSenjata venenoso =new ItemSenjata("Venenoso", "Pedang beracun yang perlahan akan membunuh musuhh", wilayah3, 60);
    ItemArmor baju = new ItemArmor("Baju Zirah", "Baju zirah untuk melindungi dari serangan musuh", wilayah3, 45);
    ItemSenjata kapak = new ItemSenjata("Kapak Aquein", "Sebuah kapak besi panas untuk melawan musuh", wilayah3, 100);
    Item sendok = new Item("Sendok", "Sebuah alat makan");
    ItemSenjata gada = new ItemSenjata("Gada", "Sebuah senjata dengan kepala bundar yang dipasang pada sebuah batang, dengan duri di atasnya", troll, 90);
    ItemSenjata keris = new ItemSenjata("Keris Mpu Gandring", "senjata tikam golongan belati dengan banyak fungsi budaya yang dikenal di kawasan Nusantara bagian barat dan tengah", kuyang, 150);

    // wilayah 4
    Wilayah wilayah4 = new Wilayah("Spilaio", "Goa yang sangat curam dan menyeramkan, satu satunya akses menuju wilayah terakhir yaitu Diavolos", "Temukan petunjuk kelemahan iblis dan kumpulkan senjata sebanyak mungkin untuk melawan raja iblis");
    ArrayList<NPC> arrWarga4 = new ArrayList<>();
    NPC wargaWil4 = new NPC("Bussi", "Warga yang tinggal di Goa selama 100 tahun",wilayah4);
    ArrayList<Karakter> listMonster4 = new ArrayList<>();
    Karakter monsterLintah = new Karakter("Monster Lintah", "Lintah raksasa yang dapat meghisap darah manusia", 450, 90, 100);
    Karakter penyihir = new Karakter("Wizard", "Penyihir yang mengutuk dengan matra dan tongkat sihirnya", 600, 90, 100);
    Karakter kuntilanak = new Karakter("Kuntilanak", "Monster yang berasal dari urban legend Indonesia", 300, 90, 500);
    ArrayList<Item> listItem4 = new ArrayList<>();
    ItemSenjata sabit = new ItemSenjata("Sabit", "Pisau melengkung menyerupai bulan sabit", wilayah4, 20);
    ItemPotion jasjus = new ItemPotion("Jasjus", "Minuman penyegar dahaga", wilayah4, 15);
    Item senter = new Item("Senter", "Senter untuk menerangi jalan");
    ItemSenjata pedangPermata = new ItemSenjata("Pedang Permata", "Sebuah pedang yang terbuat dari permata untuk mengalahkan Raja Iblis", penyihir, 100);
    ItemSenjata bambuRuncing = new ItemSenjata("Bambu Runcing", "Sebuah senjata yang terbuat dari bahan bambu yang diruncingkan", kuntilanak, 70);
    ItemSenjata tombak = new ItemSenjata("Tombak", "Sebuah tongkat senjata uuntuk berburu dan berperang", monsterLintah, 80);


    // wilayah 5
    Wilayah wilayah5 = new Wilayah("Diavolos", "Tempat paling meyeramkan di Katara, tempat singgasananya sang iblis.", "Lawan Raja Iblis dan bala tentaranya untuk membebaskan negara dari kutukan");
    ArrayList<NPC> arrWarga5 = new ArrayList<>();
    NPC wargaWil5 = wargaWil5 = new NPC("Jesi", "Seorang warga yang tinggal dekat dengan Diavolos", wilayah5);
    ArrayList<Karakter> listMonster5 = new ArrayList<>();
    Karakter raja = new Karakter("Sukuni", "Sang Raja Iblis yang mengutuk negara Katara", 900, 90, 200);
    Karakter elf = new Karakter("Elf", "Elf bala tentara sang Raja Iblis", 300, 90, 80);
    Karakter dwarf = new Karakter("Dwarf", "Dwarf bala tentara sang Raja Iblis", 300, 90, 90);
    ArrayList<Item> listItem5 = new ArrayList<>();
    ItemSenjata celurit = new ItemSenjata("Celurit", "Senjata yang melengkung mirip bulan sabit digunakan untuk menyerang",wilayah5, 80);
    ItemArmor vestlv3 = new ItemArmor("Baju Pelindung lv 3", "Sebuah baju pelindung yang sangat kuat", wilayah5, 600);
    Item topi = new Item("Topi", "Topi untuk melindungi dari panas matahari");
    ItemSenjata kerisKayu = new ItemSenjata("Keris", "Keris yang terbuat dari kayu", dwarf, 70);
    ItemSenjata dynamite = new ItemSenjata("Dynamite", "Sebuah bom yang akan meledakkan kutukan dari Raja Iblis", elf, 250);

    public void initArrAksi(){
        arrAksi.clear();
        arrAksi.add(new Aksi("Aksi Player",101,this));
        arrAksi.add(new Aksi("Aksi di wilayah",201,this));
    }

    public void prosesAksi(int idAksi){
        if(idAksi == 101){
            player.pilihanAksi();
        }
        else if(idAksi == 201){
            wilAktif.pilihanAksi();
        }
    }

    public void pilihanAksi(){
        Scanner scanner = new Scanner(System.in);

        initArrAksi();
        System.out.println("Selamat datang di " + wilAktif.getNama()+ "!");
        int cc=1;
        for (Aksi aksi: arrAksi){
            System.out.printf("%d. %s \n",cc,aksi.getNamaAksi());
            cc++;
        }

        System.out.print("Masukkan pilihan: ");
        int pilih = scanner.nextInt();

        System.out.println("****************************");
        arrAksi.get(pilih-1).eksekusiAksi();
    }

    public void initPlayer() {
        tasPlayer.add(pedang);
        tasPlayer.add(ramuanSehat);
        player.setTas(tasPlayer);
    }

    public void initNPC() {
        tasNPC1.add(pedangKayu);
        tasNPC1.add(perisai);
        npc1.setTas(tasNPC1);

        tasNPC2.add(tongkatSihir);
        tasNPC2.add(jubah);
        npc2.setTas(tasNPC2);

        tasNPC3.add(perisaiBesi);
        tasNPC3.add(pedangPanjang);
        npc3.setTas(tasNPC3);

        listNPC.add(npc1);
        listNPC.add(npc2);
        listNPC.add(npc3);
    }
    public void initWilayah() {
        //wilayah 1
        arrWarga1.add(wargaWil1);
        wilayah1.setArrWarga(arrWarga1);
        wargaWil1.addItem(sendal);
        listMonster1.add(monsterKatak);
        monsterKatak.addItem(panahKayu);
        panahKayu.use();
        listMonster1.add(pocong);
        pocong.addItem(perisaiKayu);
        perisaiKayu.use();
        listItem1.add(panah);
        listItem1.add(pisau);
        listItem1.add(ramuan1);
        wilayah1.setMonsterDisini(listMonster1);
        wilayah1.setLoot(listItem1);
        arrWilayah.add(wilayah1);

        // wilayah 2
        arrWarga2.add(wargaWil2);
        wilayah2.setArrWarga(arrWarga2);
        wargaWil2.addItem(penggaris);
        listMonster2.add(naga);
        naga.addItem(katapel);
        katapel.use();
        listMonster2.add(silumanUlar);
        silumanUlar.addItem(palu);
        palu.use();
        listItem2.add(gillyweed);
        listItem2.add(trisula);
        wilayah2.setMonsterDisini(listMonster2);
        wilayah2.setLoot(listItem2);
        arrWilayah.add(wilayah2);

        // wilayah 3
        arrWarga3.add(wargaWil3);
        wilayah3.setArrWarga(arrWarga3);
        wargaWil3.addItem(sendok);
        listMonster3.add(troll);
        troll.addItem(gada);
        gada.use();
        listMonster3.add(kuyang);
        kuyang.addItem(keris);
        keris.use();
        listItem3.add(venenoso);
        listItem3.add(baju);
        listItem3.add(kapak);
        wilayah3.setMonsterDisini(listMonster3);
        wilayah3.setLoot(listItem3);
        arrWilayah.add(wilayah3);


        //wilayah 4
        arrWarga4.add(wargaWil4);
        wilayah4.setArrWarga(arrWarga4);
        wargaWil4.addItem(senter);
        listMonster4.add(monsterLintah);
        listMonster4.add(penyihir);
        penyihir.addItem(pedangPermata);
        pedangPermata.use();
        listMonster4.add(kuntilanak);
        kuntilanak.addItem(bambuRuncing);
        bambuRuncing.use();
        listItem4.add(sabit);
        listItem4.add(jasjus);
        wilayah4.setMonsterDisini(listMonster4);
        wilayah4.setLoot(listItem4);
        arrWilayah.add(wilayah4);


        // wilayah 5
        wargaWil5 = new NPC("Jesi", "Seorang warga yang tinggal dekat dengan Diavolos", wilayah5);
        listMonster5.add(raja);
        listMonster5.add(elf);
        listMonster5.add(dwarf);
        dwarf.addItem(kerisKayu);
        kerisKayu.use();
        listItem5.add(celurit);
        listItem5.add(vestlv3);
        wilayah5.setMonsterDisini(listMonster5);
        wilayah5.setLoot(listItem5);
        arrWilayah.add(wilayah5);
    }

    public void cekWilayah(){
        if(wilAktif.getMonsterDisini().size()==0){
            int getposition;
//            wilAktif =

        }
    }

    public void setWilayahAktif(Wilayah wilayahAktif){
        wilayahAktif.setKarakterAktif(player);
        player.setLokasi(wilayahAktif);
        wilayahAktif.setArrNPC(listNPC);
        for (Karakter k : listNPC) {
            k.setLokasi(wilayahAktif);
        }
        wilAktif = wilayahAktif;
    }

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.initPlayer();
        gameEngine.initNPC();
        gameEngine.initWilayah();
        while(gameEngine.player.isAlive()){
            gameEngine.setWilayahAktif(gameEngine.wilayah1);
            gameEngine.pilihanAksi();
        }
        System.out.println(gameEngine.wilayah2.getArrWarga().get(0).getLoot());
    }
}
