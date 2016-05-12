package com.ayer.jamie.proj4.Models;

/**
 * Created by JamieAyer on 5/12/16.
 */
public class Locations {

    protected String id;
    protected String tag_type;
    protected String name;
    protected String display_name;
    protected String angellist_url;

    public Locations(String id, String tag_type, String name, String display_name, String angellist_url) {
        this.id = id;
        this.tag_type = tag_type;
        this.name = name;
        this.display_name = display_name;
        this.angellist_url = angellist_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag_type() {
        return tag_type;
    }

    public void setTag_type(String tag_type) {
        this.tag_type = tag_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getAngellist_url() {
        return angellist_url;
    }

    public void setAngellist_url(String angellist_url) {
        this.angellist_url = angellist_url;
    }
}
