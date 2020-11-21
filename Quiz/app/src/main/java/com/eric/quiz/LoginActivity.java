package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    public void login() {
        final EditText idEditText = (EditText) findViewById(R.id.editTextID);
        final EditText nameEditText = (EditText) findViewById(R.id.editTextName);
        Button loginButton = (Button) findViewById(R.id.buttonOkLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> myList = new ArrayList<>();
                myList.add(String.valueOf(idEditText.getText()));
                myList.add(String.valueOf(nameEditText.getText()));
                Intent intent = new Intent(LoginActivity.this, QuestionOneActivity.class);
                intent.putExtra("key", myList);
                startActivity(intent);
            }
        });
    }
}
