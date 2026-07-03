package Collections.LinkedList;

/**
 * Represents a single song in an album or playlist.
 */
public class Song {

    // Title of the song
    private String title;

    // Duration of the song in minutes
    private double duration;

    /**
     * Constructor to initialize a Song object.
     *
     * @param title    Title of the song
     * @param duration Duration of the song in minutes
     */
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Returns the title of the song.
     *
     * @return Song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the duration of the song.
     *
     * @return Song duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Returns the song details in a readable format.
     */
    @Override
    public String toString() {
        return title + " : " + duration + " mins";
    }
}
