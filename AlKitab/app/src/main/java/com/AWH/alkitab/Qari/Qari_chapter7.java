package com.AWH.alkitab.Qari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.AWH.alkitab.R;

public class Qari_chapter7 extends AppCompatActivity implements View.OnClickListener {

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,
            c31,c32,c33;

    int [] img = {  R.drawable.g1, R.drawable.g2, R.drawable.g3,
            R.drawable.g4, R.drawable.g5, R.drawable.g6,
            R.drawable.g7, R.drawable.g8, R.drawable.g9,
            R.drawable.g10, R.drawable.g11, R.drawable.g12,
            R.drawable.g13, R.drawable.g14, R.drawable.g15,
            R.drawable.g16, R.drawable.g17, R.drawable.g18,
            R.drawable.g19, R.drawable.g20, R.drawable.g21,
            R.drawable.g22, R.drawable.g23, R.drawable.g24,
            R.drawable.g25, R.drawable.g26, R.drawable.g27,
            R.drawable.g28, R.drawable.g29, R.drawable.g30,
            R.drawable.g31, R.drawable.g32, R.drawable.g33};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qari_chapter7);
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
        c31 = (CardView) findViewById(R.id.c31);
        c32 = (CardView) findViewById(R.id.c32);
        c33 = (CardView) findViewById(R.id.c33);

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
        c31.setOnClickListener(this);
        c32.setOnClickListener(this);
        c33.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.c1:
                next(0);
                break;
            case R.id.c2:
                next(1);
                break;
            case R.id.c3:
                next(2);
                break;

            case R.id.c4:
                next(3);
                break;
            case R.id.c5:
                next(4);
                break;
            case R.id.c6:
                next(5);
                break;
            case R.id.c7:
                next(6);
                break;
            case R.id.c8:
                next(7);
                break;
            case R.id.c9:
                next(8);
                break;
            case R.id.c10:
                next(9);
                break;
            case R.id.c11:
                next(10);
                break;
            case R.id.c12:
                next(11);
                break;
            case R.id.c13:
                next(12);
                break;
            case R.id.c14:
                next(13);
                break;
            case R.id.c15:
                next(14);
                break;
            case R.id.c16:
                next(15);
                break;
            case R.id.c17:
                next(16);
                break;
            case R.id.c18:
                next(17);
                break;
            case R.id.c19:
                next(18);
                break;
            case R.id.c20:
                next(19);
                break;
            case R.id.c21:
                next(20);
                break;
            case R.id.c22:
                next(21);
                break;
            case R.id.c23:
                next(22);
                break;
            case R.id.c24:
                next(23);
                break;
            case R.id.c25:
                next(24);
                break;
            case R.id.c26:
                next(25);
                break;
            case R.id.c27:
                next(26);
                break;
            case R.id.c28:
                next(27);
                break;
            case R.id.c29:
                next(28);
                break;
            case R.id.c30:
                next(29);
                break;

            case R.id.c31:
                next(30);
                break;
            case R.id.c32:
                next(31);
                break;
            default:
                next(32);
                break;
        }
    }
    public void next(int i){
        Intent intent = new Intent(Qari_chapter7.this, Record.class);
        intent.putExtra("img",img[i]);
        intent.putExtra("filenumber",i+1);
        intent.putExtra("chapter","Chapter 7");
        startActivity(intent);
    }
}