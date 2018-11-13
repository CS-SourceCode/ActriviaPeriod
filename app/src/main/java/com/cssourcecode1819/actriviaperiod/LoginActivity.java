package com.cssourcecode1819.actriviaperiod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private View.OnClickListener onClickListenerSignIn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText etTeamName = findViewById(R.id.activity_login_etTeamID);
            EditText etPassword = findViewById(R.id.activity_login_etPassword);

            String teamName = etTeamName.getText().toString();
            String password = etPassword.getText().toString();

            boolean successful = signIn(teamName, password);

            if (successful){
                Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(i);
                LoginActivity.this.finish();
            }
            else
                Toast.makeText(LoginActivity.this, "Could not login successfully", Toast.LENGTH_SHORT).show();
        }
    };

    private boolean signIn(String username, String password){
        return true;
        // Todo: Save login details to preferences
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnSignIn = findViewById(R.id.activity_login_btnSignIn);
        btnSignIn.setOnClickListener(onClickListenerSignIn);
    }
}
