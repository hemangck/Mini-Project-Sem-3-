package com.example.somaiyaclassroombookingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fragOneData extends Fragment {
    private ListView penLV;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private DatabaseReference databaseReference;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        penLV = view.findViewById(R.id.penLV);
        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        penLV.setAdapter(adapter);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("bookings");

        // Read from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    dataTemplate dataTemplate = snapshot.getValue(dataTemplate.class);
                    if (dataTemplate != null) {
                        String value = "Event: " + dataTemplate.getEvent() + " Status: " + dataTemplate.getStatusStr() + "\n Date: " + dataTemplate.getDate()+ ", TimeSlot: " + dataTemplate.getTimeslot() ;
                        dataList.add(value);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(), "Failed to read value: " + error.toException().getMessage(), Toast.LENGTH_SHORT).show();

                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
                Toast.makeText(getActivity(), "Failed !", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
