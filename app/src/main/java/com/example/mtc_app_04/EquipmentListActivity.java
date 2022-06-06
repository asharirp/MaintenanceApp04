package com.example.mtc_app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EquipmentListActivity extends AppCompatActivity {

    RecyclerView recycleview;
    DatabaseReference databaseReference;
    EquipmentListHelperClass equipmentListHelperClass;
    ArrayList<EquipmentClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);

        recycleview = findViewById(R.id.eqList);
        databaseReference = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("eqEntry");
        recycleview.setHasFixedSize(true);
        recycleview.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        equipmentListHelperClass = new EquipmentListHelperClass(this, list);
        recycleview.setAdapter(equipmentListHelperClass);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    EquipmentClass equipmentClass = dataSnapshot.getValue(EquipmentClass.class);
                    list.add(equipmentClass);
                }

                equipmentListHelperClass.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}