package com.example.aldres.lifeisrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button signOutBtn;
    private Button plusExp;
    private Button minusExp;
    String userId;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    DatabaseReference ref;
    User userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            mAuth.signOut();
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        else {
            userId = user.getUid();
            ref = mDatabase.getReference().child("users").child(userId);
            System.out.println(ref.getKey());
        }



        signOutBtn = findViewById(R.id.signOutBtn);
        plusExp = findViewById(R.id.goToTasks);
        minusExp = findViewById(R.id.minusExp);

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        plusExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        minusExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeExp(100);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();

        if (!isSignedIn(mAuth)) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }

    private boolean isSignedIn(FirebaseAuth auth) {
        return auth.getCurrentUser() != null;
    }

    private void signOut() {
        mAuth.signOut();
        Intent intent = new Intent(MainActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    private void showInf(){
        DBtools mDBtools = new DBtools();
        User user1 = mDBtools.getUserData();
        System.out.println(user1.getExp());
    }

    private void changeExp(final int amount){
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userData = dataSnapshot.getValue(User.class);
                System.out.println(userData.getExp() + userData.getUsername() + userData.getGender());
                userData.addExp(amount);
                ref.setValue(userData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
