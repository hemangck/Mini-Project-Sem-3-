package com.example.somaiyaclassroombookingapp;

public class dataTemplate {

    private String event;
    private String date;
    private String timeslot;
    private String statusStr;
    // Add more fields as needed


    public dataTemplate(String event, String date, String timeslot, String statusStr) {
        this.event = event;
        this.date = date;
        this.timeslot = timeslot;
        this.statusStr = statusStr;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }



}
