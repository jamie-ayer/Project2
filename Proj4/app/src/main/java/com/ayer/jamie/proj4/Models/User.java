package com.ayer.jamie.proj4.Models;

import android.media.Image;

/**
 * Created by JamieAyer on 5/12/16.
 */
public class User {

    protected String name;
    protected String id;
    protected String bio;
    protected String linkedin_url;
    protected String angellist_url;

    protected int follower_count;

    protected Image image;

    public User(String name, String id, String bio, String linkedin_url, String angellist_url, int follower_count, Image image) {
        this.name = name;
        this.id = id;
        this.bio = bio;
        this.linkedin_url = linkedin_url;
        this.angellist_url = angellist_url;
        this.follower_count = follower_count;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLinkedin_url() {
        return linkedin_url;
    }

    public void setLinkedin_url(String linkedin_url) {
        this.linkedin_url = linkedin_url;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }

    public String getAngellist_url() {
        return angellist_url;
    }

    public void setAngellist_url(String angellist_url) {
        this.angellist_url = angellist_url;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
