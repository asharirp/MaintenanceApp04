package com.example.mtc_app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewActivity extends AppCompatActivity {

    TextView convDate, eqName, inputTime, plant, probDesc, prodLine, statusReport;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        eqName = findViewById(R.id.tv_eqName_View);
        plant = findViewById(R.id.tv_plant_View);
        convDate = findViewById(R.id.tv_convDate_View);
        inputTime = findViewById(R.id.tv_inputTime_View);
        probDesc = findViewById(R.id.tv_probDesc_View);
        prodLine = findViewById(R.id.tv_prodLine_View);
        statusReport = findViewById(R.id.tv_statusProb_View);
        ref= FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("correctivemtcdata");

        String CorrKey=getIntent().getStringExtra("CorrKey");

        ref.child(CorrKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if(snapshot.exists())
//                {
//                    String
//                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}