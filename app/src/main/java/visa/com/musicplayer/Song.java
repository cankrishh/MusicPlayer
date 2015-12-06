package visa.com.musicplayer;

/**
 * Created by vbathula on 06-Dec-15.
 */
public class Song {


    private long id;
    private String title;
    private String album;
    private String artist;

    public Song(long songID, String songTitle, String songArtist, String songAlbum) {

        id=songID;
        album=songAlbum;
        title=songTitle;
        artist=songArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


}
