package com.AWH.alkitab.Learning.Prayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.AWH.alkitab.R;

public class prayer extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String male = intent.getStringExtra("method");
        textView.setText(male);


    }
}