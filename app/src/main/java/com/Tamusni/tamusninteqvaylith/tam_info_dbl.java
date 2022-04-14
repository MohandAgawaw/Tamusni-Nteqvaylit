package com.Tamusni.tamusninteqvaylith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class tam_info_dbl  {
    String Description;
    String Urlmimg;
    String Date;
    String Urlmimgg;
    public tam_info_dbl() {

    }


    public tam_info_dbl(String description, String urlmimg , String date,String Urlmimg1) {
        Description = description;
        Urlmimg = urlmimg;
        Date = date;
        Urlmimgg = Urlmimg1;

    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setUrlmimg(String urlmimg) {
        Urlmimg = urlmimg;
    }

    public void setDate(String date) {
        Date = date;
    }


    public void setUrlmimgg(String urlmimgg) {
        Urlmimgg = urlmimgg;
    }

    public String getUrlmimgg() {
        return Urlmimgg;
    }

    public String getDescription() {
        return Description;
    }

    public String getUrlmimg() {
        return Urlmimg;
    }

    public String getDate() {
        return Date;
    }


}