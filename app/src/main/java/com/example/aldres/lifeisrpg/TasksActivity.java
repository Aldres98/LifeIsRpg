package com.example.aldres.lifeisrpg;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Task> tasks;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        fab = findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddTasksActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        tasks = new ArrayList<>();
        tasks.add(0, new Task("aaa", "bb", 101));
        tasks.add(1, new Task("aab", "bc", 102));
        tasks.add(2, new Task("aac", "bd", 103));

        TasksAdapter recyclerViewAdapter = new TasksAdapter(tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TasksActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void loadTasks() {
        DBtools tools = new DBtools();
        tools.initDb().child("tasks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
