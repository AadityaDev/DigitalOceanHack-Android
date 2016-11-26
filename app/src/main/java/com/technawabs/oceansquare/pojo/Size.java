package com.technawabs.oceansquare.pojo;

import java.util.List;

public class Size {

    private String slug;
    private long memory;
    private long vcpus;
    private long disk;
    private long transfer;
    private  long price_monthly;
    private double price_hourly;
    private List<String> regions;
    private boolean available;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public long getVcpus() {
        return vcpus;
    }

    public void setVcpus(long vcpus) {
        this.vcpus = vcpus;
    }

    public long getDisk() {
        return disk;
    }

    public void setDisk(long disk) {
        this.disk = disk;
    }

    public long getTransfer() {
        return transfer;
    }

    public void setTransfer(long transfer) {
        this.transfer = transfer;
    }

    public long getPrice_monthly() {
        return price_monthly;
    }

    public void setPrice_monthly(long price_monthly) {
        this.price_monthly = price_monthly;
    }

    public double getPrice_hourly() {
        return price_hourly;
    }

    public void setPrice_hourly(double price_hourly) {
        this.price_hourly = price_hourly;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
