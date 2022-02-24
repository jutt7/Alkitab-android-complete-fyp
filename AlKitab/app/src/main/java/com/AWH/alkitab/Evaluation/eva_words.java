package com.AWH.alkitab.Evaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.AWH.alkitab.R;

import java.util.StringTokenizer;

public class eva_words extends AppCompatActivity implements View.OnClickListener {
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;

    Integer [] imageIds = {R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9,R.id.imageView10,R.id.imageView11,R.id.imageView12,R.id.imageView13,R.id.imageView14,R.id.imageView15,R.id.imageView16,
            R.id.imageView17,R.id.imageView18,R.id.imageView19,R.id.imageView20};

    ImageView imgId;


    Integer [] img = {  R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f48, R.drawable.i16, R.drawable.f6,
            R.drawable.f22, R.drawable.f27, R.drawable.i13,
            R.drawable.i86, R.drawable.f11, R.drawable.f12,
            R.drawable.f13, R.drawable.f14, R.drawable.i22,
            R.drawable.f16, R.drawable.f51, R.drawable.f37,
            R.drawable.i64, R.drawable.i25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eva_words);




        inittializeCards();
        modifyScreen();
    }
    private void inittializeCards(){
        c1 = (CardView) findViewById(R.id.c1);
        c2 = (CardView) findViewById(R.id.c2);
        c3 = (CardView) findViewById(R.id.c3);
        c4 = (CardView) findViewById(R.id.c4);
        c5 = (CardView) findViewById(R.id.c5);
        c6 = (CardView) findViewById(R.id.c6);
        c7 = (CardView) findViewById(R.id.c7);
        c8 = (CardView) findViewById(R.id.c8);
        c9 = (CardView) findViewById(R.id.c9);
        c10 = (CardView) findViewById(R.id.c10);
        c11 = (CardView) findViewById(R.id.c11);
        c12 = (CardView) findViewById(R.id.c12);
        c13 = (CardView) findViewById(R.id.c13);
        c14 = (CardView) findViewById(R.id.c14);
        c15 = (CardView) findViewById(R.id.c15);
        c16 = (CardView) findViewById(R.id.c16);
        c17 = (CardView) findViewById(R.id.c17);
        c18 = (CardView) findViewById(R.id.c18);
        c19 = (CardView) findViewById(R.id.c19);
        c20 = (CardView) findViewById(R.id.c20);



        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        c9.setOnClickListener(this);
        c10.setOnClickListener(this);
        c11.setOnClickListener(this);
        c12.setOnClickListener(this);
        c13.setOnClickListener(this);
        c14.setOnClickListener(this);
        c15.setOnClickListener(this);
        c16.setOnClickListener(this);
        c17.setOnClickListener(this);
        c18.setOnClickListener(this);
        c19.setOnClickListener(this);
        c20.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1:
                next(0,"ابدا");
                break;
            case R.id.c2:
                next(1,"احد");
                break;
            case R.id.c3:
                next(2,"اخذه");
                break;

            case R.id.c4:
                next(3,"وجده");
                break;
            case R.id.c5:
                next(4,"مالك");
                break;
            case R.id.c6:
                next(5,"انا");
                break;
            case R.id.c7:
                next(6,"وسط");
                break;
            case R.id.c8:
                next(7,"عداله");
                break;
            case R.id.c9:
                next(8,"ذلك");
                break;
            case R.id.c10:
                next(9,"شهيد");
                break;
            case R.id.c11:
                next(10,"حاسدي");
                break;
            case R.id.c12:
                next(11,"حشره");
                break;
            case R.id.c13:
                next(12,"خشيه");
                break;
            case R.id.c14:
                next(13,"خالك");
                break;
            case R.id.c15:
                next(14,"علي");
                break;
            case R.id.c16:
                next(15,"ذاكره");
                break;
            case R.id.c17:
                next(16,"ولد");
                break;
            case R.id.c18:
                next(17,"كاس امم");
                break;
            case R.id.c19:
                next(18,"كتاب");
                break;


            default:
                next(19,"قال");
                break;


        }
    }
    public void next(int i,String chr){
        Intent intent = new Intent(eva_words.this, words_Evaluate.class);
        intent.putExtra("img",img[i]);
        intent.putExtra("chr",chr);
        intent.putExtra("filenumber",i+1);
        intent.putExtra("clickedCell",i);
        intent.putExtra("chapter","Chapter 1");
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
    public void modifyScreen(){
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        String itemsValueArray = prefs.getString("evaluateChapterTwoArray", "awais");
        System.out.println("-------------tokenArray-----------"+itemsValueArray);
        StringTokenizer tokenArray = new StringTokenizer(itemsValueArray," ");
        int i = 0;
        while (tokenArray.hasMoreTokens()) {
            boolean b = Boolean.parseBoolean(tokenArray.nextToken());
            if (b){

                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(R.drawable.rect2);
            }else{
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(R.drawable.rect3);
            }

            i++;
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        modifyScreen();
    }
}