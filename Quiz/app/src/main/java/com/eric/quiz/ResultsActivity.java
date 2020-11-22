package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        Intent intent = getIntent();
        int notDone = intent.getIntExtra("not done", 0);
        // Number of questions done is got by subtracting the number of questions not done from
        // the total number of questions
        int done = 5 - notDone;
        TextView textViewId = findViewById(R.id.textViewID);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewAttempted = findViewById(R.id.textViewAttempted);
        TextView textViewResults = findViewById(R.id.textViewResults);
        TextView textViewFailed = findViewById(R.id.textViewFailed);
        TextView textViewNotAttempted = findViewById(R.id.textViewNotAttempted);

        String id = myList.get(0);
        String name = myList.get(1);
        textViewId.setText(id);
        textViewName.setText(name);
        textViewAttempted.setText(Integer.toString(done));
        textViewNotAttempted.setText(Integer.toString(notDone));

        // Remove id and name from ArrayList
        myList.remove(0);
        myList.remove(0);
        String[] correctAnswers;
        correctAnswers = new String[]{"C", "B", "D", "C", "D"};
        int failed = 0;
        // Compare the submitted answers to the correct answers
        for (int i = 0; i < correctAnswers.length; i++) {
            if (!myList.get(i).equals(correctAnswers[i])) {
                failed++;
            }
        }
        int result = 5 - failed;
        textViewFailed.setText(Integer.toString(failed));
        textViewResults.setText(String.format("%d/%d", result, 5));
        Button homeButton = findViewById(R.id.buttonHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Send all the results to the lecturer's number
        String phoneNo = "+254735000330";
        String message = "Student ID: " + id + " Student Name: " + name + " scored: " + result + "/" + 5 + "\nQuestions Attempted: " + done + "\nQuestions Failed: " + failed + "\nQuestions not attempted: " + notDone;
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
        }
    }
}