package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class phoneAddressMainActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_address_main);
        firebaseFirestore =  FirebaseFirestore.getInstance();;
        firebaseAuth = FirebaseAuth.getInstance();

        EditText phone = findViewById(R.id.phonenumber);
        EditText address = findViewById(R.id.addresshome);

        addsecondpersonalinfo(phone,address);
        
        findViewById(R.id.createaccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addsecondpersonalinfo(phone,address);
                Intent intent = new Intent(phoneAddressMainActivity.this, phoneAddressMainActivity.class);
                startActivity(intent);
            }
        });
    }

    HashMap<String,Object> secondpersonalinfo(String phone, String address, String Uid) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("phone", phone); //e-mail yerine de geçebilir.
        model.put("address", address); //String
        model.put("user_uuid", Uid); //String
        return model;
    }

    private void addsecondpersonalinfo (EditText phone, EditText address){
        findViewById(R.id.createaccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseFirestore.collection("users").
                        document(firebaseAuth.getCurrentUser().getUid()).
                        set(secondpersonalinfo(phone.getText().toString(),
                                address.getText().toString(),
                                firebaseAuth.getCurrentUser().getUid()))
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });
            }
        });


    }


}