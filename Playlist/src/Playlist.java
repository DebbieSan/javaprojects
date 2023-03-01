import java.util.ArrayList;

class Playlist {

    public static void main(String[] args) {

        ArrayList<String>  desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("Born to be Wild");
        desertIslandPlaylist.add("Welcome to the Jungle");
        desertIslandPlaylist.add("Sweet Child o' Mine");
        desertIslandPlaylist.add("California Dreamin");
        desertIslandPlaylist.add("Down Under");
        desertIslandPlaylist.add("Aqualung");
        desertIslandPlaylist.add("Californication");

        System.out.println(desertIslandPlaylist);

        System.out.println(desertIslandPlaylist.size());

        desertIslandPlaylist.remove(4);
        desertIslandPlaylist.remove(4);

        System.out.println(desertIslandPlaylist.size());
        System.out.println(desertIslandPlaylist);

        int indexA = desertIslandPlaylist.indexOf("Welcome to the Jungle");
        int indexB = desertIslandPlaylist.indexOf("Sweet Child o' Mine");

        System.out.println(indexA);
        System.out.println(indexB);

        String tempA = "Welcome to the Jungle";

        desertIslandPlaylist.add(1, "Sweet Child o' Mine");

        System.out.println(desertIslandPlaylist);

        desertIslandPlaylist.set(3, tempA);

        System.out.println(desertIslandPlaylist);

        desertIslandPlaylist.remove(2);

        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());


    }

}