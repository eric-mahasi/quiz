package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        Button previousButton = findViewById(R.id.buttonPrevious);
        Button homeButton = findViewById(R.id.buttonHome);
        Button nextButton = findViewById(R.id.buttonNext);
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
                RadioButton radioButtonA = findViewById(R.id.radioButtonA);
                RadioButton radioButtonB = findViewById(R.id.radioButtonB);
                RadioButton radioButtonC = findViewById(R.id.radioButtonC);
                RadioButton radioButtonD = findViewById(R.id.radioButtonD);
                int notDone = 0;
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
                        // If none of the radio buttons is checked, insert N into the ArrayList to
                        // represent N/A and set the number of questions not done to 1
                        myList.add("N");
                        notDone = 1;
                    }
                }
                System.out.println(myList);
                Intent intent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
                intent.putExtra("key", myList);
                intent.putExtra("not done", notDone);
                startActivity(intent);
            }
        });
    }
}