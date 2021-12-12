package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silverarrowmobileapp.Model.Match;
import com.example.silverarrowmobileapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class matchesActivity extends AppCompatActivity {
    private List<User> matches = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        GetAllMatches();
    }


    public void GetAllMatches() {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("users");
        String uuid = FirebaseAuth.getInstance().getUid();
        List<User> matchedUsers = new ArrayList<>();
        //TODO: Add filtering
        collectionReference.whereEqualTo("location", SingletonStorage.mainUser.getLocation()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    System.out.println((String) document.get("uuid"));
                    if (((String) document.get("uuid")) != null && ((String) document.get("uuid")).equals(FirebaseAuth.getInstance().getUid())) continue;
                    matchedUsers.add(new User((String) document.get("name"),
                            (String) document.get("surname"),
                            "(String)document.get()",
                            "(String)document.get()",
                            "String)document.get()",
                            (String) document.get("location"),
                            0,
                            (List<String>) document.get("frequentlylocation")));
                }
                System.out.println(matchedUsers);
                for (User user : matchedUsers) {
                    Match match = new Match(user.getFrequentlyLocations(),SingletonStorage.mainUser.getFrequentlyLocations());
                    System.out.println(match.getMatchPersent()*100);
                    if (match.getMatchPersent() > 0)
                        matches.add(user);
                }
                System.out.println(matches);
            }
        });
    }


    private void InitMatchUI() {



    }

}