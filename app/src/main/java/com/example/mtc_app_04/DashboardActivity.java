package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button buttonFMonitoring, buttonFReport, buttonEqEntry, buttonEqList, buttonCorrectiveMonitoring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        buttonFMonitoring = findViewById(R.id.button_MachineMonitoring);
        buttonFReport = findViewById(R.id.button_ProblemReportForm);
        buttonEqEntry = findViewById(R.id.button_EquipmentEntryForm);
        buttonEqList = findViewById(R.id.button_EquipmentList);
        buttonCorrectiveMonitoring = findViewById(R.id.button_CorrectiveMonitoring2);

        buttonFMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MonitoringActivity.class));
            }
        });

        buttonFReport.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportFormActivity.class));
            }
        }));

        buttonEqEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentEntryActivity.class));
            }
        });

        buttonEqList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentListActivity.class));
            }
        });

        buttonCorrectiveMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportListActivity.class));
            }
        });
    }
}