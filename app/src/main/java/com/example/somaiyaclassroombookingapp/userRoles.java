package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class userRoles extends AppCompatActivity {

    RecyclerView recyclerView;
    myUserAdapter adapter;
    List<dataModelUser> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_roles);

        recyclerView = findViewById(R.id.recyclerView);

        dataList = new ArrayList<>();

        dataList.add(new dataModelUser(R.drawable.icon2, "Student"));
        dataList.add(new dataModelUser(R.drawable.icon2, "Faculty"));
        dataList.add(new dataModelUser(R.drawable.icon2, "Others"));
        dataList.add(new dataModelUser(R.drawable.icon2, "Admin"));
        // Add more items as needed

        // Set up the RecyclerView and adapter
        adapter = new myUserAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

//        int spacingInPixels = 0;
//        recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
    }
}