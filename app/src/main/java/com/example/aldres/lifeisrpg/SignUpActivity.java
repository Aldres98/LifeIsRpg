package com.example.aldres.lifeisrpg;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    EditText usernameField;
    Button signupButton;
    Button linkToLoginScreen;
    User userData;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailField = findViewById(R.id.email);
        usernameField = findViewById(R.id.name);
        linkToLoginScreen = findViewById(R.id.btnLinkToLoginScreen);
        passwordField = findViewById(R.id.password);
        signupButton = findViewById(R.id.btnRegister);

        mAuth = FirebaseAuth.getInstance();


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });

        linkToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });
    }

    public void signupUser(){
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();
        String userName = usernameField.getText().toString().trim();

        userData = new User(email, userName, "M", 0);

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter your email", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("Auth: ", "createUserWithEmail:success");
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference ref = database.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                            ref.child("email").setValue(userData.getEmail());
                            ref.child("username").setValue(userData.getUsername());
                            ref.child("gender").setValue(userData.getGender());
                            ref.child("exp").setValue(userData.getExp());
                            startActivity(intent);
                        } else {
                            Log.w("Auth:", "createUserWithEmail:failure", task.getException());
                        }
                    }
                });
    }
}
