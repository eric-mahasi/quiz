package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionFiveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);
        final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        final Intent intent = getIntent();
        Button previousButton = findViewById(R.id.buttonPrevious);
        Button homeButton = findViewById(R.id.buttonHome);
        Button submitButton = findViewById(R.id.buttonSubmit);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionFiveActivity.this, QuestionFourActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionFiveActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButtonA = findViewById(R.id.radioButtonA);
                RadioButton radioButtonB = findViewById(R.id.radioButtonB);
                RadioButton radioButtonC = findViewById(R.id.radioButtonC);
                RadioButton radioButtonD = findViewById(R.id.radioButtonD);
                int notDone = intent.getIntExtra("not done", 0);
                if (myList != null) {
                    if (radioButtonA.isChecked()) {
                        myList.add("A");
                    } else if (radioButtonB.isChecked()) {
                        myList.add("B");
                    } else if (radioButtonC.isChecked()) {
                        myList.add("C");
                    } else if (radioButtonD.isChecked()) {
                        myList.add("D");
                    } else {
                        myList.add("N");
                        notDone++;
                    }
                }
                Intent intent = new Intent(QuestionFiveActivity.this, ResultsActivity.class);
                intent.putExtra("key", myList);
                intent.putExtra("not done", notDone);
                startActivity(intent);
            }
        });
    }
}
