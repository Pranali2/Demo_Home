package com.example.demo_home.model;

public class Movie {
     private String title;
    private String descripyion;
    private String studio;
    private String rating;
    private String streaminglink;
    private int thumbnail;
    private  int coverphoto;
    public  Movie(){

    }
    public  Movie(String title,int thumbnail,int coverphoto){
        this.title=title;
        this.thumbnail=thumbnail;
        this.coverphoto=coverphoto;
    }

    public Movie(String title, String descripyion, String studio, String rating, String streaminglink, int thumbnail) {
        this.title = title;
        this.descripyion = descripyion;
        this.studio = studio;
        this.rating = rating;
        this.streaminglink = streaminglink;
        this.thumbnail = thumbnail;

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreaminglink() {
        return streaminglink;
    }

    public void setStreaminglink(String streaminglink) {
        this.streaminglink = streaminglink;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescripyion() {
        return descripyion;
    }

    public void setDescripyion(String descripyion) {
        this.descripyion = descripyion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoverphoto() {
        return coverphoto;
    }

    public void setCoverphoto(int coverphoto) {
        this.coverphoto = coverphoto;
    }
}
