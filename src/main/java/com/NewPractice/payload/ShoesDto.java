package com.NewPractice.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ShoesDto {

    private Long id;

    private String shoesColor;
    @Size(min=3,message = "name of shoe should have atleast 3 charcter")
    private String shoeName;
    private String shoeShops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShoesColor() {
        return shoesColor;
    }

    public void setShoesColor(String shoesColor) {
        this.shoesColor = shoesColor;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeShops() {
        return shoeShops;
    }

    public void setShoeShops(String shoeShoes) {
        this.shoeShops = shoeShoes;
    }
}
