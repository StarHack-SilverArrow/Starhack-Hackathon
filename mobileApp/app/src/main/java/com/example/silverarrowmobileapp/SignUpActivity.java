package com.example.silverarrowmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private static final String TAG = "EmailPassword";
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       // ...
// Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore =  FirebaseFirestore.getInstance();;
        EditText mail = findViewById(R.id.editTextMail);
        EditText password = findViewById(R.id.editTextTextPassword);
        Button goOn = findViewById(R.id.goOnNext);
        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(mail.getText().toString(), password.getText().toString());
                Intent intent = new Intent(SignUpActivity.this, NameSurnameActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createAccount(String mail, String password) {
        Toast.makeText(SignUpActivity.this,"begin",Toast.LENGTH_LONG).show();
        firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this,"start",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
    


}