package com.AWH.alkitab.Learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.AWH.alkitab.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class learn_Chapter9 extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;

    Integer [] audioQ1 = {R.raw.i1_q1,R.raw.i2_q1,R.raw.i3_q1,R.raw.i4_q1,R.raw.i5_q1,R.raw.i6_q1,R.raw.i7_q1,R.raw.i8_q1,
            R.raw.i9_q1,R.raw.i10_q1,R.raw.i11_q1,R.raw.i12_q1,R.raw.i13_q1,R.raw.i14_q1,R.raw.i15_q1,R.raw.i16_q1,R.raw.i17_q1,
            R.raw.i18_q1,R.raw.i19_q1,R.raw.i20_q1,R.raw.i21_q1,R.raw.i22_q1,R.raw.i23_q1,R.raw.i24_q1,
            R.raw.i25_q1,R.raw.i26_q1,R.raw.i27_q1,R.raw.i28_q1,R.raw.i29_q1,R.raw.i30_q1,R.raw.i31_q1,R.raw.i32_q1,
            R.raw.i33_q1,R.raw.i34_q1,R.raw.i35_q1,R.raw.i36_q1,R.raw.i37_q1,R.raw.i38_q1,R.raw.i39_q1,R.raw.i40_q1,R.raw.i41_q1,
            R.raw.i42_q1,R.raw.i43_q1,R.raw.i44_q1,R.raw.i45_q1,R.raw.i46_q1,R.raw.i47_q1,R.raw.i48_q1,
            R.raw.i49_q1,R.raw.i50_q1,R.raw.i51_q1,R.raw.i52_q1,R.raw.i53_q1,R.raw.i54_q1,R.raw.i55_q1,R.raw.i56_q1,
            R.raw.i57_q1,R.raw.i58_q1,R.raw.i59_q1,R.raw.i60_q1,R.raw.i61_q1,R.raw.i62_q1,R.raw.i63_q1,R.raw.i64_q1,R.raw.i65_q1,
            R.raw.i66_q1,R.raw.i67_q1,R.raw.i68_q1,R.raw.i69_q1,R.raw.i70_q1,R.raw.i71_q1,R.raw.i72_q1,
            R.raw.i73_q1,R.raw.i74_q1,R.raw.i75_q1,R.raw.i76_q1,R.raw.i77_q1,R.raw.i78_q1,R.raw.i79_q1,R.raw.i80_q1,
            R.raw.i81_q1,R.raw.i82_q1,R.raw.i83_q1,R.raw.i84_q1,R.raw.i85_q1,R.raw.i86_q1,R.raw.i87_q1,R.raw.i88_q1,R.raw.i89_q1,R.raw.i90_q1,
            R.raw.i91_q1,R.raw.i92_q1,R.raw.i93_q1,R.raw.i94_q1,R.raw.i95_q1,R.raw.i96_q1,R.raw.i97_q1,R.raw.i98_q1,
            R.raw.i99_q1,R.raw.i100_q1,
            R.raw.i101_q1};

    Integer [] audioQ2 = {R.raw.i1_q2,R.raw.i2_q2,R.raw.i3_q2,R.raw.i4_q2,R.raw.i5_q2,R.raw.i6_q2,R.raw.i7_q2,R.raw.i8_q2,
            R.raw.i9_q2,R.raw.i10_q2,R.raw.i11_q2,R.raw.i12_q2,R.raw.i13_q2,R.raw.i14_q2,R.raw.i15_q2,R.raw.i16_q2,R.raw.i17_q2,
            R.raw.i18_q2,R.raw.i19_q2,R.raw.i20_q2,R.raw.i21_q2,R.raw.i22_q2,R.raw.i23_q2,R.raw.i24_q2,
            R.raw.i25_q2,R.raw.i26_q2,R.raw.i27_q2,R.raw.i28_q2,R.raw.i29_q2,R.raw.i30_q2,R.raw.i31_q2,R.raw.i32_q2,
            R.raw.i33_q2,R.raw.i34_q2,R.raw.i35_q2,R.raw.i36_q2,R.raw.i37_q2,R.raw.i38_q2,R.raw.i39_q2,R.raw.i40_q2,R.raw.i41_q2,
            R.raw.i42_q2,R.raw.i43_q2,R.raw.i44_q2,R.raw.i45_q2,R.raw.i46_q2,R.raw.i47_q2,R.raw.i48_q2,
            R.raw.i49_q2,R.raw.i50_q2,R.raw.i51_q2,R.raw.i52_q2,R.raw.i53_q2,R.raw.i54_q2,R.raw.i55_q2,R.raw.i56_q2,
            R.raw.i57_q2,R.raw.i58_q2,R.raw.i59_q2,R.raw.i60_q2,R.raw.i61_q2,R.raw.i62_q2,R.raw.i63_q2,R.raw.i64_q2,R.raw.i65_q2,
            R.raw.i66_q2,R.raw.i67_q2,R.raw.i68_q2,R.raw.i69_q2,R.raw.i70_q2,R.raw.i71_q2,R.raw.i72_q2,
            R.raw.i73_q2,R.raw.i74_q2,R.raw.i75_q2,R.raw.i76_q2,R.raw.i77_q2,R.raw.i78_q2,R.raw.i79_q2,R.raw.i80_q2,
            R.raw.i81_q2,R.raw.i82_q2,R.raw.i83_q2,R.raw.i84_q2,R.raw.i85_q2,R.raw.i86_q2,R.raw.i87_q2,R.raw.i88_q2,R.raw.i89_q2,R.raw.i90_q2,
            R.raw.i91_q2,R.raw.i92_q2,R.raw.i93_q2,R.raw.i94_q2,R.raw.i95_q2,R.raw.i96_q2,R.raw.i97_q2,R.raw.i98_q2,
            R.raw.i99_q2,R.raw.i100_q2,
            R.raw.i101_q2};

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,
            c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,
            c61,c62,c63,c64,c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76,c77,c78,c79,c80,c81,c82,c83,c84,c85,c86,c87,c88,c89,c90,
            c91,c92,c93,c94,c95,c96,c97,c98,c99,c100,c101;

    String [] chapterName = {"One", "Two", "Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen"};

    String Qari = "" ;

    ImageView imgId;

    Integer [] imageIds = { R.id.imageView1,R.id.imageView2,R.id.imageView3,
            R.id.imageView4,R.id.imageView5,R.id.imageView6,
            R.id.imageView7,R.id.imageView8,R.id.imageView9,
            R.id.imageView10,R.id.imageView11,R.id.imageView12,
            R.id.imageView13,R.id.imageView14,R.id.imageView15,
            R.id.imageView16,R.id.imageView17,R.id.imageView18,
            R.id.imageView19,R.id.imageView20,R.id.imageView21,
            R.id.imageView22,R.id.imageView23,R.id.imageView24,
            R.id.imageView25,R.id.imageView26,R.id.imageView27,
            R.id.imageView28,R.id.imageView29,R.id.imageView30,
            R.id.imageView31,R.id.imageView32,R.id.imageView33,
            R.id.imageView34,R.id.imageView35,R.id.imageView36,
            R.id.imageView37,R.id.imageView38,R.id.imageView39,
            R.id.imageView40,R.id.imageView41,R.id.imageView42,
            R.id.imageView43,R.id.imageView44,R.id.imageView45,
            R.id.imageView46,R.id.imageView47,R.id.imageView48,
            R.id.imageView49,R.id.imageView50,R.id.imageView51,
            R.id.imageView52,R.id.imageView53,R.id.imageView54,
            R.id.imageView55,R.id.imageView56,R.id.imageView57,
            R.id.imageView58,R.id.imageView59,R.id.imageView60,
            R.id.imageView61,R.id.imageView62,R.id.imageView63,
            R.id.imageView64,R.id.imageView65,R.id.imageView66,
            R.id.imageView67,R.id.imageView68,R.id.imageView69,
            R.id.imageView70,R.id.imageView71,R.id.imageView72,
            R.id.imageView73,R.id.imageView74,R.id.imageView75,
            R.id.imageView76,R.id.imageView77,R.id.imageView78,
            R.id.imageView79,R.id.imageView80,R.id.imageView81,
            R.id.imageView82,R.id.imageView83,R.id.imageView84,
            R.id.imageView85,R.id.imageView86,R.id.imageView87,
            R.id.imageView88,
            R.id.imageView89,R.id.imageView90,R.id.imageView91,
            R.id.imageView92,R.id.imageView93,R.id.imageView94,
            R.id.imageView95,R.id.imageView96,R.id.imageView97,
            R.id.imageView98,R.id.imageView99,R.id.imageView100,
            R.id.imageView101};

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;
    public static final String TAG = "TAG ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__chapter9);


        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            Qari = bundle.getString("Qari");

        }



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
        c34 = (CardView) findViewById(R.id.c34);
        c35 = (CardView) findViewById(R.id.c35);
        c36 = (CardView) findViewById(R.id.c36);
        c37 = (CardView) findViewById(R.id.c37);
        c38 = (CardView) findViewById(R.id.c38);
        c39 = (CardView) findViewById(R.id.c39);
        c40 = (CardView) findViewById(R.id.c40);
        c41 = (CardView) findViewById(R.id.c41);
        c42 = (CardView) findViewById(R.id.c42);
        c43 = (CardView) findViewById(R.id.c43);
        c44 = (CardView) findViewById(R.id.c44);
        c45 = (CardView) findViewById(R.id.c45);
        c46 = (CardView) findViewById(R.id.c46);
        c47 = (CardView) findViewById(R.id.c47);
        c48 = (CardView) findViewById(R.id.c48);
        c49 = (CardView) findViewById(R.id.c49);
        c50 = (CardView) findViewById(R.id.c50);
        c51 = (CardView) findViewById(R.id.c51);
        c52 = (CardView) findViewById(R.id.c52);
        c53 = (CardView) findViewById(R.id.c53);
        c54 = (CardView) findViewById(R.id.c54);
        c55 = (CardView) findViewById(R.id.c55);
        c56 = (CardView) findViewById(R.id.c56);
        c57 = (CardView) findViewById(R.id.c57);
        c58 = (CardView) findViewById(R.id.c58);
        c59 = (CardView) findViewById(R.id.c59);
        c60 = (CardView) findViewById(R.id.c60);
        c61 = (CardView) findViewById(R.id.c61);
        c62 = (CardView) findViewById(R.id.c62);
        c63 = (CardView) findViewById(R.id.c63);
        c64 = (CardView) findViewById(R.id.c64);
        c65 = (CardView) findViewById(R.id.c65);
        c66 = (CardView) findViewById(R.id.c66);
        c67 = (CardView) findViewById(R.id.c67);
        c68 = (CardView) findViewById(R.id.c68);
        c69 = (CardView) findViewById(R.id.c69);
        c70 = (CardView) findViewById(R.id.c70);
        c71 = (CardView) findViewById(R.id.c71);
        c72 = (CardView) findViewById(R.id.c72);
        c73 = (CardView) findViewById(R.id.c73);
        c74 = (CardView) findViewById(R.id.c74);
        c75 = (CardView) findViewById(R.id.c75);
        c76 = (CardView) findViewById(R.id.c76);
        c77 = (CardView) findViewById(R.id.c77);
        c78 = (CardView) findViewById(R.id.c78);
        c79 = (CardView) findViewById(R.id.c79);
        c80 = (CardView) findViewById(R.id.c80);
        c81 = (CardView) findViewById(R.id.c81);
        c82 = (CardView) findViewById(R.id.c82);
        c83 = (CardView) findViewById(R.id.c83);
        c84 = (CardView) findViewById(R.id.c84);
        c85 = (CardView) findViewById(R.id.c85);
        c86 = (CardView) findViewById(R.id.c86);
        c87 = (CardView) findViewById(R.id.c87);
        c88 = (CardView) findViewById(R.id.c88);
        c89 = (CardView) findViewById(R.id.c89);
        c90 = (CardView) findViewById(R.id.c90);
        c91 = (CardView) findViewById(R.id.c91);
        c92 = (CardView) findViewById(R.id.c92);
        c93 = (CardView) findViewById(R.id.c93);
        c94 = (CardView) findViewById(R.id.c94);
        c95 = (CardView) findViewById(R.id.c95);
        c96 = (CardView) findViewById(R.id.c96);
        c97 = (CardView) findViewById(R.id.c97);
        c98 = (CardView) findViewById(R.id.c98);
        c99 = (CardView) findViewById(R.id.c99);
        c100 = (CardView) findViewById(R.id.c100);
        c101 = (CardView) findViewById(R.id.c101);

        modifyScreen();



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
        c34.setOnClickListener(this);
        c35.setOnClickListener(this);
        c36.setOnClickListener(this);
        c37.setOnClickListener(this);
        c38.setOnClickListener(this);
        c39.setOnClickListener(this);
        c40.setOnClickListener(this);
        c41.setOnClickListener(this);
        c42.setOnClickListener(this);
        c43.setOnClickListener(this);
        c44.setOnClickListener(this);
        c45.setOnClickListener(this);
        c46.setOnClickListener(this);
        c47.setOnClickListener(this);
        c48.setOnClickListener(this);
        c49.setOnClickListener(this);
        c50.setOnClickListener(this);
        c51.setOnClickListener(this);
        c52.setOnClickListener(this);
        c53.setOnClickListener(this);
        c54.setOnClickListener(this);
        c55.setOnClickListener(this);
        c56.setOnClickListener(this);
        c57.setOnClickListener(this);
        c58.setOnClickListener(this);
        c59.setOnClickListener(this);
        c60.setOnClickListener(this);
        c61.setOnClickListener(this);
        c62.setOnClickListener(this);
        c63.setOnClickListener(this);
        c64.setOnClickListener(this);
        c65.setOnClickListener(this);
        c66.setOnClickListener(this);
        c67.setOnClickListener(this);
        c68.setOnClickListener(this);
        c69.setOnClickListener(this);
        c70.setOnClickListener(this);
        c71.setOnClickListener(this);
        c72.setOnClickListener(this);
        c73.setOnClickListener(this);
        c74.setOnClickListener(this);
        c75.setOnClickListener(this);
        c76.setOnClickListener(this);
        c77.setOnClickListener(this);
        c78.setOnClickListener(this);
        c79.setOnClickListener(this);
        c80.setOnClickListener(this);
        c81.setOnClickListener(this);
        c82.setOnClickListener(this);
        c83.setOnClickListener(this);
        c84.setOnClickListener(this);
        c85.setOnClickListener(this);
        c86.setOnClickListener(this);
        c87.setOnClickListener(this);
        c88.setOnClickListener(this);
        c89.setOnClickListener(this);
        c90.setOnClickListener(this);
        c91.setOnClickListener(this);
        c92.setOnClickListener(this);
        c93.setOnClickListener(this);
        c94.setOnClickListener(this);
        c95.setOnClickListener(this);
        c96.setOnClickListener(this);
        c97.setOnClickListener(this);
        c98.setOnClickListener(this);
        c99.setOnClickListener(this);
        c100.setOnClickListener(this);
        c101.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1:
                updateCheck(1);
                break;
            case R.id.c2:
                updateCheck(2);
                break;
            case R.id.c3:
                updateCheck(3);
                break;

            case R.id.c4:
                updateCheck(4);
                break;
            case R.id.c5:
                updateCheck(5);
                break;
            case R.id.c6:
                updateCheck(6);
                break;
            case R.id.c7:
                updateCheck(7);
                break;
            case R.id.c8:
                updateCheck(8);
                break;
            case R.id.c9:
                updateCheck(9);
                break;
            case R.id.c10:
                updateCheck(10);
                break;
            case R.id.c11:
                updateCheck(11);
                break;
            case R.id.c12:
                updateCheck(12);
                break;
            case R.id.c13:
                updateCheck(13);
                break;
            case R.id.c14:
                updateCheck(14);
                break;
            case R.id.c15:
                updateCheck(15);
                break;
            case R.id.c16:
                updateCheck(16);
                break;
            case R.id.c17:
                updateCheck(17);
                break;
            case R.id.c18:
                updateCheck(18);
                break;
            case R.id.c19:
                updateCheck(19);
                break;
            case R.id.c20:
                updateCheck(20);
                break;
            case R.id.c21:
                updateCheck(21);
                break;
            case R.id.c22:
                updateCheck(22);
                break;
            case R.id.c23:
                updateCheck(23);
                break;
            case R.id.c24:
                updateCheck(24);
                break;
            case R.id.c25:
                updateCheck(25);
                break;
            case R.id.c26:
                updateCheck(26);
                break;
            case R.id.c27:
                updateCheck(27);
                break;
            case R.id.c28:
                updateCheck(28);
                break;
            case R.id.c29:
                updateCheck(29);
                break;
            case R.id.c30:
                updateCheck(30);
                break;

            case R.id.c31:
                updateCheck(31);
                break;
            case R.id.c32:
                updateCheck(32);
                break;
            case R.id.c33:
                updateCheck(33);
                break;

            case R.id.c34:
                updateCheck(34);
                break;
            case R.id.c35:
                updateCheck(35);
                break;
            case R.id.c36:
                updateCheck(36);
                break;
            case R.id.c37:
                updateCheck(37);
                break;
            case R.id.c38:
                updateCheck(38);
                break;
            case R.id.c39:
                updateCheck(39);
                break;
            case R.id.c40:
                updateCheck(40);
                break;
            case R.id.c41:
                updateCheck(41);
                break;
            case R.id.c42:
                updateCheck(42);
                break;
            case R.id.c43:
                updateCheck(43);
                break;

            case R.id.c44:
                updateCheck(44);
                break;
            case R.id.c45:
                updateCheck(45);
                break;
            case R.id.c46:
                updateCheck(46);
                break;
            case R.id.c47:
                updateCheck(47);
                break;
            case R.id.c48:
                updateCheck(48);
                break;
            case R.id.c49:
                updateCheck(49);
                break;
            case R.id.c50:
                updateCheck(50);
                break;
            case R.id.c51:
                updateCheck(51);
                break;
            case R.id.c52:
                updateCheck(52);
                break;
            case R.id.c53:
                updateCheck(53);
                break;

            case R.id.c54:
                updateCheck(54);
                break;
            case R.id.c55:
                updateCheck(55);
                break;
            case R.id.c56:
                updateCheck(56);
                break;
            case R.id.c57:
                updateCheck(57);
                break;
            case R.id.c58:
                updateCheck(58);
                break;
            case R.id.c59:
                updateCheck(59);
                break;
            case R.id.c60:
                updateCheck(60);
                break;
            case R.id.c61:
                updateCheck(61);
                break;
            case R.id.c62:
                updateCheck(62);
                break;
            case R.id.c63:
                updateCheck(63);
                break;

            case R.id.c64:
                updateCheck(64);
                break;
            case R.id.c65:
                updateCheck(65);
                break;
            case R.id.c66:
                updateCheck(66);
                break;
            case R.id.c67:
                updateCheck(67);
                break;
            case R.id.c68:
                updateCheck(68);
                break;
            case R.id.c69:
                updateCheck(69);
                break;
            case R.id.c70:
                updateCheck(70);
                break;
            case R.id.c71:
                updateCheck(71);
                break;
            case R.id.c72:
                updateCheck(72);
                break;
            case R.id.c73:
                updateCheck(73);
                break;

            case R.id.c74:
                updateCheck(74);
                break;
            case R.id.c75:
                updateCheck(75);
                break;
            case R.id.c76:
                updateCheck(76);
                break;
            case R.id.c77:
                updateCheck(77);
                break;
            case R.id.c78:
                updateCheck(78);
                break;
            case R.id.c79:
                updateCheck(79);
                break;
            case R.id.c80:
                updateCheck(80);
                break;
            case R.id.c81:
                updateCheck(81);
                break;
            case R.id.c82:
                updateCheck(82);
                break;
            case R.id.c83:
                updateCheck(83);
                break;
            case R.id.c84:
                updateCheck(84);
                break;
            case R.id.c85:
                updateCheck(85);
                break;
            case R.id.c86:
                updateCheck(86);
                break;
            case R.id.c87:
                updateCheck(87);
                break;
            case R.id.c88:
                updateCheck(88);
                break;
            case R.id.c89:
                updateCheck(89);
                break;
            case R.id.c90:
                updateCheck(90);
                break;
            case R.id.c91:
                updateCheck(91);
                break;
            case R.id.c92:
                updateCheck(92);
                break;
            case R.id.c93:
                updateCheck(93);
                break;
            case R.id.c94:
                updateCheck(94);
                break;
            case R.id.c95:
                updateCheck(95);
                break;
            case R.id.c96:
                updateCheck(96);
                break;
            case R.id.c97:
                updateCheck(97);
                break;
            case R.id.c98:
                updateCheck(98);
                break;
            case R.id.c99:
                updateCheck(99);
                break;
            case R.id.c100:
                updateCheck(100);
                break;


            default:
                updateCheck(101);
                break;


        }

    }

    public void next(int i){

    }

    public void modifyScreen(){
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        long chaptervalue = prefs.getLong("learnChapterNineQari"+Qari, 1000);





        for(int i = 0;i<chaptervalue;i++){
            imgId = findViewById(imageIds[i]);
            System.out.println("-----------ID---------------------- "+imgId);
            imgId.setImageResource(R.drawable.rect2);
        }

        imgId = findViewById(imageIds[(int) (chaptervalue)]);
        imgId.setImageResource(R.drawable.rect3);



    }
    public void updateCheck(int cardTapped){
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        long chaptervalue = prefs.getLong("learnChapterNineQari"+Qari, 1000);

        if (cardTapped >= chaptervalue+2){
            // not allow to tapped
            System.out.println("Not allowed");

        }
        else if (cardTapped <= chaptervalue){
            //play audio only

            if (cardTapped == 30){
                stopPlaying();
                mp = MediaPlayer.create(this, audioQ1[29]);
                mp.start();
                return;
            }

            if(Qari.equals("One")){

                stopPlaying();
                mp = MediaPlayer.create(this, audioQ1[cardTapped-1]);
                mp.start();

            }
            else{
                stopPlaying();
                mp = MediaPlayer.create(this, audioQ2[cardTapped-1]);
                mp.start();
            }
        }
        else{
            //play audio


            if(Qari.equals("One")){

                stopPlaying();

                int index = cardTapped-1;
                mp = MediaPlayer.create(this, audioQ1[index]);
                mp.start();

            }
            else{
                stopPlaying();
                mp = MediaPlayer.create(this, audioQ2[cardTapped-1]);
                mp.start();
            }

            //update interface

            if (cardTapped!=audioQ1.length){
                System.out.println("-----------------not come in else---------------  "+audioQ1.length);
                imgId = findViewById(imageIds[(int) (cardTapped-1)]);
                imgId.setImageResource(R.drawable.rect2);

                imgId = findViewById(imageIds[(int) (cardTapped)]);
                imgId.setImageResource(R.drawable.rect3);
            }
            else{
                System.out.println("-----------------come in else---------------  "+cardTapped);
                // specific for the last cell
                imgId = findViewById(imageIds[(int) (cardTapped-1)]);
                imgId.setImageResource(R.drawable.rect2);

            }

            //update data
            updateSharedPref();
        }

    }
    public void updateSharedPref(){
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        long chaptervalue = prefs.getLong("learnChapterNineQari"+Qari, 1000);

        SharedPreferences.Editor editor = getSharedPreferences("SharedData", MODE_PRIVATE).edit();
        editor.putLong("learnChapterNineQari"+Qari,chaptervalue+1);
        editor.apply();

        updateOnServer(prefs.getLong("learnChapterNineQari"+Qari, 1000));

    }
    public void updateOnServer(long chaptervalue){


        userID = mAuth.getCurrentUser().getUid();

        db.collection("users").document(userID)
                .update("learnChapterNineQari"+Qari, chaptervalue)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });
    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopPlaying();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlaying();
    }

}