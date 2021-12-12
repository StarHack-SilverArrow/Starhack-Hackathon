package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.silverarrowmobileapp.Model.Match;

public class GoMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_matches);

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoMatches.this, matchesActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.baddCar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoMatches.this, SetUpCarActivity.class);
                startActivity(intent);
            }
        });
    }
}