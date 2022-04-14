package com.Tamusni.tamusninteqvaylith;

public class student {

    public String nom;
    public String prenom;
    public String email;
    public String password;
    public String gender;
public String image;
public String like;
    public String vib;
    public String userid;





    public student(String img, String nom, String prenom, String email, String password, String gender, String licked, String visibilite, String userid) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.image = img;
        this.like = licked;
        this.vib = visibilite;
        this.userid = userid;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getVib() {
        return vib;
    }

    public void setVib(String vib) {
        this.vib = vib;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
