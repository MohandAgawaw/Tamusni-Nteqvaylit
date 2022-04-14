package com.Tamusni.tamusninteqvaylith;


public class tam_info_vdo  {

    String Description;
    String lien;
    String Date;
    public tam_info_vdo() {

    }


    public tam_info_vdo(String description, String Lien , String date) {
        Description = description;
        lien = Lien;
        Date = date;

    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLien() {
        return lien;
    }

    public String getDescription() {
        return Description;
    }



    public String getDate() {
        return Date;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public void setDate(String date) {
        Date = date;
    }
}