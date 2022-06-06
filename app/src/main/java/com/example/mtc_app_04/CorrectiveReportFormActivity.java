package com.example.mtc_app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

public class CorrectiveReportFormActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton, timeButton;
    private Button submitButton, backButton;
    private Spinner spinner, spinner2, spinner3;
    private EditText eqProb;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<String> arrayList2 = new ArrayList<>();
    private ArrayList<String> arrayList3 = new ArrayList<>();


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrective_report_form);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        backButton = findViewById(R.id.button_Back_Report);
        submitButton = findViewById(R.id.button_Submit_Report);
        spinner = findViewById(R.id.eqSpinner);
        spinner2 = findViewById(R.id.plantSpinner);
        spinner3 = findViewById(R.id.prodLineSpinner);
        timeButton = findViewById(R.id.timePickerButton);
        eqProb = findViewById(R.id.edit_Text_Issue);


        showDataSpinner();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app");
                reference = rootNode.getReference("correctivemtcdata");

                Date date = new Date();
                long timeMilli = date.getTime();
                Long convDate = 0L;



                //get all the value
                String eqName = spinner.getSelectedItem().toString();
                String prodLine = spinner3.getSelectedItem().toString();
                String plant = spinner2.getSelectedItem().toString();
                String probDesc =  eqProb.getText().toString();
                String inputTime = Long.toString(timeMilli);
                String eqDate = dateButton.getText().toString();
                String eqTime = timeButton.getText().toString();
                String sumDateTime = eqDate + " " + eqTime + ":00";
                String statusReport = "0";

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                try {
                    Date mDate = sdf.parse(sumDateTime);
                    convDate = mDate.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                CorrectiveReportFormHelperClass helperClass = new CorrectiveReportFormHelperClass(eqName, prodLine, plant, probDesc, inputTime, eqDate, eqTime, convDate, statusReport);

                reference.child(inputTime).setValue(helperClass);

                Toast.makeText(CorrectiveReportFormActivity.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));

            }
        });
    }

    private void showDataSpinner() {
        reference = FirebaseDatabase.getInstance("https://maintenance-app-861a8-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        reference.child("eqEntry").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                arrayList3.add("Choose Production Line");
                arrayList2.add("Choose Plant");
                arrayList.add("Choose Equipment");
//                List<String> plantTemp = new ArrayList<>();
//                Boolean status = false;

                for(DataSnapshot item : snapshot.getChildren()){
//                    for (String p : plantTemp) {
//                        if (item.child("plant").getValue(String.class).equals(p)) {
//                            status = false;
//                            continue;
//                        }
//                        plantTemp.add(item.child("plant").getValue(String.class));
//                        status = true;
//                    }

//                    if (status) {
                        arrayList.add(item.child("eqName").getValue(String.class));
                        arrayList2.add(item.child("plant").getValue(String.class));
                        arrayList3.add(item.child("prodLine").getValue(String.class));
//                    }

                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(CorrectiveReportFormActivity.this, R.layout.style_spinner,arrayList);
                ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(CorrectiveReportFormActivity.this, R.layout.style_spinner,arrayList2);
                ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(CorrectiveReportFormActivity.this, R.layout.style_spinner, arrayList3);
                spinner.setAdapter(arrayAdapter);
                spinner2.setAdapter(arrayAdapter2);
                spinner3.setAdapter(arrayAdapter3);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //get Today Date
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }


    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String dateFormat = makeDateFormat(year, month, day);
                //String date = makeDateString(day, month, year);
                dateButton.setText(dateFormat);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        }

    private String makeDateString(int day, int month, int year) {
        return  day + " " + getMonthFormat(month) + " " + year;
    }

    private String makeDateFormat(int year, int month, int day) {
        return year + "/" + month + "/" + day;
    }


    private String getMonthFormat(int month) {
        if(month==1)
            return "JAN";
        if(month==2)
            return "FEB";
        if(month==3)
            return "MAR";
        if(month==4)
            return "APR";
        if(month==5)
            return "MAY";
        if(month==6)
            return "JUN";
        if(month==7)
            return "JUL";
        if(month==8)
            return "AUG";
        if(month==9)
            return "SEP";
        if(month==10)
            return "OKT";
        if(month==11)
            return "NOV";
        if(month==12)
            return "DES";
        return "JAN";

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public void popTimePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d",hour, minute));

            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    ;
    }
