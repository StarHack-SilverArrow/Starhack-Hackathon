package com.example.silverarrowmobileapp;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class RezervationController {

    private SingletonStorage singletonStorage;

    private int lastRezCount;

    public RezervationController() {
        singletonStorage = SingletonStorage.getInstance();

        singletonStorage.getFirestore().collection("user").document(singletonStorage.getFirebaseAuth().getUid()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
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
