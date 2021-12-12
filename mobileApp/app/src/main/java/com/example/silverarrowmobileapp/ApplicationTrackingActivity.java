package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.silverarrowmobileapp.Model.User;

import java.util.List;

public class ApplicationTrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_tracking);
        List<User> Tracking = MatchGenerator.getAllMatch();
        View track = findViewById(R.id.trackid);
        TextView vıew = (TextView) track.findViewById(R.id.titlename);
        TextView vıew1 = (TextView) track.findViewById(R.id.name);

        vıew.setText("Beyda");
        vıew1.setText("054244444444");

    }
}