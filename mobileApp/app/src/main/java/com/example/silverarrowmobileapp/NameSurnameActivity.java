package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;



public class NameSurnameActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;


    public NameSurnameActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_surname);
        firebaseFirestore =  FirebaseFirestore.getInstance();;
        firebaseAuth = FirebaseAuth.getInstance();

        EditText name = findViewById(R.id.username);
        EditText surname = findViewById(R.id.usersurname);

        findViewById(R.id.goOn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addpersonalinfo(name,surname);
                Intent intent = new Intent(NameSurnameActivity.this, phoneAddressMainActivity.class);
                startActivity(intent);

            }
        });

    }

    HashMap<String,Object> personalinfo(String name,String surname, String Uid) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("name", name); //e-mail yerine de geçebilir.
        model.put("surname", surname); //String
        model.put("user_uuid", Uid); //String
        return model;
    }

    private void addpersonalinfo (EditText name, EditText surname){
        findViewById(R.id.goOn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseFirestore.collection("users").
                        document(firebaseAuth.getCurrentUser().getUid()).
                        set(personalinfo(name.getText().toString(),
                                surname.getText().toString(),
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