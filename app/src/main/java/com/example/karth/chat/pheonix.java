package com.example.karth.chat;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pheonix extends AppCompatActivity {
    EditText name;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pheonix);

        name = (EditText) findViewById(R.id.name);
        submit = (Button) findViewById(R.id.submit);
    }


    public void onClick(View v) {
        String username = name.getText().toString().trim();
        Intent intent = new Intent(pheonix.this, MainActivity.class);
        intent.putExtra("username", username);
        if (username.isEmpty())
        {
            Toast.makeText(pheonix.this,"enter username",Toast.LENGTH_SHORT).show();
        }
        else {

            startActivity(intent);
            finish();
        }

    }
}

