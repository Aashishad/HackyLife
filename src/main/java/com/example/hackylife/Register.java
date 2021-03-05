package com.example.hackylife;

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

public class Register extends AppCompatActivity {
private EditText email;
private EditText pass;
    private EditText conpass;
    private FirebaseAuth mAuth;
    private Button signup;
    private static final String TAG = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email  = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        conpass = findViewById(R.id.conpass);
        signup = findViewById(R.id.signup);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void createAccount(final String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(getApplicationContext(),Register.class));
                            Log.d(TAG, "Registration:success");
                            Toast.makeText(Register.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);

                        }

                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


    public void onClick(View view) {
        String email_id = email.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String confirm_password = conpass.getText().toString().trim();
        //Check for password confirmation

        if (TextUtils.isEmpty(email_id) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email_id).matches()) {
            Toast.makeText(this, "please enter a valid email Address !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "password is too short !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(confirm_password)) {
            Toast.makeText(this, "Please confirm password !", Toast.LENGTH_SHORT).show();
            return;
        }

        //check if password and confirm password match
        if (password.equals(confirm_password)) {
            signup.setVisibility(View.GONE);
            createAccount(email_id, password);
        } else {
            Toast.makeText(this, "Password donot match", Toast.LENGTH_SHORT).show();

        }
    }

}
