package com.example.silverarrowmobileapp;

import com.example.silverarrowmobileapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SingletonStorage {
    public static User mainUser;
    private static SingletonStorage instance;


    public static SingletonStorage getInstance() {
        if (instance == null)
            instance = new SingletonStorage();
        return instance;
    }

    public void SetUser(User mainUser) {
        this.mainUser = mainUser;
    }

    private SingletonStorage() {

    }

    public User getMainUser() {
        return mainUser;
    }
}
