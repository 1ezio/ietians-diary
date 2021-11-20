package com.iet.ietians_diary.Models;

public class SubjectModel {
    String name;
    String url;

    public SubjectModel() {
    }


    public SubjectModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SubjectModel(String name) {
        this.name = name;
    }
}
