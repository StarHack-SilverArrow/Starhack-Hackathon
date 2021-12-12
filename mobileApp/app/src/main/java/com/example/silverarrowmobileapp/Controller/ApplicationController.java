package com.example.silverarrowmobileapp.Controller;

import androidx.annotation.Nullable;

import com.example.silverarrowmobileapp.Model.Application;
import com.example.silverarrowmobileapp.SingletonStorage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;

public class ApplicationController {
    //Basvuru kontrolcusu
    private FirebaseFirestore firestore;
    private FirebaseAuth firebaseAuth;

    private int lastApplicationCount;

    public ApplicationController() {
        firestore = FirebaseFirestore.getInstance();

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

    private void AnswerApplication(Application application, boolean isAccept) {
        Application app = new Application(application);
        if (isAccept) {
            app.setAccepted(true);
        } else {
            app.setAccepted(false);
        }
        DocumentReference applicationReferance = firestore.
                collection("application").document(application.getApplicationId());
        applicationReferance.set(application, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                System.out.println("Application Answered");
            }
        });
    }

}
