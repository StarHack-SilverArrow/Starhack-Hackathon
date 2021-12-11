package com.example.silverarrowmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.silverarrowmobileapp.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth; // Hepsini  singleton depolamaya tasimaya calis
    private FirebaseUser user;
    public static User mainUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        //Bu kisimda yapmam gerekmez muhtemelen  giris ekraninda kontrol edilir zaten
        if (user != null) {
            DocumentReference docRef = FirebaseFirestore.getInstance().collection("cities").document(user.getUid());
            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    mainUser =  documentSnapshot.toObject(User.class);
                }
            });
            System.out.println("test");
        }
        else {
            System.out.println("baglanmadi");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MatchGenerator.getAllMatch();
    }

    public void login(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void SignUp(View view) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}