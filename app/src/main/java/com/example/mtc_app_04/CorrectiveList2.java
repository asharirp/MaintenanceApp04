package com.example.mtc_app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class CorrectiveList2 extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<CorrectiveReportClass> options;
    FirebaseRecyclerAdapter<CorrectiveReportClass, MyViewHolder2> adapter;
    DatabaseReference Dataref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrective_list2);

        Dataref = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("correctivemtcdata");
        recyclerView=findViewById(R.id.recView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        LoadData();

    }

    private void LoadData()
    {

        options = new FirebaseRecyclerOptions.Builder<CorrectiveReportClass>().setQuery(Dataref,CorrectiveReportClass.class).build();
        adapter = new FirebaseRecyclerAdapter<CorrectiveReportClass, MyViewHolder2>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder2 holder, int position, @NonNull CorrectiveReportClass model) {
                holder.eqName.setText(model.getEqName());
                holder.plant.setText(model.getPlant());
                holder.prodLine.setText(model.getProdLine());

                //conv date setText
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
                String txconvDate = sdf.format(model.getConvDate());
                holder.convDate.setText(txconvDate);

                //inputTime setText

                long lginputTime = Long.parseLong(model.getInputTime());
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
                String txinputTime = sdf2.format(lginputTime);
                holder.inputTime.setText(txinputTime);

                holder.probDesc.setText(model.getProbDesc());

                switch (model.getStatusReport()) {
                    case 0 :
                        holder.statusReport.setText("Belum diperbaiki");
                        holder.statusReport.setTextColor(Color.parseColor("#C50000"));
                        break;
                    case 1 :
                        holder.statusReport.setText("Dalam Perbaikan");
                        holder.statusReport.setTextColor(Color.parseColor("#FFC107"));
                        break;
                    case 2 :
                        holder.statusReport.setText("Selesai Diperbaiki");
                        holder.statusReport.setTextColor(Color.parseColor("#006C05"));
                        break;
                    default: holder.statusReport.setText("Null");
                }

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(CorrectiveList2.this,ViewActivity.class);
                        intent.putExtra("CorrKey",getRef(position).getKey());
                        startActivity(intent);

                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcorrective,parent,false);
                return new MyViewHolder2(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}