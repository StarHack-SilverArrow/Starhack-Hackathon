package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.silverarrowmobileapp.Model.User;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String[] extraString = extras.getString("extra").split("-");
            ((TextView)findViewById(R.id.profileName)).setText(extraString[1]);
            ((TextView)findViewById(R.id.ProfileLocations)).setText(extraString[0]);
            //The key argument here must match that used in the other activity
        }

    }
}