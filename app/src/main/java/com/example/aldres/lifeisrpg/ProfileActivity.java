package com.example.aldres.lifeisrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private DBtools tools;
    private ProgressBar progressBar;
    private TextView expLeft, currentLevel;
    private Button goToTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        progressBar = findViewById(R.id.levelBar);
        expLeft = findViewById(R.id.exp_left);
        currentLevel = findViewById(R.id.current_level);
        goToTasks = findViewById(R.id.go_to_tasks);

        goToTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TasksActivity.class);
                startActivity(intent);
            }
        });

        tools = new DBtools();
        setProgressBar();
    }

    private void setProgressBar(){
        tools.initDb().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                int level = user.getLevel();
                int exp = user.getExp();
                currentLevel.setText(new StringBuilder().append("LEVEL ").append(level).toString());

                if (isReadyToLevelUp(exp, level)) {
                    user.addLevel();
                    user.setExp(exp - 1000*level);
                    tools.initDb().setValue(user);
                }
                expLeft.setText(new StringBuilder().append(user.getExp()).append("/").append(1000 * user.getLevel()).toString());
                progressBar.setMax(1000*user.getLevel());
                progressBar.setProgress(user.getExp());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private boolean isReadyToLevelUp(int exp, int level){
        return exp >= 1000 * level;
    }
}
