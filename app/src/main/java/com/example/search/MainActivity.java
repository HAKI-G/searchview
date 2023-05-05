package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Useradapter.SelectedUser {
    Toolbar toolbar;
    RecyclerView recyclerView;

    List<Usermodel> usermodelList = new ArrayList<>();

    String[] names = {"Salad", "Sandwich", "Bread", "Steak", "Tuna Steak", "Fish", "Shrimp"};

    Useradapter useradapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);

        this.getSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        for (String s : names) {
            Usermodel usermodel = new Usermodel(s);

            usermodelList.add(usermodel);
        }

        useradapter = new Useradapter(usermodelList,this);
        recyclerView.setAdapter(useradapter);

    }

    @Override
    public void SelectedUser(Usermodel usermodel) {
        startActivities(new Intent(MainActivity.this, Useradapter.SelectedUserActivity.class).putExtra("data", usermodel));
    }
}