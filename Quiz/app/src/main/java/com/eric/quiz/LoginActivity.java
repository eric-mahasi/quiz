package com.eric.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(LoginActivity.this, QuestionOneActivity.class);
                final String[] myArr = {String.valueOf(idEditText.getText()), String.valueOf(nameEditText.getText())};
                intent.putExtra("myArr", myArr);
                startActivity(intent);
            }
        });
    }
}
