package android2.team2.imusic.models;

public class Empty {
    private int emptyImage;
    private String emptyTitle;
    private String emptyContent;

    public Empty(int emptyImage, String emptyTitle, String emptyContent) {
        this.emptyImage = emptyImage;
        this.emptyTitle = emptyTitle;
        this.emptyContent = emptyContent;
    }

    public int getEmptyImage() {
        return emptyImage;
    }

    public void setEmptyImage(int emptyImage) {
        this.emptyImage = emptyImage;
    }

    public String getEmptyTitle() {
        return emptyTitle;
    }

    public void setEmptyTitle(String emptyTitle) {
        this.emptyTitle = emptyTitle;
    }

    public String getEmptyContent() {
        return emptyContent;
    }

    public void setEmptyContent(String emptyContent) {
        this.emptyContent = emptyContent;
    }
}
