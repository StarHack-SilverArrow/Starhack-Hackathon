package com.example.silverarrowmobileapp.Model;

import java.util.List;

public class User {
    public  String uuid; // Public olmasinin nedeni butun constructerlarda ektra bir ekleme yapmak
    // zorundada kalmamak icin, bu yuzden finalde olamaz cunku finaller obje yartilmadan once belirlenmeli.
    private final String name;
    private final String surname;
    private final String mail;
    private final  String phone;
    private final String birthday;
    private final String location;
    private final List<String> frequentlyLocations;
    private int point;

    //private Image profilePhoto;

    public User(String name, String surname, String mail,String phone, String birthday, String location,int point,  List<String> frequentlyLocations) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.birthday = birthday;
        this.location = location;
        this.point = point;
        this.frequentlyLocations = frequentlyLocations;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPoint() {
        return point;
    }

    public String getMail() {
        return mail;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getFrequentlyLocations() {
        return frequentlyLocations;
    }
}
