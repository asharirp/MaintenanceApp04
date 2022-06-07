package com.example.mtc_app_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CorrectiveReportListHelperClass extends RecyclerView.Adapter<CorrectiveReportListHelperClass.MyViewHolder> {

    Context context;

    ArrayList<CorrectiveReportClass> list;

    public CorrectiveReportListHelperClass(Context context, ArrayList<CorrectiveReportClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemcorrective,parent,false);
        return new MyViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CorrectiveReportClass correctiveReportClass = list.get(position);
        holder.convDate.setText(correctiveReportClass.getConvDate().toString());
        holder.eqName.setText(correctiveReportClass.getEqName());
        holder.inputTime.setText(correctiveReportClass.getInputTime());
        holder.plant.setText(correctiveReportClass.getPlant());
        holder.probDesc.setText(correctiveReportClass.getProbDesc());
        holder.prodLine.setText(correctiveReportClass.getProdLine());
        holder.statusReport.setText(correctiveReportClass.getStatusReport());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView convDate, eqName, inputTime, plant, probDesc, prodLine, statusReport;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            eqName = itemView.findViewById(R.id.eqNameCorrectiveList);
            plant = itemView.findViewById(R.id.eqPlantCorrectiveList);
            prodLine = itemView.findViewById(R.id.eqLineCorrectiveList);
            inputTime = itemView.findViewById(R.id.submitTimeCorrectiveList);
            convDate = itemView.findViewById(R.id.troubleTimeCorrectiveList);
            probDesc = itemView.findViewById(R.id.probDescCorrectiveList);
            statusReport = itemView.findViewById(R.id.statusCorrectiveList);


        }
    }
}
