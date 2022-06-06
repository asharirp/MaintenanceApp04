package com.example.mtc_app_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CorrectiveReportListHelperClass extends RecyclerView.Adapter<CorrectiveReportListHelperClass.MyViewHolder2> {

    Context context;

    ArrayList<CorrectiveReportClass> list;

    public CorrectiveReportListHelperClass(Context context, ArrayList<CorrectiveReportClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcorrective,parent,false);
        return new MyViewHolder2 (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

        CorrectiveReportClass correctiveReportClass = list.get(position);
        holder.eqName.setText(correctiveReportClass.getEqName());
        holder.eqNo.setText(correctiveReportClass.getEqNo());
        holder.plant.setText(correctiveReportClass.getPlant());
        holder.prodLine.setText(correctiveReportClass.getProdLine());
        holder.inputTime.setText(correctiveReportClass.getInputTime());
        holder.convDate.setText(correctiveReportClass.getConvDate());
        holder.probDesc.setText(correctiveReportClass.getProbDesc());
        holder.statusReport.setText(correctiveReportClass.getStatusReport());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView eqName, eqNo, plant, prodLine, inputTime, convDate, probDesc, statusReport;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            eqName = itemView.findViewById(R.id.eqNameCorrectiveList);
            eqNo = itemView.findViewById(R.id.eqNoCorrectiveList);
            plant = itemView.findViewById(R.id.eqPlantCorrectiveList);
            prodLine = itemView.findViewById(R.id.eqLineCorrectiveList);
            inputTime = itemView.findViewById(R.id.submitTimeCorrectiveList);
            convDate = itemView.findViewById(R.id.troubleTimeCorrectiveList);
            probDesc = itemView.findViewById(R.id.probDescCorrectiveList);
            statusReport = itemView.findViewById(R.id.statusCorrectiveList);


        }
    }


}
