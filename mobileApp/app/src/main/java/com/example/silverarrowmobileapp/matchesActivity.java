package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silverarrowmobileapp.Model.Match;
import com.example.silverarrowmobileapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
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
        collectionReference.whereEqualTo("location", SingletonStorage.mainUser.getLocation()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    //System.out.println((String) document.get("uuid"));
                    if (((String) document.get("uuid")) != null && ((String) document.get("uuid")).equals(FirebaseAuth.getInstance().getUid()))
                        continue;
                    User tempUser = new User((String) document.get("name"),
                            (String) document.get("surname"),
                            "(String)document.get()",
                            "(String)document.get()",
                            "String)document.get()",
                            (String) document.get("location"),
                            0,
                            (List<String>) document.get("frequentlylocation"));
                    tempUser.uuid = (String) document.get("location");
                    matchedUsers.add(tempUser);

                }

                List<TextView> textViewList = new ArrayList<>();
                textViewList.add(findViewById(R.id.firstmatch));
                textViewList.add(findViewById(R.id.secondmatch));
                textViewList.add(findViewById(R.id.thirthmatch));
                List<Button> matchButtons = new ArrayList<>();
                System.out.println("Size: " + matchedUsers.size());
                for (int i = 0; i < matchedUsers.size();i++) {
                    Match match = new Match(matchedUsers.get(i).getFrequentlyLocations(), SingletonStorage.mainUser.getFrequentlyLocations());
                    //System.out.println(match.getMatchPersent());
                    if (match.getMatchPersent() > 0) {
                        matches.add(matchedUsers.get(i));
                        System.out.println(matchedUsers.get(i).getName() + " " + matchedUsers.get(i).getLocation());
                        textViewList.get(i).setText(matchedUsers.get(i).getName() + " %" + match.getMatchPersent());
                    }
                }

                matchButtons.add(findViewById(R.id.firstButton));
                matchButtons.add(findViewById(R.id.secondButton));
                matchButtons.add(findViewById(R.id.thirthButton));
                matchButtons.get(0).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MatchButtonCallBack(matches.get(0));
                        matchButtons.get(0).setEnabled(false);
                        matchButtons.get(0).setText("Awaits for Acception");
                    }
                });
                matchButtons.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MatchButtonCallBack(matches.get(1));
                        matchButtons.get(1).setEnabled(false);
                        matchButtons.get(1).setText("Awaits for Acception");
                    }
                });
                matchButtons.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MatchButtonCallBack(matches.get(2));
                        matchButtons.get(2).setEnabled(false);
                        matchButtons.get(2).setText("Awaits for Acception");
                        Intent intent = new Intent(matchesActivity.this, ProfileActivity.class);
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < matches.get(0).getFrequentlyLocations().size(); i++){
                            builder.append(matches.get(0).getFrequentlyLocations().get(i) + "  ");
                        }
                        builder.append("-");
                        builder.append(matches.get(0).getName());
                        intent.putExtra("extra", builder.toString());

                        startActivity(intent);
                    }
                });
               // Toast.makeText(matchesActivity.this,matches.size(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void MatchButtonCallBack(User user) {
        Toast.makeText(matchesActivity.this,"Your application requset sended to " + user.getName(), Toast.LENGTH_SHORT).show();
        //DocumentReference documentReference = FirebaseFirestore.getInstance().collection("application").document();
    }
}