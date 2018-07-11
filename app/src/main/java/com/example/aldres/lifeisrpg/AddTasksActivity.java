package com.example.aldres.lifeisrpg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


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
                DateTools dateTools = new DateTools();
                Task task = new Task(taskTitle.getText().toString(), taskDescription.getText().toString(), Integer.parseInt(expCost.getText().toString()), dateTools.getCurrentTimestamp());
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
                    ref.child("title").setValue(task.getTitle());
                    ref.child("description").setValue(task.getDescription());
                    ref.child("expCost").setValue(task.getExpCost());
                    ref.child("startedAt").setValue(task.getStartedAt());
                    ref.child("timeToComplete").setValue(1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error, while creating task: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public static final Intent newIntent(Context context){
        return new Intent(context, AddTasksActivity.class);
    }
}
