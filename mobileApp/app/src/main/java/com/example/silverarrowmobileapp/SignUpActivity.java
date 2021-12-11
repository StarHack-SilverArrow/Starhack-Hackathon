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
        Button goOn = findViewById(R.id.goOn);
        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount(mail.getText().toString(), password.getText().toString());
                Intent intent = new Intent(SignUpActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createAccount(String mail, String password) {

        firebaseAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            // [START create_user_with_email]
                            Toast.makeText(SignUpActivity.this, firebaseAuth.getUid(),
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    


}