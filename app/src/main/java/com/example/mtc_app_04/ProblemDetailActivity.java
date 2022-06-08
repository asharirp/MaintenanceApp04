package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ProblemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_detail);
        TextView probDescText = findViewById(R.id.tv_problemdetailProbDesc);


        String username = "Username not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            username = extras.getString("username");
        }

        probDescText    .setText(username);


    }
}