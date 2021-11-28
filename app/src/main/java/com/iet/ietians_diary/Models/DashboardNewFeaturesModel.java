package com.iet.ietians_diary.Models;

public class DashboardNewFeaturesModel {
    String name, description;
    int bgColor;
    int bgColorTV;
    int image;

    public DashboardNewFeaturesModel(String name, String description, int bgColor, int bgColorTV, int image) {
        this.name = name;
        this.description = description;
        this.bgColor = bgColor;
        this.bgColorTV = bgColorTV;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getBgColorTV() {
        return bgColorTV;
    }

    public void setBgColorTV(int bgColorTV) {
        this.bgColorTV = bgColorTV;
    }
}
