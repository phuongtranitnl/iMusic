package android2.team2.imusic.models;

public class Artist {
    private int artistId;
    private int artistImage;
    private String artistName;
    private int artistTotal;

    public Artist() {
    }

    public Artist(int artistId, int artistImage, String artistName, int artistTotal) {
        this.artistId = artistId;
        this.artistImage = artistImage;
        this.artistName = artistName;
        this.artistTotal = artistTotal;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(int artistImage) {
        this.artistImage = artistImage;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistTotal() {
        return artistTotal;
    }

    public void setArtistTotal(int artistTotal) {
        this.artistTotal = artistTotal;
    }
}
