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

public class roomMgmtFinal extends AppCompatActivity {
    public String fstatus, itslot, iday, status, selectedBuilding, selectedFloor, selectedRoomNo;
    EditText dateET2, building, floor, roomNo, timeSlotET, dayET;
    Button bookButton;
    TextView msg;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_mgmt_final);

        // binding ui elements
        building = findViewById(R.id.building);
        floor = findViewById(R.id.floor);
        roomNo = findViewById(R.id.roomNo);
        timeSlotET = findViewById(R.id.timeSlotET);
        msg = findViewById(R.id.msg);
        dateET2 = findViewById(R.id.dateET2);
        bookButton = findViewById(R.id.bookButton);
        dayET = findViewById(R.id.dayET);

        // getting value from previous intent
        Intent intent = getIntent();
        iday = intent.getStringExtra("DAY");
        itslot = intent.getStringExtra("TIMESLOT");

        // Reference to the Firebase Realtime Database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("rmgmtFinal");

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String building2 = building.getText().toString().trim();
                String floor2 = floor.getText().toString().trim();
                String room2 = roomNo.getText().toString().trim();
                String date2 = dateET2.getText().toString().trim();
                String day2 = dayET.getText().toString().trim();
                String tslot2 = timeSlotET.getText().toString().trim();
                String modifiedDate2 = date2.replace("-", "");
                String key = "f";
                String bId = building2.substring(0, 2) + floor2.substring(0, 2) + room2 + modifiedDate2 + day2.substring(0, 2) + key;
                char fkey = fstatus.charAt(fstatus.length() - 1);
                char k1 = 'f';

//                if (fkey == k1) {
//                    msg.setText("Room is not available");
//                } else {
                    if (!building2.isEmpty() && !floor2.isEmpty() && !room2.isEmpty() && !date2.isEmpty() && !day2.isEmpty() && !bId.isEmpty()) {
                        mDatabase.child("building").setValue(building2);
                        mDatabase.child("floor").setValue(floor2);
                        mDatabase.child("room").setValue(room2);
                        mDatabase.child("date").setValue(date2);
                        mDatabase.child("day").setValue(day2);
                        mDatabase.child("tslot").setValue(tslot2);
                        mDatabase.child("bId").setValue(bId);

                        Toast.makeText(roomMgmtFinal.this, "Success !", Toast.LENGTH_SHORT).show();

                        Intent i3 = new Intent(roomMgmtFinal.this, bookSuccess.class);
                        startActivity(i3);
//                    } else {
//                        Toast.makeText(roomMgmtFinal.this, "Failure !", Toast.LENGTH_SHORT).show();
//                        Intent i4 = new Intent(roomMgmtFinal.this, homePage.class);
//                        startActivity(i4);
//                    }
                }
            }
        });
    }
}
