package com.Tamusni.tamusninteqvaylith;

public class tam_info_amzruy {
    String Description;
    String Urlmimg;
    String Date;
    public tam_info_amzruy() {

    }


    public tam_info_amzruy(String description, String urlmimg , String date) {
        Description = description;
        Urlmimg = urlmimg;
        Date = date;

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
