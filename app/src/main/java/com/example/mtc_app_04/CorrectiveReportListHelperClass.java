package com.example.mtc_app_04;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CorrectiveReportListHelperClass extends RecyclerView.Adapter<CorrectiveReportListHelperClass.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView convDate, eqName, inputTime, plant, probDesc, prodLine, statusReport;

        public MyViewHolder(@NonNull View itemView, RecycleViewClickInterface listener) {
            super(itemView);

            eqName = itemView.findViewById(R.id.eqNameCorrectiveList);
            plant = itemView.findViewById(R.id.eqPlantCorrectiveList);
            prodLine = itemView.findViewById(R.id.eqLineCorrectiveList);
            inputTime = itemView.findViewById(R.id.submitTimeCorrectiveList);
            convDate = itemView.findViewById(R.id.troubleTimeCorrectiveList);
            probDesc = itemView.findViewById(R.id.probDescCorrectiveList);
            statusReport = itemView.findViewById(R.id.statusCorrectiveList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }


    Context context;

    private ArrayList<CorrectiveReportClass> list;
    private RecycleViewClickInterface mListener;

    public interface RecycleViewClickInterface{
        void onItemClick(int position);
    }

    public void setRecycleViewClickInterface(RecycleViewClickInterface listener){
        mListener = listener;
    }


    public CorrectiveReportListHelperClass(Context context, ArrayList<CorrectiveReportClass> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemcorrective,parent,false);
        return new MyViewHolder (v, mListener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CorrectiveReportClass correctiveReportClass = list.get(position);
        holder.eqName.setText(correctiveReportClass.getEqName());
        holder.plant.setText(correctiveReportClass.getPlant());
        holder.probDesc.setText(correctiveReportClass.getProbDesc());
        holder.prodLine.setText(correctiveReportClass.getProdLine());

//        //Coba convert millis to date (Prob Time)
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txconvDate = sdf.format(correctiveReportClass.getConvDate());
        holder.convDate.setText(txconvDate);

        //Coba convert millis to date(Input Time)

        long lginputTime = Long.parseLong(correctiveReportClass.getInputTime());
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txinputTime = sdf2.format(lginputTime);
        holder.inputTime.setText(txinputTime);


//        if (correctiveReportClass.getStatusReport() == 0) {
//            holder.statusReport.setText("Belum diperbaiki");
//        } else if (correctiveReportClass.getStatusReport() == 1) {
//            holder.statusReport.setText("On Progress");
//        }

        switch (correctiveReportClass.getStatusReport()) {
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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}
