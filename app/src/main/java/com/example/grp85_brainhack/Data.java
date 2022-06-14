package com.example.grp85_brainhack;

public class Data {

    private String description, location, name, title,solved_status, time;
    private float urgency;


    public Data(){

    }

    public Data(String description, String location, String name, String title, String solved_status, String time, int urgency) {
        this.description = description;
        this.location = location;
        this.name = name;
        this.title = title;
        this.solved_status = solved_status;
        this.time = time;
        this.urgency = urgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSolved_status() {
        return solved_status;
    }

    public void setSolved_status(String solved_status) {
        this.solved_status = solved_status;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public float getUrgency() {
        return urgency;
    }

    public void setUrgency(float urgency) {
        this.urgency = urgency;
    }
}
