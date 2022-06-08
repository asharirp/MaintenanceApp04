package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dashboard2Activity extends AppCompatActivity {

    TextView textView_eqEntry, textView_probReport, textView_eqList, textView_reportList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);

        textView_eqEntry = findViewById(R.id.button_dashboardeqEntry);
        textView_probReport = findViewById(R.id.button_dashboardProblemReport);
        textView_eqList = findViewById(R.id.button_dashboardeqList);
        textView_reportList = findViewById(R.id.button_dashboardCorrectiveList);

        textView_eqEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentEntryActivity.class));
            }
        });

        textView_probReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportFormActivity.class));
            }
        });

        textView_eqList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EquipmentListActivity.class));
            }
        });

        textView_reportList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CorrectiveReportListActivity.class));
            }
        });
    }
}