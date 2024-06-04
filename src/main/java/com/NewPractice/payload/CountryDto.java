package com.NewPractice.payload;

public class CountryDto {

    private Long id;

    private String countryName;

    private String countryArea;

    private String countryPopu;

    private String work="done";

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(String countryArea) {
        this.countryArea = countryArea;
    }

    public String getCountryPopu() {
        return countryPopu;
    }

    public void setCountryPopu(String countryPopu) {
        this.countryPopu = countryPopu;
    }
}
