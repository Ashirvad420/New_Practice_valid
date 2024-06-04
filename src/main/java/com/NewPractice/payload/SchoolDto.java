package com.NewPractice.payload;

public class SchoolDto {
    private Long id;

    private String schoolName;

    private String schoolLocation;

    private String schoolPopu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getSchoolPopu() {
        return schoolPopu;
    }

    public void setSchoolPopu(String schoolPopu) {
        this.schoolPopu = schoolPopu;
    }
}
