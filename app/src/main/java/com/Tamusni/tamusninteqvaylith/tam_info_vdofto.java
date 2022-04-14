package com.Tamusni.tamusninteqvaylith;

public class tam_info_vdofto {
    String Description;
    String Urlmimg;
    String Date;
    String Link;
    public tam_info_vdofto() {

    }


    public tam_info_vdofto(String description, String urlmimg , String date,String link) {
        Description = description;
        Urlmimg = urlmimg;
        Date = date;
        Link = link;

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrlmimg() {
        return Urlmimg;
    }

    public void setUrlmimg(String urlmimg) {
        Urlmimg = urlmimg;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
