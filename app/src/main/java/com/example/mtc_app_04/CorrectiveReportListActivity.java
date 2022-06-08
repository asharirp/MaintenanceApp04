package com.example.mtc_app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CorrectiveReportListActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    DatabaseReference databaseReference;
    CorrectiveReportListHelperClass correctiveReportListHelperClass;
    ArrayList<CorrectiveReportClass> list;
    Button buttonBack;
    private CorrectiveReportListHelperClass.RecyclerViewCorrectiveClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_corrective_report_list);

        recyclerview = findViewById(R.id.correctiveList);
        databaseReference = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("correctivemtcdata");
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        buttonBack = findViewById(R.id.button_Back_CorrectiveMonitoring2);

        list = new ArrayList<>();
        correctiveReportListHelperClass = new CorrectiveReportListHelperClass(this, list,listener);
        recyclerview.setAdapter(correctiveReportListHelperClass);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    CorrectiveReportClass correctiveReportClass = dataSnapshot.getValue(CorrectiveReportClass.class);
                    list.add(correctiveReportClass);
                }

                correctiveReportListHelperClass.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });

        Toast.makeText(CorrectiveReportListActivity.this, "Launch Successfully", Toast.LENGTH_SHORT).show();

        setAdapter();
        
    }

    private void setAdapter() {
        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = new CorrectiveReportListHelperClass.RecyclerViewCorrectiveClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Intent intent = new Intent(getApplicationContext(),CorrectiveReportListActivity.class);
//                intent.putExtra("inputTime",list.get(position).getInputTime());
//                startActivity(intent);
                startActivity(new Intent(getApplicationContext(),CorrectiveReportListActivity.class));
            }
        };
    }

}