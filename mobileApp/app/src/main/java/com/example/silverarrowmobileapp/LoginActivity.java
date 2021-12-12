package com.example.silverarrowmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.silverarrowmobileapp.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        EditText mail = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextNumberPassword);
        findViewById(R.id.SignInLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(mail.getText().toString(), password.getText().toString());
                Intent intent = new Intent(LoginActivity.this, GoMatches.class);
                startActivity(intent);
            }
        });

    }

    public void Login(String mail, String password) {
        Toast.makeText(LoginActivity.this, mail+password, Toast.LENGTH_SHORT).show();
        firebaseAuth.signInWithEmailAndPassword(mail,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "beginDebug", Toast.LENGTH_SHORT).show();
                DocumentReference reference = firebaseFirestore.collection("users").document(firebaseAuth.getUid());
                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        SingletonStorage.mainUser = new User((String) documentSnapshot.get("name"),
                                (String)documentSnapshot.get("username"),
                                (String)documentSnapshot.get("mail"),
                                (String)documentSnapshot.get("phone"),
                                (String)documentSnapshot.get("birthday"),
                                (String)documentSnapshot.get("location"),
                                (Integer.parseInt((String) documentSnapshot.get("point"))),
                                (List<String>) documentSnapshot.get("frequentlylocation"));
                        startActivity(new Intent(LoginActivity.this, matchesActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        System.out.print(e.getLocalizedMessage());
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    void Log() {
        DocumentReference reference = firebaseFirestore.collection("users").document(firebaseAuth.getUid());
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                SingletonStorage.mainUser = new User((String) documentSnapshot.get("name"),
                        (String)documentSnapshot.get("username"),
                        (String)documentSnapshot.get("mail"),
                        (String)documentSnapshot.get("phone"),
                        (String)documentSnapshot.get("birthday"),
                        (String)documentSnapshot.get("location"),
                        (Integer.parseInt((String) documentSnapshot.get("point"))),
                        (List<String>) documentSnapshot.get("frequentlylocation"));
                startActivity(new Intent(LoginActivity.this, matchesActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
/*
Toast.makeText(LoginActivity.this, FirebaseAuth.getInstance().getUid(), Toast.LENGTH_SHORT).show();
        FirebaseFirestore.getInstance().collection("users").
        document(FirebaseAuth.getInstance().getUid()).get().
        addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
        //Toast.makeText(LoginActivity.this,(String)documentSnapshot.get((String) documentSnapshot.get("name")), Toast.LENGTH_SHORT).show();
        String name = (String) documentSnapshot.get("name");
        Toast.makeText(LoginActivity.this,name, Toast.LENGTH_SHORT).show();


                            /*SingletonStorage.getInstance().SetUser(
                                    new User(documentSnapshot.get("name"),
                                            documentSnapshot.get("username").toString(),
                                            documentSnapshot.get("mail").toString(),
                                            documentSnapshot.get("phone").toString(),
                                            documentSnapshot.get("birthday").toString(),
                                            documentSnapshot.get("location").toString(),
                                            Integer.parseInt(documentSnapshot.get("point").toString()),
                                            (List<String>) documentSnapshot.get("frequentlyLocations")));

                            startActivity(new Intent(LoginActivity.this, matchesActivity.class));

        }
        }).addOnFailureListener(new OnFailureListener() {
@Override
public void onFailure(@NonNull Exception e) {
        Toast.makeText(LoginActivity.this,"name", Toast.LENGTH_SHORT).show();
        }
        });
        }
        */