package com.iet.ietians_diary.Models;

public class InternshipModel {
    String id;
    String internshipImage;
    String companyName;
    String internRole;
    String description;
    String internshipUrl;

    public InternshipModel(String id, String internshipImage, String companyName, String internRole, String description, String internshipUrl) {
        this.id = id;
        this.internshipImage = internshipImage;
        this.companyName = companyName;
        this.internRole = internRole;
        this.description = description;
        this.internshipUrl = internshipUrl;

    }

    public InternshipModel() {
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getinternshipImage() {
        return internshipImage;
    }

    public void setinternshipImage(String internshipImage) { this.internshipImage = internshipImage;  }

    public String getcompanyName() {
        return companyName;
    }

    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getinternRole() {
        return internRole;
    }

    public void setinternRole(String internRole) {
        this.internRole = internRole;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getdinternshipUrl() {
        return internshipUrl;
    }

    public void setinternshipUrl(String internshipUrl) {
        this.internshipUrl = internshipUrl;
    }

}