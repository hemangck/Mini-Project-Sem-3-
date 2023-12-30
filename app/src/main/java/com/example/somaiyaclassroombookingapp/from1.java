package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class from1 extends AppCompatActivity {
    TextView textview3;
    EditText roleET,nameEditText,idEditText,eventET,dateET;
    Button submitButtton;
    DatabaseReference mDatabase;
    public String iname,irole,isvvId;
//    public int dayInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from1);

        // Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference("bookings");

        // Binding fields
        roleET = findViewById(R.id.roleET);
        eventET = findViewById(R.id.eventET);
        dateET = findViewById(R.id.dateET);
        submitButtton = findViewById(R.id.submitButton);
        nameEditText = findViewById(R.id.nameEditText);
        idEditText = findViewById(R.id.idEditText);
        textview3 = findViewById(R.id.textview3);

        // Getting name,role and svvId values from previous intent
        Intent intent = getIntent();
        iname = intent.getStringExtra("NAME");
        irole = intent.getStringExtra("ROLE");
        isvvId = intent.getStringExtra("SVVID");

        // Setting text to editText fields
        nameEditText.setText(iname);
        roleET.setText(irole);
        idEditText.setText(isvvId);

        // Creating object of class related to bookingTimeChecker
        bookingTimeChecker btc = new bookingTimeChecker();

        // Implementing its method - isBookingAllowed
//        if(btc.isBookingAllowed()){
//            roleET.setVisibility(View.VISIBLE);
//            eventET.setVisibility(View.VISIBLE);
//            datePicker.setVisibility(View.VISIBLE);
//            timeSlotET.setVisibility(View.VISIBLE);
//            submitButtton.setVisibility(View.VISIBLE);
//            nameEditText.setVisibility(View.VISIBLE);
//            idEditText.setVisibility(View.VISIBLE);
//
//            textview3.setTextColor(getResources().getColor(R.color.successGreen));
//            textview3.setText("Booking is allowed");
//        }
//        else{
//            roleET.setVisibility(View.GONE);
//            eventET.setVisibility(View.GONE);
//            datePicker.setVisibility(View.GONE);
//            timeSlotET.setVisibility(View.GONE);
//            submitButtton.setVisibility(View.GONE);
//            nameEditText.setVisibility(View.GONE);
//            idEditText.setVisibility(View.GONE);
//
//            textview3.setTextColor(getResources().getColor(R.color.errorRed));
//            textview3.setText("Booking is not allowed");
//        }

        // Populating dates in the following week in spinner

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 1); // Adding 1 to start from tomorrow
//
//        ArrayList<String> datesList = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            Date date = calendar.getTime();
//            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDate = sdf.format(date);
//
//            // Extracting the day from the date
//            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
//            dayStr = dayFormat.format(date);
//
//            // Adding the date and day to the list
//            datesList.add(formattedDate);
//            calendar.add(Calendar.DATE, 1); // Increment the date by 1 day
//        }


//        int maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//
//        for (int i = 1; i <= maxDaysInMonth; i++) {
//            daysList.add(String.valueOf(i));
//        }


//
//        // Making adapter for spinner - datePicker,events,timeSlot,dayPicker
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datesList);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        datePicker.setAdapter(adapter);
//
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
//                R.array.events, android.R.layout.simple_spinner_item);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        eventET.setAdapter(adapter2);
//
//        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
//                R.array.timeslot, android.R.layout.simple_spinner_item);
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        timeSlotET.setAdapter(adapter3);
//
//
//        // fetching item from events spinner
//        eventET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
//                selectedEvent = parent.getItemAtPosition(position).toString();
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        // fetching item from timeSlot spinner
//        timeSlotET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selectedTimeSlot = parent.getItemAtPosition(position).toString();
//
//                String ts = selectedTimeSlot;
//
//                if(ts.equals("9:10 AM-10:30 AM")){
//                    selectedTimeSlot = "slot1";
//                }
//                else if(ts.equals("10:40 AM-12:00 PM")){
//                    selectedTimeSlot = "slot2";
//                }
//                else if(ts.equals("1:00 PM-2:20 PM")){
//                    selectedTimeSlot = "slot3";
//                }
//                else if(ts.equals("2:20 PM-3:50 PM")){
//                    selectedTimeSlot = "slot4";
//                }
//                else if(ts.equals("4:00 PM-5:20 PM")){
//                    selectedTimeSlot = "slot5";
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        // fetching item from datePicker spinner
//        datePicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selectedDate = parent.getItemAtPosition(position).toString();
//
//                DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = null;
//
//                try {
//                    date = sdf2.parse(selectedDate);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                // Getting the day from the selectedDate
//                if (date != null) {
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime(date);
//                    dayInt = calendar.get(Calendar.DAY_OF_MONTH);
//
//                }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        // fetching item from dayPicker spinner
//        datePicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selectedDay = parent.getItemAtPosition(position).toString();
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

//        dayET.setText(dayInt);

        // Applying setOnClickListner on submit button by which we will perform task - storing in firebase
        submitButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2 = nameEditText.getText().toString().trim();
                String svvId2 = idEditText.getText().toString().trim();
                String role2 = roleET.getText().toString().trim();
                String event = eventET.getText().toString().trim();
                String date = dateET.getText().toString().trim();

                if (!role2.isEmpty() && !event.isEmpty() && !date.isEmpty() && !name2.isEmpty() && !svvId2.isEmpty()) {
                    mDatabase.child("name").push().setValue(name2);
                    mDatabase.child("id").push().setValue(svvId2);
                    mDatabase.child("Roles").push().setValue(role2);
                    mDatabase.child("Events").push().setValue(event);
                    mDatabase.child("Date").push().setValue(date);

                    Toast.makeText(from1.this, "Details submitted successfully !", Toast.LENGTH_SHORT).show();

                    Intent i3 = new Intent(from1.this, roomMgmtFinal.class);
                    startActivity(i3);

                } else {
                    Toast.makeText(from1.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    Intent i4 = new Intent(from1.this, homePage.class);
                    startActivity(i4);
                }
            }
        });
    }
}
