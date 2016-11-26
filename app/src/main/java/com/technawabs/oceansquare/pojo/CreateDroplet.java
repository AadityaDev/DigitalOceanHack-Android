package com.technawabs.oceansquare.pojo;

import java.util.List;

/**
 * Created by piyush.aggarwal on 26-11-2016.
 */

public class CreateDroplet {

    private String name;
    private List<String> region;
    private List<String> size;
    private List<String> images;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
