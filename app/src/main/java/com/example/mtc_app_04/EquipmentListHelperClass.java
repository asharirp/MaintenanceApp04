package com.example.mtc_app_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EquipmentListHelperClass extends RecyclerView.Adapter<EquipmentListHelperClass.MyViewHolder> {

    Context context;

    ArrayList<EquipmentClass> list;


    public EquipmentListHelperClass(Context context, ArrayList<EquipmentClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.equipmentitem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        EquipmentClass equipmentclass = list.get(position);
        holder.eqName.setText(equipmentclass.getEqName());
        holder.eqNo.setText(equipmentclass.getEqNo());
        holder.plant.setText(equipmentclass.getPlant());
        holder.prodLine.setText(equipmentclass.getProdLine());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView eqName, eqNo, plant, prodLine;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            eqName = itemView.findViewById(R.id.eqNameList);
            eqNo = itemView.findViewById(R.id.eqNoList);
            plant = itemView.findViewById(R.id.eqPlantList);
            prodLine = itemView.findViewById(R.id.eqLineList);

        }
    }
}
