package com.iet.ietians_diary.Models;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class RoadmapModel {
    private String name;
    private int bgColor;

    public RoadmapModel(String name, int bgColor) {
        this.name = name;
        this.bgColor = bgColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBgColor() { return bgColor; }

    public void setBgColor(int bgColor) { this.bgColor = bgColor; }
}
