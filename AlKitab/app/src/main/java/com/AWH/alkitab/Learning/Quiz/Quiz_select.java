package com.AWH.alkitab.Learning.Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.AWH.alkitab.Qari.Qari_chapter1;
import com.AWH.alkitab.Qari.Record;
import com.AWH.alkitab.R;

public class Quiz_select extends AppCompatActivity implements View.OnClickListener{
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);

        c1 = (CardView) findViewById(R.id.c1);
        c2 = (CardView) findViewById(R.id.c2);
        c3 = (CardView) findViewById(R.id.c3);
        c4 = (CardView) findViewById(R.id.c4);
        c5 = (CardView) findViewById(R.id.c5);
        c6 = (CardView) findViewById(R.id.c6);
        c7 = (CardView) findViewById(R.id.c7);
        c8 = (CardView) findViewById(R.id.c8);
        c9 = (CardView) findViewById(R.id.c9);


        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        c9.setOnClickListener(this);

        


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.c1:
                next(1);

                break;
            case R.id.c2:
                next(2);

                break;
            case R.id.c3:
                next(3);

                break;

            case R.id.c4:
                next(4);

                break;
            case R.id.c5:
                next(5);

                break;
            case R.id.c6:
                next(6);

                break;
            case R.id.c7:
                next(7);

                break;
            case R.id.c8:
                next(8);

                break;
            default:
                next(9);

                break;
        }
    }
        public void next(int i){
            Intent intent = new Intent(Quiz_select.this, Quiz_main.class);
            intent.putExtra("chapter",i);
            startActivity(intent);
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}