package com.AWH.alkitab.Learning.Quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.AWH.alkitab.R;

import java.util.Random;

public class Quiz_main extends AppCompatActivity implements View.OnClickListener {
    CardView c0,c1,c2,c3,c4;

    CardView [] cards = {c1,c2,c3,c4};

    MediaPlayer mp;

    ImageView img ;

    ImageView imgId;

    TextView answer;




    Integer [] imageIds = {R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4};




    int [] chapter1Images = {  R.drawable.a1,R.drawable.a2,R.drawable.a3,
            R.drawable.a4,R.drawable.a5,R.drawable.a6,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.a10,R.drawable.a11,R.drawable.a12,
            R.drawable.a13,R.drawable.a14,R.drawable.a15,
            R.drawable.a16,R.drawable.a17,R.drawable.a18,
            R.drawable.a19,R.drawable.a20,R.drawable.a21,
            R.drawable.a22,R.drawable.a23,R.drawable.a24,
            R.drawable.a25,R.drawable.a26,R.drawable.a27,
            R.drawable.a28,R.drawable.a29,R.drawable.a30};

    Integer [] chapter1Audios = {R.raw.a1_q1,R.raw.a2_q1,R.raw.a3_q1,R.raw.a4_q1,R.raw.a5_q1,R.raw.a6_q1,R.raw.a7_q1,R.raw.a8_q1,
            R.raw.a9_q1,R.raw.a10_q1,R.raw.a11_q1,R.raw.a12_q1,R.raw.a13_q1,R.raw.a14_q1,R.raw.a15_q1,R.raw.a16_q1,R.raw.a17_q1,
            R.raw.a18_q1,R.raw.a19_q1,R.raw.a20_q1,R.raw.a21_q1,R.raw.a22_q1,R.raw.a23_q1,R.raw.a24_q1,R.raw.a25_q1,R.raw.a26_q1,
            R.raw.a27_q1,R.raw.a28_q1,R.raw.a29_q1,R.raw.a30_q1};



    int [] chapter2Images = {  R.drawable.b1,R.drawable.b2,R.drawable.b3,
            R.drawable.b4,R.drawable.b5,R.drawable.b6,
            R.drawable.b7,R.drawable.b8,R.drawable.b9,
            R.drawable.b10,R.drawable.b11,R.drawable.b12,
            R.drawable.b13,R.drawable.b14,R.drawable.b15,
            R.drawable.b16,R.drawable.b17,R.drawable.b18,
            R.drawable.b19,R.drawable.b20,R.drawable.b21,
            R.drawable.b22,R.drawable.b23,R.drawable.b24,
            R.drawable.b25,R.drawable.b26,R.drawable.b27,
            R.drawable.b28,R.drawable.b29,R.drawable.b30,
            R.drawable.b31,R.drawable.b32,R.drawable.b33,
            R.drawable.b34,R.drawable.b35,R.drawable.b36,
            R.drawable.b37,R.drawable.b38,R.drawable.b39,
            R.drawable.b40,R.drawable.b41,R.drawable.b42,
            R.drawable.b43,R.drawable.b44,R.drawable.b45,
            R.drawable.b46,R.drawable.b47,R.drawable.b48,
            R.drawable.b49,R.drawable.b50};
    Integer [] chapter2Audios = {R.raw.b1_q1,R.raw.b2_q1,R.raw.b3_q1,R.raw.b4_q1,R.raw.b5_q1,R.raw.b6_q1,R.raw.b7_q1,R.raw.b8_q1,
            R.raw.b9_q1,R.raw.b10_q1,R.raw.b11_q1,R.raw.b12_q1,R.raw.b13_q1,R.raw.b14_q1,R.raw.b15_q1,R.raw.b16_q1,R.raw.b17_q1,
            R.raw.b18_q1,R.raw.b19_q1,R.raw.b20_q1,R.raw.b21_q1,R.raw.b21_q1,R.raw.b23_q1,R.raw.b24_q1,
            R.raw.b25_q1,R.raw.b26_q1,R.raw.b27_q1,R.raw.b28_q1,R.raw.b29_q1,R.raw.b30_q1,R.raw.b31_q1,R.raw.b32_q1,
            R.raw.b33_q1,R.raw.b34_q1,R.raw.b35_q1,R.raw.b36_q1,R.raw.b37_q1,R.raw.b38_q1,R.raw.b39_q1,R.raw.b40_q1,R.raw.b41_q1,
            R.raw.b42_q1,R.raw.b43_q1,R.raw.b44_q1,R.raw.b45_q1,R.raw.b46_q1,R.raw.b47_q1,R.raw.b48_q1,
            R.raw.b49_q1,R.raw.b50_q1};




    int [] chapter3Images = {  R.drawable.c1,R.drawable.c2,R.drawable.c3,
            R.drawable.c4,R.drawable.c5,R.drawable.c6,
            R.drawable.c7,R.drawable.c8,R.drawable.c9,
            R.drawable.c10,R.drawable.c11,R.drawable.c12,
            R.drawable.c13,R.drawable.c14};
    Integer [] chapter3Audios = {R.raw.c1_q1,R.raw.c2_q1,R.raw.c3_q1,R.raw.c4_q1,R.raw.c5_q1,R.raw.c6_q1,R.raw.c7_q1,R.raw.c8_q1,
            R.raw.c9_q1,R.raw.c10_q1,R.raw.c11_q1,R.raw.c12_q1,R.raw.c13_q1,R.raw.c14_q1};


    int [] chapter4Images = {  R.drawable.d1,R.drawable.d2,R.drawable.d3,
            R.drawable.d4,R.drawable.d5,R.drawable.d6,
            R.drawable.d7,R.drawable.d8,R.drawable.d9,
            R.drawable.d10,R.drawable.d11,R.drawable.d12,
            R.drawable.d13,R.drawable.d14,R.drawable.d15,
            R.drawable.d16,R.drawable.d17,R.drawable.d18,
            R.drawable.d19,R.drawable.d20,R.drawable.d21,
            R.drawable.d22,R.drawable.d23,R.drawable.d24,
            R.drawable.d25,R.drawable.d26,R.drawable.d27,
            R.drawable.d28,R.drawable.d29,R.drawable.d30,
            R.drawable.d31,R.drawable.d32,R.drawable.d33,
            R.drawable.d34,R.drawable.d35,R.drawable.d36,
            R.drawable.d37,R.drawable.d38,R.drawable.d39,
            R.drawable.d40,R.drawable.d41,R.drawable.d42,
            R.drawable.d43,R.drawable.d44,R.drawable.d45,
            R.drawable.d46,R.drawable.d47,R.drawable.d48,
            R.drawable.d49,R.drawable.d50,R.drawable.d51,
            R.drawable.d52,R.drawable.d53,R.drawable.d54,
            R.drawable.d55,R.drawable.d56,R.drawable.d57,
            R.drawable.d58,R.drawable.d59,R.drawable.d60,
            R.drawable.d61,R.drawable.d62,R.drawable.d63,
            R.drawable.d64,R.drawable.d65,R.drawable.d66,
            R.drawable.d67,R.drawable.d68,R.drawable.d69,
            R.drawable.d70,R.drawable.d71,R.drawable.d72,
            R.drawable.d73,R.drawable.d74,R.drawable.d75,
            R.drawable.d76,R.drawable.d77,R.drawable.d78,
            R.drawable.d79,R.drawable.d80,R.drawable.d81,
            R.drawable.d82,R.drawable.d83,R.drawable.d84};
    Integer [] chapter4Audios = {R.raw.d1_q1,R.raw.d2_q1,R.raw.d3_q1,R.raw.d4_q1,R.raw.d5_q1,R.raw.d6_q1,R.raw.d7_q1,R.raw.d8_q1,
            R.raw.d9_q1,R.raw.d10_q1,R.raw.d11_q1,R.raw.d12_q1,R.raw.d13_q1,R.raw.d14_q1,R.raw.d15_q1,R.raw.d16_q1,R.raw.d17_q1,
            R.raw.d18_q1,R.raw.d19_q1,R.raw.d20_q1,R.raw.d21_q1,R.raw.d22_q1,R.raw.d23_q1,R.raw.d24_q1,
            R.raw.d25_q1,R.raw.d26_q1,R.raw.d27_q1,R.raw.d28_q1,R.raw.d29_q1,R.raw.d30_q1,R.raw.d31_q1,R.raw.d32_q1,
            R.raw.d33_q1,R.raw.d34_q1,R.raw.d35_q1,R.raw.d36_q1,R.raw.d37_q1,R.raw.d38_q1,R.raw.d39_q1,R.raw.d40_q1,R.raw.d41_q1,
            R.raw.d42_q1,R.raw.d43_q1,R.raw.d44_q1,R.raw.d45_q1,R.raw.d46_q1,R.raw.d47_q1,R.raw.d48_q1,
            R.raw.d49_q1,R.raw.d50_q1,R.raw.d51_q1,R.raw.d52_q1,R.raw.d53_q1,R.raw.d54_q1,R.raw.d55_q1,R.raw.d56_q1,
            R.raw.d57_q1,R.raw.d58_q1,R.raw.d59_q1,R.raw.d60_q1,R.raw.d61_q1,R.raw.d62_q1,R.raw.d63_q1,R.raw.d64_q1,R.raw.d65_q1,
            R.raw.d66_q1,R.raw.d67_q1,R.raw.d68_q1,R.raw.d69_q1,R.raw.d70_q1,R.raw.d71_q1,R.raw.d72_q1,
            R.raw.d73_q1,R.raw.d74_q1,R.raw.d75_q1,R.raw.d76_q1,R.raw.d77_q1,R.raw.d78_q1,R.raw.d79_q1,R.raw.d80_q1,
            R.raw.d81_q1,R.raw.d82_q1,R.raw.d83_q1,R.raw.d84_q1};

    int [] chapter5Images = {  R.drawable.e1,R.drawable.e2,R.drawable.e3,
            R.drawable.e4,R.drawable.e5,R.drawable.e6,
            R.drawable.e7,R.drawable.e8,R.drawable.e9,
            R.drawable.e10,R.drawable.e11,R.drawable.e12,
            R.drawable.e13,R.drawable.e14,R.drawable.e15,
            R.drawable.e16,R.drawable.e17,R.drawable.e18,
            R.drawable.e19,R.drawable.e20,R.drawable.e21,
            R.drawable.e22,R.drawable.e23,R.drawable.e24,
            R.drawable.e25,R.drawable.e26,R.drawable.e27,
            R.drawable.e28,R.drawable.e29,R.drawable.e30,
            R.drawable.e31,R.drawable.e32,R.drawable.e33,
            R.drawable.e34,R.drawable.e35,R.drawable.e36,
            R.drawable.e37,R.drawable.e38,R.drawable.e39,
            R.drawable.e40,R.drawable.e41,R.drawable.e42,
            R.drawable.e43,R.drawable.e44,R.drawable.e45,
            R.drawable.e46,R.drawable.e47,R.drawable.e48,
            R.drawable.e49,R.drawable.e50,R.drawable.e51,
            R.drawable.e52,R.drawable.e53,R.drawable.e54,
            R.drawable.e55,R.drawable.e56,R.drawable.e57,
            R.drawable.e58,R.drawable.e59,R.drawable.e60,
            R.drawable.e61,R.drawable.e62,R.drawable.e63,
            R.drawable.e64,R.drawable.e65,R.drawable.e66,
            R.drawable.e67,R.drawable.e68,R.drawable.e69,
            R.drawable.e70,R.drawable.e71,R.drawable.e72,
            R.drawable.e73,R.drawable.e74,R.drawable.e75,
            R.drawable.e76,R.drawable.e77,R.drawable.e78,
            R.drawable.e79,R.drawable.e80,R.drawable.e81,
            R.drawable.e82,R.drawable.e83,R.drawable.e84};
    Integer [] chapter5Audios = {R.raw.e1_q1,R.raw.e2_q1,R.raw.e3_q1,R.raw.e4_q1,R.raw.e5_q1,R.raw.e6_q1,R.raw.e7_q1,R.raw.e8_q1,
            R.raw.e9_q1,R.raw.e10_q1,R.raw.e11_q1,R.raw.e12_q1,R.raw.e13_q1,R.raw.e14_q1,R.raw.e15_q1,R.raw.e16_q1,R.raw.e17_q1,
            R.raw.e18_q1,R.raw.e19_q1,R.raw.e20_q1,R.raw.e21_q1,R.raw.e22_q1,R.raw.e23_q1,R.raw.e24_q1,
            R.raw.e25_q1,R.raw.e26_q1,R.raw.e27_q1,R.raw.e28_q1,R.raw.e29_q1,R.raw.e30_q1,R.raw.e31_q1,R.raw.e32_q1,
            R.raw.e33_q1,R.raw.e34_q1,R.raw.e35_q1,R.raw.e36_q1,R.raw.e37_q1,R.raw.e38_q1,R.raw.e39_q1,R.raw.e40_q1,R.raw.e41_q1,
            R.raw.e42_q1,R.raw.e43_q1,R.raw.e44_q1,R.raw.e45_q1,R.raw.e46_q1,R.raw.e47_q1,R.raw.e48_q1,
            R.raw.e49_q1,R.raw.e50_q1,R.raw.e51_q1,R.raw.e52_q1,R.raw.e53_q1,R.raw.e54_q1,R.raw.e55_q1,R.raw.e56_q1,
            R.raw.e57_q1,R.raw.e58_q1,R.raw.e59_q1,R.raw.e60_q1,R.raw.e61_q1,R.raw.e62_q1,R.raw.e63_q1,R.raw.e64_q1,R.raw.e65_q1,
            R.raw.e66_q1,R.raw.e67_q1,R.raw.e68_q1,R.raw.e69_q1,R.raw.e70_q1,R.raw.e71_q1,R.raw.e72_q1,
            R.raw.e73_q1,R.raw.e74_q1,R.raw.e75_q1,R.raw.e76_q1,R.raw.e77_q1,R.raw.e78_q1,R.raw.e79_q1,R.raw.e80_q1,
            R.raw.e81_q1,R.raw.e82_q1,R.raw.e83_q1,R.raw.e84_q1};
    int [] chapter6Images = {  R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f4, R.drawable.f5, R.drawable.f6,
            R.drawable.f7, R.drawable.f8, R.drawable.f9,
            R.drawable.f10, R.drawable.f11, R.drawable.f12,
            R.drawable.f13, R.drawable.f14, R.drawable.f15,
            R.drawable.f16, R.drawable.f17, R.drawable.f18,
            R.drawable.f19, R.drawable.f20, R.drawable.f21,
            R.drawable.f22, R.drawable.f23, R.drawable.f24,
            R.drawable.f25, R.drawable.f26, R.drawable.f27,
            R.drawable.f28, R.drawable.f29, R.drawable.f30,
            R.drawable.f31, R.drawable.f32, R.drawable.f33,
            R.drawable.f34, R.drawable.f35, R.drawable.f36,
            R.drawable.f37, R.drawable.f38, R.drawable.f39,
            R.drawable.f40, R.drawable.f41, R.drawable.f42,
            R.drawable.f43, R.drawable.f44, R.drawable.f45,
            R.drawable.f46, R.drawable.f47, R.drawable.f48,
            R.drawable.f49, R.drawable.f50, R.drawable.f51,
            R.drawable.f52,R.drawable.f53,R.drawable.f54};
    Integer [] chapter6Audios = {R.raw.f1_q1,R.raw.f2_q1,R.raw.f3_q1,R.raw.f4_q1,R.raw.f5_q1,R.raw.f6_q1,R.raw.f7_q1,R.raw.f8_q1,
            R.raw.f9_q1,R.raw.f10_q1,R.raw.f11_q1,R.raw.f12_q1,R.raw.f13_q1,R.raw.f14_q1,R.raw.f15_q1,R.raw.f16_q1,R.raw.f17_q1,
            R.raw.f18_q1,R.raw.f19_q1,R.raw.f20_q1,R.raw.f21_q1,R.raw.f22_q1,R.raw.f23_q1,R.raw.f24_q1,
            R.raw.f25_q1,R.raw.f26_q1,R.raw.f27_q1,R.raw.f28_q1,R.raw.f29_q1,R.raw.f30_q1,R.raw.f31_q1,R.raw.f32_q1,
            R.raw.f33_q1,R.raw.f34_q1,R.raw.f35_q1,R.raw.f36_q1,R.raw.f37_q1,R.raw.f38_q1,R.raw.f39_q1,R.raw.f40_q1,R.raw.f41_q1,
            R.raw.f42_q1,R.raw.f43_q1,R.raw.f44_q1,R.raw.f45_q1,R.raw.f46_q1,R.raw.f47_q1,R.raw.f48_q1,
            R.raw.f49_q1,R.raw.f50_q1,R.raw.f51_q1,R.raw.f52_q1,R.raw.f53_q1,R.raw.f54_q1};
    int [] chapter7Images = {  R.drawable.g1, R.drawable.g2, R.drawable.g3,
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
    Integer [] chapter7Audios = {R.raw.j1_q1,R.raw.j2_q1,R.raw.j3_q1,R.raw.j4_q1,R.raw.j5_q1,R.raw.j6_q1,R.raw.j7_q1,R.raw.j8_q1,
            R.raw.j9_q1,R.raw.j10_q1,R.raw.j11_q1,R.raw.j12_q1,R.raw.j13_q1,R.raw.j14_q1,R.raw.j15_q1,R.raw.j16_q1,R.raw.j17_q1,
            R.raw.j18_q1,R.raw.j19_q1,R.raw.j20_q1,R.raw.j21_q1,R.raw.j22_q1,R.raw.j23_q1,R.raw.j24_q1,
            R.raw.j25_q1,R.raw.j26_q1,R.raw.j27_q1,R.raw.j28_q1,R.raw.j29_q1,R.raw.j30_q1,R.raw.j31_q1,R.raw.j32_q1,
            R.raw.j33_q1,R.raw.j34_q1,R.raw.j35_q1,R.raw.j36_q1,R.raw.j37_q1,R.raw.j38_q1,R.raw.j39_q1,R.raw.j40_q1,R.raw.j41_q1,
            R.raw.j42_q1,R.raw.j43_q1,R.raw.j44_q1,R.raw.j45_q1,R.raw.j46_q1,R.raw.j47_q1,R.raw.j48_q1,
    };
    int [] chapter8Images = {  R.drawable.h1,R.drawable.h2,R.drawable.h3,
            R.drawable.h4,R.drawable.h5,R.drawable.h6,
            R.drawable.h7,R.drawable.h8,R.drawable.h9,
            R.drawable.h10,R.drawable.h11,R.drawable.h12,
            R.drawable.h13,R.drawable.h14,R.drawable.h15,
            R.drawable.h16,R.drawable.h17,R.drawable.h18,
            R.drawable.h19,R.drawable.h20,R.drawable.h21,
            R.drawable.h22,R.drawable.h23,R.drawable.h24,
            R.drawable.h25,R.drawable.h26,R.drawable.h27,
            R.drawable.h28,R.drawable.h29,R.drawable.h30,
            R.drawable.h31,R.drawable.h32,R.drawable.h33,
            R.drawable.h34,R.drawable.h35,R.drawable.h36,
            R.drawable.h37,R.drawable.h38,R.drawable.h39,
            R.drawable.h40,R.drawable.h41,R.drawable.h42,
            R.drawable.h43,R.drawable.h44,R.drawable.h45,
            R.drawable.h46,R.drawable.h47,R.drawable.h48,
            R.drawable.h49,R.drawable.h50,R.drawable.h51,
            R.drawable.h52,R.drawable.h53,R.drawable.h54,
            R.drawable.h55,R.drawable.h56,R.drawable.h57,
            R.drawable.h58,R.drawable.h59,R.drawable.h60,
            R.drawable.h61,R.drawable.h62,R.drawable.h63,
            R.drawable.h64,R.drawable.h65,R.drawable.h66,
            R.drawable.h67,R.drawable.h68,R.drawable.h69,
            R.drawable.h70,R.drawable.h71,R.drawable.h72,
            R.drawable.h73,R.drawable.h74,R.drawable.h75,
            R.drawable.h76,R.drawable.h77,R.drawable.h78,
            R.drawable.h79,R.drawable.h80,R.drawable.h81,
            R.drawable.h82,R.drawable.h83,R.drawable.h84,
            R.drawable.h85,R.drawable.h86,R.drawable.h87,
            R.drawable.h88,
            R.drawable.h89,R.drawable.h90,R.drawable.h91,
            R.drawable.h92,R.drawable.h93,R.drawable.h94,
            R.drawable.h95,R.drawable.h96,R.drawable.h97,
            R.drawable.h98,R.drawable.h99,R.drawable.h100,
            R.drawable.h101,R.drawable.h102,R.drawable.h103,
            R.drawable.h104,R.drawable.h105,R.drawable.h106,
            R.drawable.h107,R.drawable.h108,R.drawable.h109,
            R.drawable.h110,R.drawable.h111,R.drawable.h112,
            R.drawable.h113,R.drawable.h114,R.drawable.h115,
            R.drawable.h116,R.drawable.h117,R.drawable.h118,
            R.drawable.h119,R.drawable.h120,R.drawable.h121,
            R.drawable.h122,R.drawable.h123,R.drawable.h124,
            R.drawable.h125,R.drawable.h126,R.drawable.h127,
            R.drawable.h128,R.drawable.h129,R.drawable.h130,
            R.drawable.h131,R.drawable.h132,R.drawable.h133,
            R.drawable.h134,R.drawable.h135,R.drawable.h136,
            R.drawable.h137,R.drawable.h138,R.drawable.h139,
            R.drawable.h140};
    Integer [] chapter8Audios = {R.raw.h1_q1,R.raw.h2_q1,R.raw.h3_q1,R.raw.h4_q1,R.raw.h5_q1,R.raw.h6_q1,R.raw.h7_q1,R.raw.h8_q1,
            R.raw.h9_q1,R.raw.h10_q1,R.raw.h11_q1,R.raw.h12_q1,R.raw.h13_q1,R.raw.h14_q1,R.raw.h15_q1,R.raw.h16_q1,R.raw.h17_q1,
            R.raw.h18_q1,R.raw.h19_q1,R.raw.h20_q1,R.raw.h21_q1,R.raw.h22_q1,R.raw.h23_q1,R.raw.h24_q1,
            R.raw.h25_q1,R.raw.h26_q1,R.raw.h27_q1,R.raw.h28_q1,R.raw.h29_q1,R.raw.h30_q1,R.raw.h31_q1,R.raw.h32_q1,
            R.raw.h33_q1,R.raw.h34_q1,R.raw.h35_q1,R.raw.h36_q1,R.raw.h37_q1,R.raw.h38_q1,R.raw.h39_q1,R.raw.h40_q1,R.raw.h41_q1,
            R.raw.h42_q1,R.raw.h43_q1,R.raw.h44_q1,R.raw.h45_q1,R.raw.h46_q1,R.raw.h47_q1,R.raw.h48_q1,
            R.raw.h49_q1,R.raw.h50_q1,R.raw.h51_q1,R.raw.h52_q1,R.raw.h53_q1,R.raw.h54_q1,R.raw.h55_q1,R.raw.h56_q1,
            R.raw.h57_q1,R.raw.h58_q1,R.raw.h59_q1,R.raw.h60_q1,R.raw.h61_q1,R.raw.h62_q1,R.raw.h63_q1,R.raw.h64_q1,R.raw.h65_q1,
            R.raw.h66_q1,R.raw.h67_q1,R.raw.h68_q1,R.raw.h69_q1,R.raw.h70_q1,R.raw.h71_q1,R.raw.h72_q1,
            R.raw.h73_q1,R.raw.h74_q1,R.raw.h75_q1,R.raw.h76_q1,R.raw.h77_q1,R.raw.h78_q1,R.raw.h79_q1,R.raw.h80_q1,
            R.raw.h81_q1,R.raw.h82_q1,R.raw.h83_q1,R.raw.h84_q1,R.raw.h85_q1,R.raw.h86_q1,R.raw.h87_q1,R.raw.h88_q1,R.raw.h89_q1,R.raw.h90_q1,
            R.raw.h91_q1,R.raw.h92_q1,R.raw.h93_q1,R.raw.h94_q1,R.raw.h95_q1,R.raw.h96_q1,R.raw.h97_q1,R.raw.h98_q1,
            R.raw.h99_q1,R.raw.h100_q1,
            R.raw.h101_q1,R.raw.h102_q1,R.raw.h103_q1,R.raw.h104_q1,R.raw.h105_q1,R.raw.h106_q1,R.raw.h107_q1,R.raw.h108_q1,
            R.raw.h109_q1,R.raw.h110_q1,
            R.raw.h111_q1,R.raw.h112_q1,R.raw.h113_q1,R.raw.h114_q1,R.raw.h115_q1,R.raw.h116_q1,R.raw.h117_q1,R.raw.h118_q1,
            R.raw.h119_q1,R.raw.h120_q1,
            R.raw.h121_q1,R.raw.h122_q1,R.raw.h123_q1,R.raw.h124_q1,R.raw.h125_q1,R.raw.h126_q1,R.raw.h127_q1,R.raw.h128_q1,
            R.raw.h129_q1,R.raw.h130_q1,
            R.raw.h131_q1,R.raw.h132_q1,R.raw.h133_q1,R.raw.h134_q1,R.raw.h135_q1,R.raw.h136_q1,R.raw.h137_q1,R.raw.h138_q1,
            R.raw.h139_q1,R.raw.h140_q1};
    int [] chapter9Images = {  R.drawable.i1,R.drawable.i2,R.drawable.i3,
            R.drawable.i4,R.drawable.i5,R.drawable.i6,
            R.drawable.i7,R.drawable.i8,R.drawable.i9,
            R.drawable.i10,R.drawable.i11,R.drawable.i12,
            R.drawable.i13,R.drawable.i14,R.drawable.i15,
            R.drawable.i16,R.drawable.i17,R.drawable.i18,
            R.drawable.i19,R.drawable.i20,R.drawable.i21,
            R.drawable.i22,R.drawable.i23,R.drawable.i24,
            R.drawable.i25,R.drawable.i26,R.drawable.i27,
            R.drawable.i28,R.drawable.i29,R.drawable.i30,
            R.drawable.i31,R.drawable.i32,R.drawable.i33,
            R.drawable.i34,R.drawable.i35,R.drawable.i36,
            R.drawable.i37,R.drawable.i38,R.drawable.i39,
            R.drawable.i40,R.drawable.i41,R.drawable.i42,
            R.drawable.i43,R.drawable.i44,R.drawable.i45,
            R.drawable.i46,R.drawable.i47,R.drawable.i48,
            R.drawable.i49,R.drawable.i50,R.drawable.i51,
            R.drawable.i52,R.drawable.i53,R.drawable.i54,
            R.drawable.i55,R.drawable.i56,R.drawable.i57,
            R.drawable.i58,R.drawable.i59,R.drawable.i60,
            R.drawable.i61,R.drawable.i62,R.drawable.i63,
            R.drawable.i64,R.drawable.i65,R.drawable.i66,
            R.drawable.i67,R.drawable.i68,R.drawable.i69,
            R.drawable.i70,R.drawable.i71,R.drawable.i72,
            R.drawable.i73,R.drawable.i74,R.drawable.i75,
            R.drawable.i76,R.drawable.i77,R.drawable.i78,
            R.drawable.i79,R.drawable.i80,R.drawable.i81,
            R.drawable.i82,R.drawable.i83,R.drawable.i84,
            R.drawable.i85,R.drawable.i86,R.drawable.i87,
            R.drawable.i88,
            R.drawable.i89,R.drawable.i90,R.drawable.i91,
            R.drawable.i92,R.drawable.i93,R.drawable.i94,
            R.drawable.i95,R.drawable.i96,R.drawable.i97,
            R.drawable.i98,R.drawable.i99,R.drawable.i100,
            R.drawable.i101};
    Integer [] chapter9Audios = {R.raw.i1_q1,R.raw.i2_q1,R.raw.i3_q1,R.raw.i4_q1,R.raw.i5_q1,R.raw.i6_q1,R.raw.i7_q1,R.raw.i8_q1,
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

    int count = 0;

    Button btn;

    Random rand = new Random();
    int [] index = new int[4];
    int n;

    int correctCount = 0;
    int chapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        img = findViewById(R.id.img1);

        answer = findViewById(R.id.answer);

        c0 = findViewById(R.id.c0);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);

        btn = findViewById(R.id.answerBtn);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            chapter = bundle.getInt("chapter");
        }

        setLayout();




        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                count++;
//                img.setImageResource(AnswerImages[count]);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1:
                System.out.println("--------------tapped1");
                if(n==1){
                    answer.setText("Right");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    correctCount++;
                    next();


                }
                else{
                    answer.setText("Wrong");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.c2:
                System.out.println("--------------tapped2");
                if(n==2){
                    answer.setText("Right");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    correctCount++;
                    next();
                }
                else{
                    answer.setText("Wrong");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.c3:
                System.out.println("--------------tapped3");
                if(n==3){
                    answer.setText("Right");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    correctCount++;
                    next();
                }
                else{
                    answer.setText("Wrong");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
                break;
            default:
                System.out.println("--------------tapped4");
                if(n==4){
                    answer.setText("Right");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    correctCount++;
                    next();
                }
                else{
                    answer.setText("Wrong");
                    answer.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
                break;

    }
    }

    public void next(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setLayout();

            }
        });
    }

    public void setLayout(){

        if(chapter==1){
            chapter1();
        }
        else if(chapter==2){

        }
        switch (chapter){
            case 1:
                chapter1();
                break;
            case 2:
                chapter2();
                break;
            case 3:
                chapter3();
                break;
            case 4:
                chapter4();
                break;
            case 5:
                chapter5();
                break;
            case 6:
                chapter6();
                break;
            case 7:
                chapter7();
                break;
            case 8:
                chapter8();
                break;
            default:
                chapter9();
                break;

        }





    }
    public void chapter1(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter1Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter1Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter1Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter2(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter2Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter2Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter2Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter3(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter3Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter3Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter3Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter4(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter4Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter4Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter4Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter5(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter5Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter5Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter5Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter6(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter6Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter6Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter6Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter7(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter7Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter7Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter7Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter8(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter8Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter8Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter8Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }
    public void chapter9(){
        if (correctCount < +5) {
            answer.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);

            for(int i = 0;i<index.length;i++){
                int n = rand.nextInt(chapter9Images.length);
                System.out.println("---------------n--------"+n);
                if(index[i]!=n){
                    index[i] = n;
                }

            }

            for (int i=0;i<index.length;i++){
                imgId = findViewById(imageIds[i]);
                imgId.setImageResource(chapter9Images[index[i]]);

            }

            int newRand = rand.nextInt(index.length);
            System.out.println("------rand------"+newRand);
            n = newRand+1;

            c0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp = MediaPlayer.create(Quiz_main.this, chapter9Audios[index[newRand]]);
                    mp.start();

                }
            });

        }
        else {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
            builder.setMessage("You have passed the level").setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Congratulation!");
            alert.show();
        }
    }

}