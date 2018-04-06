package com.example.aldres.lifeisrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class AddTasksActivity extends AppCompatActivity {

    private EditText taskTitle, taskDescription, expCost;
    private Button addTask;
    DatabaseReference ref;
    DBtools tools;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);
        taskTitle = findViewById(R.id.task_title);
        taskDescription = findViewById(R.id.task_description);
        expCost = findViewById(R.id.exp_cost);
        addTask = findViewById(R.id.add_task);
        tools = new DBtools();
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task(taskTitle.getText().toString(), taskDescription.getText().toString(), Integer.parseInt(expCost.getText().toString()));
                addTask(task);
            }
        });

    }

    public void addTask(final Task task) {
        ref = tools.initDb().child("tasks");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    ref = ref.push();
                    ref.child("taskTitle").setValue(task.getTitle());
                    ref.child("taskDescription").setValue(task.getDescription());
                    ref.child("taskExpCost").setValue(task.getExpCost());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
