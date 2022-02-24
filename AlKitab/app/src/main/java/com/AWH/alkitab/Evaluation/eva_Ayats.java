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

public class eva_Ayats extends AppCompatActivity {
    private CardView c1,c2,c3;

    Integer [] imageIds = {R.id.imageView1,R.id.imageView2,R.id.imageView3};

    ImageView imgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eva__ayats);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(0,"اِنَّاۤ اَعۡطَيۡنٰكَ الۡكَوۡثَر");
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(1,"فَصَلِّ لِرَبِّكَ وَانۡحَر");
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(2,"اِنَّ شَانِئَكَ هُوَ الۡاَبۡتَرُ");
            }
        });
    }
    private void next(int num,String ayatText){
        Intent intent = new Intent(eva_Ayats.this, ayat_Evaluate.class);
        intent.putExtra("AyatNum",num);
        intent.putExtra("Ayat",ayatText);
        intent.putExtra("clickedCell",num);
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
        String itemsValueArray = prefs.getString("evaluateChapterThreeArray", "awais");
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