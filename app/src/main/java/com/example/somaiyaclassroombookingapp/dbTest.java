package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dbTest extends AppCompatActivity {

//    private static Object view;
    TextView textView2;
    Button button;
//    StringBuffer stringBuffer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);

        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                fetchValues();
           }
       });
    }

    public void fetchValues() {
        List<test> testList = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("bookings");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StringBuffer stringBuffer = new StringBuffer();
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String name = childSnapshot.child("name").getValue(String.class);

                    // Use StringBuffer to concatenate the values
                    if (name != null) {
                        stringBuffer.append("Name: ").append(name).append("\n");

                        testList.add(new test(name)); // Assuming the Test class has a constructor that takes a name as a parameter
                    }
                }
                String result = stringBuffer.toString();
                System.out.println(result); // You might want to use Log instead of System.out for Android applications
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log an error message or handle the error appropriately
            }
        });
    }

}