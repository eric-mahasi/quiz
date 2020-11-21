package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        int notDone = intent.getIntExtra("not done", 0);
        int done = 5 - notDone;
        System.out.println(done);
        Button homeButton = (Button) findViewById(R.id.buttonHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}