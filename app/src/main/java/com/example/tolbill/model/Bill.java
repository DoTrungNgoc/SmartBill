package com.example.tolbill.model;

import java.io.Serializable;
import java.util.List;

public class Bill implements Serializable {
    private String id;
    private String total;
    private String address;
    private String dateTime;
    private String imageKey;
    private String owner;
    private List<Item> items;
    private String createdAt;

    public Bill(String id, String total, String address, String dateTime, String imageKey, String owner, List<Item> items, String createdAt) {
        this.id = id;
        this.total = total;
        this.address = address;
        this.dateTime = dateTime;
        this.imageKey = imageKey;
        this.owner = owner;
        this.items = items;
        this.createdAt = createdAt;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", total='" + total + '\'' +
                ", address='" + address + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", imageKey='" + imageKey + '\'' +
                ", owner='" + owner + '\'' +
                ", items=" + items +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
