package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        Bundle extras = getIntent().getExtras();
        // Extract the array from the Bundle object
        if (extras != null) {
            String[] myArr = extras.getStringArray("myArr");
        }
        // Output the array

        Button previousButton = (Button) findViewById(R.id.buttonPrevious);
        Button homeButton = (Button) findViewById(R.id.buttonHome);
        Button nextButton = (Button) findViewById(R.id.buttonNext);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionOneActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionOneActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
