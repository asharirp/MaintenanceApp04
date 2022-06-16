package com.example.mtc_app_04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;


public class descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    Long convDate;
    int statusReport;
    String eqName, inputTime, plant,probDesc, prodLine;

    public descfragment() {


    }
    public descfragment(Long convDate, int statusReport, String eqName, String inputTime, String plant, String probDesc, String prodLine) {
        this.convDate = convDate;
        this.statusReport = statusReport;
        this.eqName = eqName;
        this.inputTime = inputTime;
        this.plant = plant;
        this.probDesc = probDesc;
        this.prodLine = prodLine;
    }


    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_descfragment, container, false);

        TextView eqNameCorrectiveDetail = view.findViewById(R.id.eqNameCorrectiveDetail);
        TextView eqNoCorrectiveDetail = view.findViewById(R.id.eqNoCorrectiveDetail);
        TextView eqPlantCorrectiveDetail = view.findViewById(R.id.eqPlantCorrectiveDetail);
        TextView eqLineCorrectiveList = view.findViewById(R.id.eqLineCorrectiveList);
        TextView submitTimeCorrectiveDetail = view.findViewById(R.id.submitTimeCorrectiveDetail);
        TextView troubleTimeCorrectiveDetail = view.findViewById(R.id.troubleTimeCorrectiveDetail);
        TextView probDescCorrectiveDetail = view.findViewById(R.id.probDescCorrectiveDetail);
        TextView statusCorrectiveDetail = view.findViewById(R.id.statusCorrectiveDetail);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txconvDate = sdf.format(convDate);

        troubleTimeCorrectiveDetail.setText(txconvDate);
        statusCorrectiveDetail.setText(statusReport);
        eqNameCorrectiveDetail.setText(eqName);

        long lginputTime = Long.parseLong(inputTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyy [HH:mm]");
        String txinputTime = sdf2.format(lginputTime);
        submitTimeCorrectiveDetail.setText(txinputTime);

        eqPlantCorrectiveDetail.setText(plant);
        probDescCorrectiveDetail.setText(probDesc);
        eqLineCorrectiveList.setText(prodLine);

        eqNoCorrectiveDetail.setText("equipment Number");








        return view;
    }

    public void onBackPressed()
    {
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();

    }
}