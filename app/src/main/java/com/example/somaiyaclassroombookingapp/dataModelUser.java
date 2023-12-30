package com.example.somaiyaclassroombookingapp;

public class dataModelUser {

    private int imageResource;
    private String text;

    public dataModelUser(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }

}
