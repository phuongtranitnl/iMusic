package android2.team2.imusic.models;

public class Song {
    private int songImage;
    private String songName;
    private String songArtist;
    private boolean songFavorite;
    private int songFile;

    public Song() {
    }

    public Song(int songImage, String songName, String songArtist, boolean songFavorite, int songFile) {
        this.songImage = songImage;
        this.songName = songName;
        this.songArtist = songArtist;
        this.songFavorite = songFavorite;
        this.songFile = songFile;
    }

    public int getSongImage() {
        return songImage;
    }

    public void setSongImage(int songImage) {
        this.songImage = songImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public boolean isSongFavorite() {
        return songFavorite;
    }

    public void setSongFavorite(boolean songFavorite) {
        this.songFavorite = songFavorite;
    }

    public int getSongFile() {
        return songFile;
    }

    public void setSongFile(int songFile) {
        this.songFile = songFile;
    }
}
