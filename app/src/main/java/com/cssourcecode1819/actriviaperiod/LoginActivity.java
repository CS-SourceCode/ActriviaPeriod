package com.cssourcecode1819.actriviaperiod;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private View.OnClickListener onClickListenerSignIn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText etTeamName = findViewById(R.id.activity_login_etTeamID);
            EditText etPassword = findViewById(R.id.activity_login_etPassword);

            String teamName = etTeamName.getText().toString();
            String password = etPassword.getText().toString();

            signIn(teamName, password);

//            if (successful){
//                Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
//                startActivity(i);
//                LoginActivity.this.finish();
//            }
//            else
//                Toast.makeText(LoginActivity.this, "Could not login successfully", Toast.LENGTH_SHORT).show();
        }
    };

    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("LOGIN", "signInWithEmail:success");
                            Toast.makeText(LoginActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LOGIN", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "LOGIN FAIL", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }


                        // ...
                    }
                });
        // Todo: Save login details to preferences
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        Button btnSignIn = findViewById(R.id.activity_login_btnSignIn);
        btnSignIn.setOnClickListener(onClickListenerSignIn);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        Log.e("CURRENT USER", mAuth.getCurrentUser().toString());
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser == null)
            return;
        Intent i = new Intent(this, WelcomeActivity.class);
        startActivity(i);
        finish();
    }


}
