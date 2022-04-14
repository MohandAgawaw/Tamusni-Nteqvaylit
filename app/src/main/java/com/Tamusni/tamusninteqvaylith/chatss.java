package com.Tamusni.tamusninteqvaylith;

public class chatss {


    String Description;
    String Urlmimg;
    String Namechat;


    public chatss() {

    }


    public chatss(String description, String urlmimg,String namechat ) {
        Description = description;
        Namechat = namechat;
        Urlmimg = urlmimg;
    }

    public String getNamechat() {
        return Namechat;
    }

    public void setNamechat(String namechat) {
        Namechat = namechat;
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
