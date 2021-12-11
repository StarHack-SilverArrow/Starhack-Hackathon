package com.example.silverarrowmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.silverarrowmobileapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class matchesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        List<User> matches = MatchGenerator.getAllMatch();
        View template = findViewById(R.id.testId);
        TextView vıew = (TextView) template.findViewById(R.id.dummy);
        TextView vıew1 = (TextView) template.findViewById(R.id.textView15);
        TextView vıew2 = (TextView) template.findViewById(R.id.textView14);
        TextView vıew3 = (TextView) template.findViewById(R.id.textView13);
        TextView vıew4 = (TextView) template.findViewById(R.id.textView12);
        ArrayList<TextView> rootView = new ArrayList<TextView>();
        rootView.add(vıew);
        rootView.add(vıew1);
        rootView.add(vıew2);
        rootView.add(vıew3);
        rootView.add(vıew4);
        for (int i=0;i<5;i++) {
            rootView.get(i).setText(matches.get(i).getName());
        }

    }
}