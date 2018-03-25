package com.example.aldres.lifeisrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        recyclerView = findViewById(R.id.recycler_view);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("aaa", "bb", 101));
        tasks.add(new Task("aab", "bc", 102));
        tasks.add(new Task("aac", "bd", 103));

        TasksAdapter recyclerViewAdapter = new TasksAdapter(tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TasksActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);



    }
}
