```java
package Collections.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a music album that contains multiple songs.
 */
public class Album {

    // Album name
    private String albumName;

    // Artist name
    private String artist;

    // List of songs available in this album
    private List<Song> songs;

    /**
     * Constructor to initialize album details.
     *
     * @param albumName Name of the album
     * @param artist    Artist name
     */
    public Album(String albumName, String artist) {

        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    /**
     * Adds a new song to the album.
     *
     * @param title    Song title
     * @param duration Song duration
     * @return true if song is added, false if it already exists
     */
    public boolean addSong(String title, double duration) {

        if (findSong(title) == null) {

            songs.add(new Song(title, duration));
            return true;
        }

        return false;
    }

    /**
     * Searches for a song in the album.
     *
     * @param title Song title
     * @return Song object if found, otherwise null
     */
    private Song findSong(String title) {

        for (Song song : songs) {

            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }

    /**
     * Displays all songs available in the album.
     */
    public void printSongs() {

        System.out.println("\nAlbum : " + albumName);
        System.out.println("Artist : " + artist);

        for (Song song : songs) {
            System.out.println(song);
        }
    }

    /**
     * Adds a song to the playlist if it exists in this album.
     *
     * @param title    Song title
     * @param playlist Playlist
     * @return true if added successfully, otherwise false
     */
    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {

        Song song = findSong(title);

        if (song != null) {

            playlist.add(song);
            return true;
        }

        System.out.println("Song \"" + title + "\" is not available in album \"" + albumName + "\".");

        return false;
    }
}
```
