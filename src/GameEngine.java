import java.util.ArrayList;
import java.util.List;

public class   GameEngine {
    public static void main(String[] args) {
        //bikin player
        Karakter player = new Karakter("Arfi","Seorang Petualang", 1000,90,100);
        ArrayList<Item> tasPlayer = new ArrayList<>();
        ItemSenjata pedang = new ItemSenjata("Pedang Pendek", "Sebuah pedang yang tidak panjang", player, 30);
        ItemPotion ramuanSehat = new ItemPotion("Ramuan Kesehatan", "Sebuah ramuan untuk menambahkan kesehatan", player, 35);
        tasPlayer.add(pedang);
        tasPlayer.add(ramuanSehat);
        player.setTas(tasPlayer);


        /// bikin npc
        ArrayList<Karakter> listNPC =  new ArrayList<>();
        Karakter npc1 = new Karakter("Oik", "Teman sang petualang yang membantu melawan musuh", 800, 90, 70);
        ArrayList<Item> tasNPC1 = new ArrayList<>();
        ItemSenjata pedangKayu = new ItemSenjata("Pedang kayu", "Sebuah pedang kayu", npc1, 20);
        ItemArmor perisai = new ItemArmor("Perisai", "Perisai biasa", npc1, 10);
        tasNPC1.add(pedangKayu);
        tasNPC1.add(perisai);
        npc1.setTas(tasNPC1);
        Karakter npc2 = new Karakter("Howl", "Teman sang petualang yang membantu melawan musuh", 800, 90, 70);
        ArrayList<Item> tasNPC2 = new ArrayList<>();
        ItemSenjata tongkatSihir = new ItemSenjata("Tongkat Sihir", "Tongkat sihir untuk memberi damage kepada musuh", npc2, 50);
        ItemArmor jubah = new ItemArmor("Jubah", "Sebuah jubah pelindung", npc2, 10);
        tasNPC2.add(tongkatSihir);
        tasNPC2.add(jubah);
        npc2.setTas(tasNPC2);
        Karakter npc3 = new Karakter("Alice", "", 800, 90, 70);
        ArrayList<Item> tasNPC3 = new ArrayList<>();
        ItemArmor perisaiBesi = new ItemArmor("Perisai Besi", "Sebuah perisai besi", npc1, 10);
        ItemSenjata pedangPanjang = new ItemSenjata("Pedang Besi", "Pedang besi panjang", npc3, 80);
        tasNPC3.add(perisaiBesi);
        tasNPC3.add(pedangPanjang);
        npc3.setTas(tasNPC3);
        listNPC.add(npc1);
        listNPC.add(npc2);
        listNPC.add(npc3);


        //wilayah 1
        NPC wargaWil1 = null; //kalo ini gabisa diisi disini
        ArrayList<Karakter> listMonster1 = new ArrayList<>();
        Karakter monsterKatak = new Karakter("Monster Katak", "Monster katak raksasa dengan mata merah dan lidah panjang", 200, 50, 30);
        Karakter pocong = new Karakter("Pocong", "Terlihat mengemaskan walau ternyata menyeramkan", 250, 50, 90);
//        ItemSenjata
        listMonster1.add(monsterKatak);
        listMonster1.add(pocong);
        ArrayList<Item> listItem1 = new ArrayList<>();
        ItemSenjata panah  = null; //gabisa diisi disini
        ItemSenjata pisau = null;
        ItemPotion ramuan1 = null;
        listItem1.add(panah);
        listItem1.add(pisau);
        listItem1.add(ramuan1);
        Wilayah wilayah1 = new Wilayah("Epilysi","Wilayah pemukiman warga Katara yang gelap gulita, hanya terdapat beberapa gubuk tak berpenghuni.","Basmi monster yang kamu temui, dan cari petunjuk serta akses untuk menuju wilayah selanjutnya.", wargaWil1);
        wargaWil1 = new NPC("Budi","Warga yang ada di wilayah 1", wilayah1);
        panah = new ItemSenjata("Geenna Arrow","Sebuah panah degan ujung busurnya terdapat api", wilayah1,80);
        pisau = new ItemSenjata("Pisau", "Sebuah pisau biasa", wilayah1, 40);
        ramuan1 = new ItemPotion("Ramuan Biasa", "Ramuan untuk menambah kesehatan", wilayah1, 15);
        wilayah1.setKarakterAktif(player);
        player.setLokasi(wilayah1);
        wilayah1.setMonsterDisini(listMonster1);
        wilayah1.setLoot(listItem1);
        wilayah1.setArrNPC(listNPC);
        for (Karakter k: listNPC) {
            k.setLokasi(wilayah1);
        }


        // wilayah 2
        NPC wargaWil2 = null;
        ArrayList<Karakter> listMonster2 = new ArrayList<>();
        Karakter naga = new Karakter("Naga Lit", "Naga dengan serangan semburan api", 300, 70, 90);
        Karakter silumanUlar = new Karakter("Nagini", "Siluman ular yang dapat melilit lawannya", 550, 80, 100);
        listMonster2.add(naga);
        listMonster2.add(silumanUlar);
        ArrayList<Item> listItem2 = new ArrayList<>();
        ItemPotion gillyweed = null;
        ItemSenjata trisula  = null;
        listItem2.add(gillyweed);
        listItem2.add(trisula);
        Wilayah wilayah2 = new Wilayah("Limni","Terdapat danau mati yang berwarna merah dan dikelilingi hutan misterius.","Temukan item di dasar danau, basmi semua monster yang ada dan cari akses untuk menuju wilayah selanjutnya", wargaWil2);
        wargaWil2 = new NPC("Andi","Seorang warga penjaga danau", wilayah2);
        gillyweed = new ItemPotion("Gillyweed","Tumbuhan yang bisa membuat manusia bernapas di dalam air", wilayah2,70);
        trisula = new ItemSenjata("Trisula Poseiden", "Trisula ajaib yang bisa melawan musuh", wilayah2, 90);
        wilayah2.setKarakterAktif(player);
        player.setLokasi(wilayah2);
        wilayah2.setMonsterDisini(listMonster2);
        wilayah2.setLoot(listItem2);
        wilayah2.setArrNPC(listNPC);
        for (Karakter k: listNPC) {
            k.setLokasi(wilayah2);
        }


        // wilayah 3
        NPC wargaWil3 = null;
        ArrayList<Karakter> listMonster3 = new ArrayList<>();
        Karakter troll = new Karakter("Troll", "Monster berwarna hijau tinggi juga memiliki lendir", 400, 90, 90); //bisa lansung diisi disini
        Karakter kuyang = new Karakter("Kuyang", "Hantu yang hanya memiliki kepala", 500, 90, 100);
        listMonster3.add(troll);
        listMonster3.add(kuyang);
        ArrayList<Item> listItem3 = new ArrayList<>();
        ItemSenjata venenoso = null;
        ItemSenjata kapak = null;
        ItemArmor baju = null;
        listItem2.add(venenoso);
        listItem2.add(baju);
        listItem2.add(kapak);
        Wilayah wilayah3 = new Wilayah("Vouno","Wilayah yang terdapat pegunungan dengan pohon yang sangat tinggi juga gelap gulita.","Cari dan tebang pohon kehidupan iblis, basmi semua monster dan temukan akses untuk menuju wilayah selanjutnya", wargaWil3);
        wargaWil3 = new NPC("Wuddy","Seorang warga yang tinggal di dekat pegunungan", wilayah3);
        venenoso = new ItemSenjata("Venenoso","Pedang beracun yang perlahan akan membunuh musuhh", wilayah3,60);
        baju = new ItemArmor("Baju Zirah", "Baju zirah untuk melindungi dari serangan musuh", wilayah3, 45);
        kapak = new ItemSenjata("Kapak Aquein", "Sebuah kapak besi panas untuk melawan musuh", wilayah3,100);
        wilayah3.setKarakterAktif(player);
        player.setLokasi(wilayah3);
        wilayah3.setMonsterDisini(listMonster3);
        wilayah3.setLoot(listItem3);
        wilayah3.setArrNPC(listNPC);
        for (Karakter k: listNPC) {
            k.setLokasi(wilayah3);
        }


        // wilayah 4
        NPC wargaWil4 = null;
        ArrayList<Karakter> listMonster4 = new ArrayList<>();
        Karakter monsterLintah = new Karakter("Monster Lintah", "Lintah raksasa yang dapat meghisap darah manusia", 450, 90, 100);
        Karakter penyihir = new Karakter("Wizard", "Penyihir yang mengutuk dengan matra dan tongkat sihirnya", 600, 90, 100);
        listMonster4.add(monsterLintah);
        listMonster4.add(penyihir);
        ArrayList<Item> listItem4 = new ArrayList<>();
        ItemSenjata xx = null;
        ItemPotion xz = null;
        listItem4.add(xx);
        listItem4.add(xz);
        Wilayah wilayah4 = new Wilayah("Spilaio","Goa yang sangat curam dan menyeramkan, satu satunya akses menuju wilayah terakhir yaitu Diavolos","Temukan petunjuk kelemahan iblis dan kumpulkan senjata sebanyak mungkin untuk melawan raja iblis", wargaWil4);
        wargaWil4 = new NPC("Bussi","Warga yang tinggal di Goa selama 100 tahun", wilayah4);
        Item senter = new Item("Senter","Senter untuk menerangi jalan", wilayah4);
        xx = new ItemSenjata("a", "e", wilayah4, 20);
        wilayah4.setKarakterAktif(player);
        player.setLokasi(wilayah4);
        wilayah4.setMonsterDisini(listMonster4);
        wilayah4.setLoot(listItem4);
        wilayah4.setArrNPC(listNPC);
        for (Karakter k: listNPC) {
            k.setLokasi(wilayah4);
        }


        // wilayah 5
        NPC wargaWil5 = null;
        ArrayList<Karakter> listMonster5 = new ArrayList<>();
        Karakter raja = new Karakter("Sukuni", "Sang Raja Iblis yang mengutuk negara Katara", 900, 90, 200);
        Karakter elf = new Karakter("Elf", "Elf bala tentara sang Raja Iblis", 300, 90, 80);
        Karakter dwarf = new Karakter("Dwarf", "Dwarf bala tentara sang Raja Iblis", 300, 90, 90);
        listMonster5.add(raja);
        listMonster5.add(elf);
        listMonster5.add(dwarf);
        ArrayList<Item> listItem5 = new ArrayList<>();
        ItemSenjata dynamite = null;
        ItemSenjata zx = null;
        listItem5.add(dynamite);
        listItem5.add(zx);
//        listItem2.add(potion3);
        Wilayah wilayah5 = new Wilayah("Diavolos","Tempat paling meyeramkan di Katara, tempat singgasananya sang iblis.","Lawan Raja Iblis dan bala tentaranya untuk membebaskan negara dari kutukan", wargaWil5);
        wargaWil5 = new NPC("Jesi","Seorang warga yang tinggal dekat dengan Diavolos", wilayah5);
        dynamite = new ItemSenjata("Dynamite","Sebuah bom yang akan meledakkan kutukan dari Raja Iblis", wilayah5,250);
        zx = new ItemSenjata("a", "e", wilayah5, 20);
        wilayah5.setKarakterAktif(player);
        player.setLokasi(wilayah5);
        wilayah5.setMonsterDisini(listMonster5);
        wilayah5.setLoot(listItem5);
        wilayah5.setArrNPC(listNPC);
        for (Karakter k: listNPC) {
            k.setLokasi(wilayah5);
        }



    }
}
