package com.AWH.alkitab.Evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.AWH.alkitab.R;
import com.google.android.gms.common.util.ScopeUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class eva_Chapter1 extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;
    SharedPreferences.Editor editor;
    public static final String TAG = "TAG ";



    ImageView imgId;

    private CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;

    Integer [] imageIds = {R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9,R.id.imageView10,R.id.imageView11,R.id.imageView12,R.id.imageView13,R.id.imageView14,R.id.imageView15,R.id.imageView16,
            R.id.imageView17,R.id.imageView18,R.id.imageView19,R.id.imageView20,R.id.imageView21,R.id.imageView22,R.id.imageView23,R.id.imageView24,R.id.imageView25,R.id.imageView26,R.id.imageView27,R.id.imageView28,R.id.imageView29,R.id.imageView30};



    private int [] img = {  R.drawable.a1,R.drawable.a2,R.drawable.a3,
            R.drawable.a4,R.drawable.a5,R.drawable.a6,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.a10,R.drawable.a11,R.drawable.a12,
            R.drawable.a13,R.drawable.a14,R.drawable.a15,
            R.drawable.a16,R.drawable.a17,R.drawable.a18,
            R.drawable.a19,R.drawable.a20,R.drawable.a21,
            R.drawable.a22,R.drawable.a23,R.drawable.a24,
            R.drawable.a25,R.drawable.a26,R.drawable.a27,
            R.drawable.a28,R.drawable.a29,R.drawable.a30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eva__chapter1);



        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        inittializeCards();
       // modifyScreen();

        String userID;

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
        c21 = (CardView) findViewById(R.id.c21);
        c22 = (CardView) findViewById(R.id.c22);
        c23 = (CardView) findViewById(R.id.c23);
        c24 = (CardView) findViewById(R.id.c24);
        c25 = (CardView) findViewById(R.id.c25);
        c26 = (CardView) findViewById(R.id.c26);
        c27 = (CardView) findViewById(R.id.c27);
        c28 = (CardView) findViewById(R.id.c28);
        c29 = (CardView) findViewById(R.id.c29);
        c30 = (CardView) findViewById(R.id.c30);


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
        c21.setOnClickListener(this);
        c22.setOnClickListener(this);
        c23.setOnClickListener(this);
        c24.setOnClickListener(this);
        c25.setOnClickListener(this);
        c26.setOnClickListener(this);
        c27.setOnClickListener(this);
        c28.setOnClickListener(this);
        c29.setOnClickListener(this);
        c30.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1:
                next(0,"الف",0);
                break;
            case R.id.c2:
                next(1,"با",0);
                break;
            case R.id.c3:
                next(2,"تا",0);
                break;

            case R.id.c4:
                next(3,"سا",0);
                break;
            case R.id.c5:
                next(4,"جیم",0);
                break;
            case R.id.c6:
                next(5,"ہاں",0);
                break;
            case R.id.c7:
                next(6,"کھا خا",0);
                break;
            case R.id.c8:
                next(7,"دال",0);
                break;
            case R.id.c9:
                next(8,"زال",0);
                break;
            case R.id.c10:
                next(9,"را",0);
                break;
            case R.id.c11:
                next(10,"ز*",1);
                break;
            case R.id.c12:
                next(11,"سین",0);
                break;
            case R.id.c13:
                next(12,"شین",0);
                break;
            case R.id.c14:
                next(13,"سواد",1);
                break;
            case R.id.c15:
                next(14,"دواد",1);
                break;
            case R.id.c16:
                next(15,"تا",0);
                break;
            case R.id.c17:
                next(16,"زواج",1);
                break;
            case R.id.c18:
                next(17,"عين",1);
                break;
            case R.id.c19:
                next(18,"غ",0);
                break;
            case R.id.c20:
                next(19,"فا",0);
                break;
            case R.id.c21:
                next(20,"کاف",0);
                break;
            case R.id.c22:
                next(21,"کاف",0);
                break;
            case R.id.c23:
                next(22,"لام",0);
                break;
            case R.id.c24:
                next(23,"میم",0);
                break;
            case R.id.c25:
                next(24,"نون",0);
                break;
            case R.id.c26:
                next(25,"واو",0);
                break;
            case R.id.c27:
                next(26,"ها",1);
                break;
            case R.id.c28:
                next(27,"حمزہ",0);
                break;
            case R.id.c29:
                next(28,"یا",0);
                break;

            default:
                next(29,"یا",0);
                break;


        }
    }


    public void next(int i,String chr,int LangCode){

        Intent intent = new Intent(eva_Chapter1.this, Evaluate.class);
        intent.putExtra("clickedCell",i);
        intent.putExtra("img",img[i]);
        intent.putExtra("chr",chr);
        intent.putExtra("LangCode",LangCode);
        intent.putExtra("filenumber",i+1);
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
        String itemsValueArray = prefs.getString("evaluateChapterOneArray", "awais");
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