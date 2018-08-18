package app;

public class Tube {

    private String title;
    private String description;
    private int views;
    private String uploader;

    public Tube(String title, String description, int views, String uploader) {
        this.title = title;
        this.description = description;
        this.views = views;
        this.uploader = uploader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public void prePopulated(){

    }
}
