package com.example.sql_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnSave;
    databasehelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.ed1);
        btnSave = findViewById(R.id.btnSave);

        databaseHelper = new databasehelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextName.getText().toString();

                if (!text.isEmpty()) {
                    databaseHelper.insertData(text);
                    editTextName.setText("");
                } else {
                    editTextName.setError("Please enter text");
                }
            }
        });
    }
}
