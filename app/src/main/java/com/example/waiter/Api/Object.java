package com.example.waiter.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("area_id")
    @Expose
    private String areaId;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("seats")
    @Expose
    private Integer seats;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("image_selected")
    @Expose
    private String imageSelected;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("available")
    @Expose
    private Boolean available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSelected() {
        return imageSelected;
    }

    public void setImageSelected(String imageSelected) {
        this.imageSelected = imageSelected;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
