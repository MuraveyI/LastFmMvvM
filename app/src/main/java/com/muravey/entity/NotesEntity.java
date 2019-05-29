package com.muravey.entity;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesEntity  implements Serializable {

    private int id;
    private String title;
    private String description;
    private String date;

    public NotesEntity(){

    }
    public NotesEntity(int id, String title, String description, String data) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }


}
