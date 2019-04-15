package android2.team2.imusic.models;

public class Singer {
    public String nameSinger;
    public int totalSong;

    public Singer(String nameSinger, int totalSong) {
        this.nameSinger = nameSinger;
        this.totalSong = totalSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public int getTotalSong() {
        return totalSong;
    }

    public void setTotalSong(int totalSong) {
        this.totalSong = totalSong;
    }
}
