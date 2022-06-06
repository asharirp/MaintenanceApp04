package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MonitoringActivity extends AppCompatActivity {

    private TextView progress;
    private Button incr_btn, decr_btn, backButton;
    private ProgressBar progressBarM;

    private int progressStatus = 60;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);

        progress = findViewById(R.id.text_view_progress);
        incr_btn = findViewById(R.id.button_incr);
        decr_btn = findViewById(R.id.button_decr);
        progressBarM = findViewById(R.id.progress_bar);
        backButton = findViewById(R.id.button_Back_Monitoring);

        incr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progressStatus<100) {
                    progressStatus += 10;
                    progressBarM.setProgress(progressStatus);
                    progress.setText(progressStatus + "%");

                }
                }
            });

        decr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progressStatus>0) {
                    progressStatus -= 10;
                    progressBarM.setProgress(progressStatus);
                    progress.setText(progressStatus + "%");

                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });
        };

    }
