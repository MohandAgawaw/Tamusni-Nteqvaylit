package com.Tamusni.tamusninteqvaylith;

import android.os.Parcelable;

public abstract class tam implements Parcelable {

    public static final String Tizi = "Tizi Wezzu";
    public static final String Bejaia = "Bgayet";
    public static final String Bouira = "Tubiret";
    public static final String Boumerdes = "Bumerdas";
    public static final String Jijel = "Ğiğel";
    public static final String Borj = "Burğ Bu3rarij";
    public static final String Setif = "Setif";

    private String Wilaya;


    public tam (String wilaya){
        this.Wilaya = wilaya;
    }






    public static String[] getAllWilaya() {
        return new String[]{
               Tizi,Bejaia,Borj,Bouira,Boumerdes,Jijel,Setif

        };
    }
}
