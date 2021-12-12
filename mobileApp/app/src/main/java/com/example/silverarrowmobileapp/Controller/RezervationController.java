package com.example.silverarrowmobileapp.Controller;

import androidx.annotation.Nullable;

import com.example.silverarrowmobileapp.SingletonStorage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class RezervationController {

    private FirebaseFirestore firestore;
    private FirebaseAuth firebaseAuth;

    private int lastRezCount;

    public RezervationController() {


        firestore.collection("user").document(firebaseAuth.getUid()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    //Handle Error
                    return;
                }
                //Event tetiklendiginde basvurular kismindaki farkliligi al ve ekranda goster
                if (value != null && value.exists()) {
                    // Bavurularini kontrol ettir.
                    System.out.println(value.getData());
                } else {
                    System.out.println("Null Value");
                }
            }
        });
    }

}
