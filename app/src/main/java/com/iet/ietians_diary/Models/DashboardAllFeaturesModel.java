package com.iet.ietians_diary.Models;

import android.widget.ImageView;

public class DashboardAllFeaturesModel {
    String title, description;
    int icon;
    int bgColor;

    public DashboardAllFeaturesModel(String title, String description, int icon, int bgColor) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
}
