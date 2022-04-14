package com.Tamusni.tamusninteqvaylith;


public class messages {


    String Description;
    String Urlmimg;
    String Date;



    public messages() {

    }


    public messages(String description, String urlmimg , String date) {
        Description = description;
        Urlmimg = urlmimg;
        Date = date;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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

}
