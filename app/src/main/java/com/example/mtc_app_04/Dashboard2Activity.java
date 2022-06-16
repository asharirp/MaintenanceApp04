package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dashboard2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);


        View boxCorrectiveList = findViewById(R.id.ly_dashboardCorrectiveList);
        View boxEquipmentList = findViewById(R.id.ly_dashboardEqList);
        View boxEquipmentEntry = findViewById(R.id.ly_dashboardEqEntry);
        View boxProblemReport = findViewById(R.id.ly_dashboardProblemReport);
        View boxProblemHistory = findViewById(R.id.ly_dashboardProblemHistory);


        boxEquipmentEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentEntryActivity.class));
            }
        });

        boxProblemReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportFormActivity.class));
            }
        });

        boxEquipmentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentListActivity.class));
            }
        });

        boxProblemHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveList2.class));
            }
        });

//        textView_reportList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),CorrectiveReportListActivity.class));
//            }
//        });

        boxCorrectiveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportListActivity.class));
            }
        });
    }
}