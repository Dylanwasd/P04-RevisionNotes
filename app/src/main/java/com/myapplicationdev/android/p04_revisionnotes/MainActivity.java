package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText comment;
    RadioGroup rating;
    Button insert;
    Button view;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comment = findViewById(R.id.editTextNote);
        rating = findViewById(R.id.radioGroupStars);
        insert = findViewById(R.id.buttonInsertNote);
        view = findViewById(R.id.buttonShowList);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                int radio = rating.getCheckedRadioButtonId();
                rb = findViewById(radio);
                String rbText = rb.getText().toString();
                int value = Integer.parseInt(rbText);
                db.insertNote(comment.getText().toString(), value);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}
