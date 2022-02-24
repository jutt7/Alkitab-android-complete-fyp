package com.AWH.alkitab.Qari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.AWH.alkitab.Learning.learn_Chapter1;


import com.AWH.alkitab.Learning.learn_Chapter2;
import com.AWH.alkitab.Learning.learn_Chapter3;
import com.AWH.alkitab.Learning.learn_Chapter4;
import com.AWH.alkitab.Learning.learn_Chapter5;
import com.AWH.alkitab.Learning.learn_Chapter6;
import com.AWH.alkitab.Learning.learn_Chapter7;
import com.AWH.alkitab.Learning.learn_Chapter8;
import com.AWH.alkitab.Learning.learn_Chapter9;
import com.AWH.alkitab.R;

public class qari_selection extends AppCompatActivity {

    CardView c1,c2;

    int chapterNo;


    int qari = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qari_selection);


        c1 = (CardView) findViewById(R.id.c1);
        c2 = (CardView) findViewById(R.id.c2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            chapterNo = bundle.getInt("chapterNo");

        }


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chapterNo==1){
                    startActivity(new Intent(qari_selection.this, learn_Chapter1.class).putExtra("Qari","One"));
                }
                else if(chapterNo==2){
                    startActivity(new Intent(qari_selection.this, learn_Chapter2.class).putExtra("Qari","One"));

                }
                else if(chapterNo==3){
                    startActivity(new Intent(qari_selection.this, learn_Chapter3.class).putExtra("Qari","One"));
                }
                else if (chapterNo==4){
                    startActivity(new Intent(qari_selection.this, learn_Chapter4.class).putExtra("Qari","One"));
                }
                else if(chapterNo==5){
                    startActivity(new Intent(qari_selection.this, learn_Chapter5.class).putExtra("Qari","One"));
                }
                else if(chapterNo==6){
                    startActivity(new Intent(qari_selection.this, learn_Chapter6.class).putExtra("Qari","One"));
                }
                else if(chapterNo==7){
                    startActivity(new Intent(qari_selection.this, learn_Chapter7.class).putExtra("Qari","One"));
                }
                else if(chapterNo==8){
                    startActivity(new Intent(qari_selection.this, learn_Chapter8.class).putExtra("Qari","One"));
                }
                else if(chapterNo==9){
                    startActivity(new Intent(qari_selection.this, learn_Chapter9.class).putExtra("Qari","One"));
                }



                else{

                }




            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chapterNo==1){
                    startActivity(new Intent(qari_selection.this,learn_Chapter1.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==2){
                    startActivity(new Intent(qari_selection.this,learn_Chapter2.class).putExtra("Qari","Two"));

                }
                else if(chapterNo==3){
                    startActivity(new Intent(qari_selection.this,learn_Chapter3.class).putExtra("Qari","Two"));
                }
                else if (chapterNo==4){
                    startActivity(new Intent(qari_selection.this,learn_Chapter4.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==5){
                    startActivity(new Intent(qari_selection.this,learn_Chapter5.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==6){
                    startActivity(new Intent(qari_selection.this,learn_Chapter6.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==7){
                    startActivity(new Intent(qari_selection.this,learn_Chapter7.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==8){
                    startActivity(new Intent(qari_selection.this,learn_Chapter8.class).putExtra("Qari","Two"));
                }
                else if(chapterNo==9){
                    startActivity(new Intent(qari_selection.this,learn_Chapter9.class).putExtra("Qari","Two"));
                }


                else{

                }

            }
        });




    }
}