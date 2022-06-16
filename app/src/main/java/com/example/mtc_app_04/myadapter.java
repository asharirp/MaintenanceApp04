package com.example.mtc_app_04;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.text.SimpleDateFormat;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.eqName.setText(model.getEqName());
        holder.location.setText(model.getPlant());
        holder.lineProd.setText(model.getProdLine());
        holder.troubleDesc.setText(model.getProbDesc());

        //convDate Long data to Callendar format
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txconvDate = sdf.format(model.getConvDate());
        holder.troubleTime.setText(txconvDate);

        //reportTime String to Callendar format
        long lginputTime = Long.parseLong(model.getInputTime());
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txinputTime = sdf2.format(lginputTime);
        holder.reportTime.setText(txinputTime);

        //statusReport get data & condition
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

        //setOnClickListener
        holder.troubleDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),CorrectiveReportFormActivity.class));
//            }
//                AppCompatActivity activity = (AppCompatActivity)view.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment(model.getConvDate(),model.getStatusReport(),model.getEqName(),model.getInputTime(), model.getPlant(),model.getProbDesc(), model.getProdLine())).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from((parent.getContext())).inflate(R.layout.itemcorrective,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
     {
         TextView eqName, eqNo, location, lineProd, reportTime, troubleTime, troubleDesc, statusReport;
         public myviewholder(@NonNull View itemView) {
             super(itemView);

             eqName=itemView.findViewById(R.id.eqNameCorrectiveList);
             eqNo=itemView.findViewById(R.id.eqNoCorrectiveList);
             location=itemView.findViewById(R.id.eqPlantCorrectiveList);
             lineProd=itemView.findViewById(R.id.eqLineCorrectiveList);
             reportTime=itemView.findViewById(R.id.submitTimeCorrectiveList);
             troubleTime=itemView.findViewById(R.id.troubleTimeCorrectiveList);
             troubleDesc=itemView.findViewById(R.id.probDescCorrectiveList);
             statusReport=itemView.findViewById(R.id.statusCorrectiveList);

         }
     }

}
