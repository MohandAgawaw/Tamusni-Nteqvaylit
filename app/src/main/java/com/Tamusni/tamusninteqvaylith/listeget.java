package com.Tamusni.tamusninteqvaylith;

import java.util.Comparator;

public class listeget {
    String Description;
    String Urlmimg;
    String Namechat;
    String prenom;
    String genr;
    String postid;
    String position;
    String like="";

    public String getPostid() {
        return postid;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public listeget() {

    }

    public String getGenr() {
        return genr;
    }

    public void setGenr(String genr) {
        this.genr = genr;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDescription() {
        return Description;
    }

    public String setDescription(String description) {
        Description = description;
        return description;
    }

    public String getUrlmimg() {
        return Urlmimg;
    }

    public void setUrlmimg(String urlmimg) {
        Urlmimg = urlmimg;
    }

    public String getNamechat() {
        return Namechat;
    }

    public void setNamechat(String namechat) {
        Namechat = namechat;
    }

    public listeget(String description, String urlmimg, String namechat,String postion ) {
        Description = description;
        Namechat = namechat;
        Urlmimg = urlmimg;
        position = postion;

    }
    public static Comparator<listeget> Bylike = new Comparator<listeget>(){
        @Override
        public int compare(listeget t2, listeget t1) {
            return - Integer.valueOf(t2.Description).compareTo(Integer.valueOf(t1.Description));
        }
    };
}
