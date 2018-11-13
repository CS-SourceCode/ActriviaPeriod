package com.cssourcecode1819.actriviaperiod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private View.OnClickListener onClickListenerProceed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText etTeamName = findViewById(R.id.activity_welcome_etTeamName);

            String teamName = etTeamName.getText().toString();
            boolean successful = setUpTeamName(teamName);

            if (successful){
                Intent i = new Intent(WelcomeActivity.this, QuestionsOverviewActivity.class);
                startActivity(i);
                WelcomeActivity.this.finish();
            }
            else
                Toast.makeText(WelcomeActivity.this, "Could not set team name", Toast.LENGTH_SHORT).show();
        }
    };

    private boolean setUpTeamName(String teamName){
        // Todo: Wire up team name to account and shared preferences
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnProceed = findViewById(R.id.activity_welcome_btnProceed);
        btnProceed.setOnClickListener(onClickListenerProceed);
    }


}
