package com.example.silverarrowmobileapp;

import com.example.silverarrowmobileapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SingletonStorage {
    private static FirebaseAuth firebaseAuth;
    private static FirebaseFirestore firestore;
    private static FirebaseUser firebaseUser;
    private static User mainUser;
    private static SingletonStorage instance;


    public static SingletonStorage getInstance() {
        if (instance == null)
            instance = new SingletonStorage();
        return instance;
    }

    public static void SetUser() {

    }

    public void SetFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
    }

    private SingletonStorage() {

    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public FirebaseFirestore getUser() {
        return firestore;
    }

    public User getMainUser() {
        return mainUser;
    }

    public FirebaseFirestore getFirestore() {return firestore;}
}
