package com.example.starhack.silverArrow.Model;


public class User {
   private String name;
   private String surname;
   private String mail;
   private String phone;
   private String birthday;

    public User(String name, String surname, String mail, String phone, String birthday) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }
}
