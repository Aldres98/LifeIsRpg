package com.example.aldres.lifeisrpg;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Aldres on 25.02.2018.
 */

public class DBtools {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase mDb;
    private DatabaseReference ref;
    private String uid;
    private User userData;

    public DatabaseReference initDb(){
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        if (mUser!=null) {
            uid = mUser.getUid();
        }
        mDb = FirebaseDatabase.getInstance();
        ref = mDb.getReference().child("users").child(uid);
        return ref;
    }
 }
