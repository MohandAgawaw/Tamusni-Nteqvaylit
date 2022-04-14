package com.Tamusni.tamusninteqvaylith;


public class info_tirra  {
 String Link;
 String Titel;
 String Discri;
 String Pic1;
 String Pic2;

    public info_tirra() {

    }


    public info_tirra(String link, String titel , String discri,String pic1, String pic2) {
        Link = link;
        Titel = titel;
        Discri = discri;
        Pic1 = pic1;
        Pic2 = pic2;

    }
    public String getLink() {
        return Link;
    }

    public String getPic1() {
        return Pic1;
    }

    public void setPic1(String pic1) {
        Pic1 = pic1;
    }

    public String getPic2() {
        return Pic2;
    }

    public void setPic2(String pic2) {
        Pic2 = pic2;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public String getDiscri() {
        return Discri;
    }

    public void setDiscri(String discri) {
        Discri = discri;
    }
}