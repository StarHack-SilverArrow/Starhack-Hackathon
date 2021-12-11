package com.example.silverarrowmobileapp;

import com.example.silverarrowmobileapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingletonStorage {
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private User mainUser;
    private SingletonStorage() {

    }
}
