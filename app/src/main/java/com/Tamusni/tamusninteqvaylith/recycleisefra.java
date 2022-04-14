package com.Tamusni.tamusninteqvaylith;


public class recycleisefra  {
    String Urlmimg;
    String Date;


    public recycleisefra() {

    }


    public recycleisefra(String description, String urlmimg , String date,String Urlmimg1) {

        Urlmimg = urlmimg;
        Date = date;

    }

     public void setUrlmimg(String urlmimg) {
        Urlmimg = urlmimg;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUrlmimg() {
        return Urlmimg;
    }

    public String getDate() {
        return Date;
    }

}