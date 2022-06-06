package com.example.mtc_app_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EquipmentEntryActivity extends AppCompatActivity {

    private EditText equipmentName, equipmentNo, productionLine, plantAHM;
    private Button submitButton;
    private Button backButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_entry);
        backButton = findViewById(R.id.button_Back_EqEntry);
        submitButton = findViewById(R.id.button_Submit_Equipment);

        //hook to all .xml element in Activity
        equipmentName = findViewById(R.id.edit_Text_EqNameEntry);
        equipmentNo = findViewById(R.id.edit_Text_EqNoEntry);
        productionLine = findViewById(R.id.edit_Text_ProdLine);
        plantAHM = findViewById(R.id.edit_Text_Plant);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });

        submitButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //get all the value
                String eqName = equipmentName.getText().toString();
                String eqNo = equipmentNo.getText().toString();
                String prodLine = productionLine.getText().toString();
                String plant = plantAHM.getText().toString();

                rootNode = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app");
                reference = rootNode.getReference("eqEntry2").child("plant"+plant).child(prodLine);
                
                EquipmentEntryHelperClass helperClass = new EquipmentEntryHelperClass(eqName, eqNo, prodLine, plant);

                reference.child(eqNo).setValue(helperClass);


            }
        }));

    }
}