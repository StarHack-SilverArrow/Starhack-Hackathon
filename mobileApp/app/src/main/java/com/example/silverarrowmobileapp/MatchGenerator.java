package com.example.silverarrowmobileapp;

import androidx.annotation.NonNull;

import com.example.silverarrowmobileapp.Model.Match;
import com.example.silverarrowmobileapp.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MatchGenerator {

    //TODO: i can change user to less user model
    public static List<User> getAllMatch() {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("user");
        String uuid = FirebaseAuth.getInstance().getUid();
        if (uuid == null) return new ArrayList<>();
        List<User> matchedUsers = new ArrayList<>();
        //TODO: Add filtering
        collectionReference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful())
                // Get all users in same location
                for (QueryDocumentSnapshot document : task.getResult()) {
                    matchedUsers.add(new User(document.get("name").toString(),
                            document.get("username").toString(),
                            document.get("mail").toString(),
                            document.get("phone").toString(),
                            document.get("birthday").toString(),
                            document.get("location").toString(),
                            Integer.parseInt(document.get("point").toString()),
                            (List<String>) document.get("frequentlyLocations")));
                }
        });
        //Userlar olusturulmadan matchler olustulabilir
        for (User user : matchedUsers) {
            Match match = new Match(user.getFrequentlyLocations(), MainActivity.mainUser.getFrequentlyLocations());
            if (match.getMatchPersent() > .4f)
                matchedUsers.add(user);
        }
        return matchedUsers;
    }
}