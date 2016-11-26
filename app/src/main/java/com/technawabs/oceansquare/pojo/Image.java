package com.technawabs.oceansquare.pojo;

import java.util.List;

public class Image {

    private long id;
    private String name;
    private String distribution;
    private String slug;
    private boolean ispublic;
    private List<String> regions;
    private String created_at;
    private int min_disk_size;
    private String type;
    private double size_gigabytes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean ispublic() {
        return ispublic;
    }

    public void setIspublic(boolean ispublic) {
        this.ispublic = ispublic;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getMin_disk_size() {
        return min_disk_size;
    }

    public void setMin_disk_size(int min_disk_size) {
        this.min_disk_size = min_disk_size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize_gigabytes() {
        return size_gigabytes;
    }

    public void setSize_gigabytes(double size_gigabytes) {
        this.size_gigabytes = size_gigabytes;
    }
}
