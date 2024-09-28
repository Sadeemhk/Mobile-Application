package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import android.util.Patterns;
import android.view.View;
import android.widget .*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;

    public class SignUp extends AppCompatActivity {
        private FirebaseAuth mAuth;
        private EditText et_fullName, et_password, et_email;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);
            mAuth = FirebaseAuth.getInstance();
            et_fullName = (EditText) findViewById(R.id.FullName);
            et_email = (EditText) findViewById(R.id.email);
            et_password = (EditText) findViewById(R.id.Password);
        }

        public void registerDB(View view) {
            String name = et_fullName.getText().toString();
            String email = et_email.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            if (name.isEmpty()) {
                et_fullName.setError("Full Name is required");
                et_fullName.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                et_email.setError("Email is required");
                et_email.requestFocus();
                return;
            }

            if (password.isEmpty() || password.length() < 6) {
                et_password.setError("Password is required and must be > 6");
                et_password.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                et_email.setError("Please provide valid Email");
                et_email.requestFocus();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        User user = new User(name, email);
                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        FirebaseDatabase.getInstance().getReference("users").child(userId).setValue(user).
                                addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "User has been registered!", Toast.LENGTH_LONG).show();
                                            // Redirect to the main page
                                        } else {
                                            // If writing to the database fails, delete the created user
                                            FirebaseAuth.getInstance().getCurrentUser().delete();
                                            Toast.makeText(getApplicationContext(), "Database write failed: " + task.getException().toString(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(getApplicationContext(), "User registration failed: " + task.getException().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
  }
