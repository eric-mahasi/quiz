package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        if (myList != null) {
            myList.remove(0);
            myList.remove(0);
        }
        String[] resultsArray;
        resultsArray = new String[]{"C", "B", "D", "C", "D"};
        int failed = 0;
        for (int i = 0; i < resultsArray.length; i++) {
            if (!myList.get(i).equals(resultsArray[i])) {
                failed++;
            }
        }
        int result = 5 - failed;
        textViewFailed.setText(Integer.toString(failed));
        textViewResults.setText(result + "/" + 5);
        System.out.println(myList);
        System.out.println(failed);
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