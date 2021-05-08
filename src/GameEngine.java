import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    public static void main(String[] args) {
        //bikin player
        Karakter player = new Karakter("Arfi","Seorang Petualang", 50,70,120);
        ArrayList<Item> tasPlayer = new ArrayList<>();
        ItemSenjata pedang = new ItemSenjata("Pedang Pendek", "Sebuah pedang yang tidak panjang", player, 20);
        tasPlayer.add(pedang);
        player.setTas(tasPlayer);

        ArrayList<Karakter> listNPC =  new ArrayList<>();
        Karakter npc1 = new Karakter();
        Karakter npc2 = new Karakter();
        Karakter npc3 = new Karakter();
        listNPC.add(npc1);
        listNPC.add(npc2);
        listNPC.add(npc3);

        //wilayah 1
        NPC wargaWil1 = null; //kalo ini gabisa diisi disini
        ArrayList<Karakter> listMonster = new ArrayList<>();
        Karakter monster1 = null; //bisa lansung diisi disini
        Karakter monster2 = null;
        Karakter monster3 = null;
        listMonster.add(monster1);
        listMonster.add(monster2);
        listMonster.add(monster3);
        ArrayList<Item> listItem = new ArrayList<>();
        ItemPotion potion1 = null; //gabisa diisi disini
        ItemPotion potion2 = null;
        ItemPotion potion3 = null;
        listItem.add(potion1);
        listItem.add(potion2);
        listItem.add(potion3);
        Wilayah wilayah1 = new Wilayah("epilysi","wilayah pemukiman warga Katara yang gelap gulita, hanya terdapat beberapa gubuk tak berpenghuni.","basmi monster yang kamu temui, dan cari petunjuk serta akses untuk menuju wilayah selanjutnya.", wargaWil1);
        wargaWil1 = new NPC("Budi","Warga yang ada di wilayah 1", wilayah1);
        potion1 = new ItemPotion("Sprite","beneran seger", wilayah1,60);
        wilayah1.setKarakterAktif(player);
        player.setLokasi(wilayah1);
        wilayah1.setMonsterDisini(listMonster);
        wilayah1.setLoot(listItem);
        wilayah1.setArrNPC(listNPC);
        for (Karakter o: listNPC) {
            o.setLokasi(wilayah1);
        }


    }
}
