package Collections.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

        // Album 1
        Album album1 = new Album("Evolve", "Imagine Dragons");

        album1.addSong("Believer", 3.45);
        album1.addSong("Thunder", 3.20);
        album1.addSong("Demons", 4.05);
        album1.addSong("Radioactive", 4.30);

        albums.add(album1);

        // Album 2
        Album album2 = new Album("Divide", "Ed Sheeran");

        album2.addSong("Perfect", 4.10);
        album2.addSong("Shape of You", 3.50);
        album2.addSong("Photograph", 4.25);

        albums.add(album2);

        // Playlist
        LinkedList<Song> playlist = new LinkedList<>();

        album1.addToPlaylist("Believer", playlist);
        album1.addToPlaylist("Thunder", playlist);
        album2.addToPlaylist("Perfect", playlist);
        album2.addToPlaylist("Photograph", playlist);
        album1.addToPlaylist("Demons", playlist);

        play(playlist);
    }

    /**
     * Plays songs from the playlist.
     */
    public static void play(LinkedList<Song> playlist) {

        Scanner scanner = new Scanner(System.in);

        ListIterator<Song> iterator = playlist.listIterator();

        boolean quit = false;
        boolean forward = true;

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nNow Playing : " + iterator.next());

        printMenu();

        while (!quit) {

            System.out.print("\nEnter your choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 0:
                    System.out.println("Playlist Finished.");
                    quit = true;
                    break;

                case 1:

                    if (!forward) {

                        if (iterator.hasNext()) {
                            iterator.next();
                        }

                        forward = true;
                    }

                    if (iterator.hasNext()) {

                        System.out.println("Now Playing : " + iterator.next());

                    } else {

                        System.out.println("End of Playlist.");
                        forward = false;

                    }

                    break;

                case 2:

                    if (forward) {

                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }

                        forward = false;
                    }

                    if (iterator.hasPrevious()) {

                        System.out.println("Now Playing : " + iterator.previous());

                    } else {

                        System.out.println("Beginning of Playlist.");
                        forward = true;

                    }

                    break;

                case 3:

                    if (forward) {

                        if (iterator.hasPrevious()) {

                            System.out.println("Replaying : " + iterator.previous());
                            forward = false;

                        } else {

                            System.out.println("Start of Playlist.");

                        }

                    } else {

                        if (iterator.hasNext()) {

                            System.out.println("Replaying : " + iterator.next());
                            forward = true;

                        } else {

                            System.out.println("End of Playlist.");

                        }

                    }

                    break;

                case 4:

                    printPlaylist(playlist);

                    break;

                case 5:

                    printMenu();

                    break;

                case 6:

                    if (playlist.size() > 0) {

                        iterator.remove();

                        if (iterator.hasNext()) {

                            System.out.println("Now Playing : " + iterator.next());

                        } else if (iterator.hasPrevious()) {

                            System.out.println("Now Playing : " + iterator.previous());

                        }

                    }

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

        scanner.close();
    }

    /**
     * Displays menu options.
     */
    public static void printMenu() {

        System.out.println("\n========== PLAYLIST MENU ==========");
        System.out.println("0 - Quit");
        System.out.println("1 - Next Song");
        System.out.println("2 - Previous Song");
        System.out.println("3 - Replay Current Song");
        System.out.println("4 - Display Playlist");
        System.out.println("5 - Print Menu");
        System.out.println("6 - Remove Current Song");
        System.out.println("===================================");
    }

    /**
     * Displays all songs in the playlist.
     */
    public static void printPlaylist(LinkedList<Song> playlist) {

        System.out.println("\n--------- PLAYLIST ---------");

        for (Song song : playlist) {

            System.out.println(song);

        }

        System.out.println("----------------------------");
    }
}
