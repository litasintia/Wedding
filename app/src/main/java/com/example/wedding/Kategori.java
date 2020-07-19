package com.example.wedding;

public class Kategori {

    private String Title;
    private String Description;
    private int Thumbnail;



    public Kategori(String title, String description, int thumbnail) {
        Title = title;
        Description = description;
        Thumbnail = thumbnail;

    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }



    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }


}
