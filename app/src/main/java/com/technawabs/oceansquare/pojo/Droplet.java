package com.technawabs.oceansquare.pojo;

import java.util.List;

public class Droplet {

    private long id;
    private String name;
    private String memory;
    private String vcpus;
    private int disk;
    private boolean locked;
    private String status;
    private String kernel;
    private String created_at;
    private List<String> features;
    private List<Long> backup_ids;
    private String next_backup_window;
    private List<Long> snapshot_ids[];
    private Image image;
    private List<Long> volume_ids;
    private Size size;
    private String size_slug;
    private Networks networks;
    private Region region;

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

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getVcpus() {
        return vcpus;
    }

    public void setVcpus(String vcpus) {
        this.vcpus = vcpus;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKernel() {
        return kernel;
    }

    public void setKernel(String kernel) {
        this.kernel = kernel;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<Long> getBackup_ids() {
        return backup_ids;
    }

    public void setBackup_ids(List<Long> backup_ids) {
        this.backup_ids = backup_ids;
    }

    public String getNext_backup_window() {
        return next_backup_window;
    }

    public void setNext_backup_window(String next_backup_window) {
        this.next_backup_window = next_backup_window;
    }

    public List<Long>[] getSnapshot_ids() {
        return snapshot_ids;
    }

    public void setSnapshot_ids(List<Long>[] snapshot_ids) {
        this.snapshot_ids = snapshot_ids;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Long> getVolume_ids() {
        return volume_ids;
    }

    public void setVolume_ids(List<Long> volume_ids) {
        this.volume_ids = volume_ids;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getSize_slug() {
        return size_slug;
    }

    public void setSize_slug(String size_slug) {
        this.size_slug = size_slug;
    }

    public Networks getNetworks() {
        return networks;
    }

    public void setNetworks(Networks networks) {
        this.networks = networks;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
