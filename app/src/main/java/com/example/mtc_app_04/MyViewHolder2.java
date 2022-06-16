package com.example.mtc_app_04;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder2 extends RecyclerView.ViewHolder {

    TextView convDate, eqName, inputTime, plant, probDesc, prodLine, statusReport;
    View v;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        eqName = itemView.findViewById(R.id.eqNameCorrectiveList);
        plant = itemView.findViewById(R.id.eqPlantCorrectiveList);
        prodLine = itemView.findViewById(R.id.eqLineCorrectiveList);
        inputTime = itemView.findViewById(R.id.submitTimeCorrectiveList);
        convDate = itemView.findViewById(R.id.troubleTimeCorrectiveList);
        probDesc = itemView.findViewById(R.id.probDescCorrectiveList);
        statusReport = itemView.findViewById(R.id.statusCorrectiveList);
        v = itemView;
    }
}
