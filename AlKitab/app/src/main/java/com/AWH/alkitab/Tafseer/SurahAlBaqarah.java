package com.AWH.alkitab.Tafseer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.AWH.alkitab.R;

public class SurahAlBaqarah extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;
    Button playbtn1, stopBtn1,
    playbtn2, stopBtn2,
    playbtn3, stopBtn3,
    playbtn4, stopBtn4,
    playbtn5, stopBtn5,
    playbtn6, stopBtn6,
    playbtn7, stopBtn7,
    playbtn8, stopBtn8,
    playbtn9, stopBtn9,
    playbtn10, stopBtn10;
    SeekBar seekBar;

    Integer [] audios = {R.raw.baqrah1,R.raw.baqrah2,R.raw.baqrah3,R.raw.baqrah4,R.raw.baqrah5,
            R.raw.baqrah6,R.raw.baqrah7,R.raw.baqrah8,R.raw.baqrah9,R.raw.baqrah10};

    Integer [] seeks = {R.id.seekBar,R.id.seekBar2,R.id.seekBar3,R.id.seekBar4,R.id.seekBar5,
            R.id.seekBar6,R.id.seekBar7,R.id.seekBar8,R.id.seekBar9,R.id.seekBar10};

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_al_baqarah);

        playbtn1 = findViewById(R.id.play);
        stopBtn1 = findViewById(R.id.pause);

        initialize();

        call();






//        playbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                stopPlaying();
////                seekBar.setMax(mp.getDuration()/1000);
//                mp = MediaPlayer.create(SurahAlBaqarah.this, R.raw.surahfatihah);
//                mp.start();
//
//
//
////Make sure you update Seekbar on UI thread
//                SurahAlBaqarah.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        if(mp != null){
//                            int mCurrentPosition = mp.getCurrentPosition() / 1000;
//                            seekBar.setProgress(mCurrentPosition);
//
//
//                        }
//                        mHandler.postDelayed(this, 1000);
//                    }
//                });
//
//            }
//        });







    }

    private void initialize() {
        playbtn1 = findViewById(R.id.play);
        stopBtn1 = findViewById(R.id.pause);
        playbtn2 = findViewById(R.id.play2);
        stopBtn2 = findViewById(R.id.pause2);
        playbtn3 = findViewById(R.id.play3);
        stopBtn3 = findViewById(R.id.pause3);
        playbtn4 = findViewById(R.id.play4);
        stopBtn4 = findViewById(R.id.pause4);
        playbtn5 = findViewById(R.id.play5);
        stopBtn5 = findViewById(R.id.pause5);
        playbtn6 = findViewById(R.id.play6);
        stopBtn6 = findViewById(R.id.pause6);
        playbtn7 = findViewById(R.id.play7);
        stopBtn7 = findViewById(R.id.pause7);
        playbtn8 = findViewById(R.id.play8);
        stopBtn8 = findViewById(R.id.pause8);
        playbtn9 = findViewById(R.id.play9);
        stopBtn9 = findViewById(R.id.pause9);
        playbtn10 = findViewById(R.id.play10);
        stopBtn10 = findViewById(R.id.pause10);
    }

    private void call() {
        playbtn1.setOnClickListener(this);
        stopBtn1.setOnClickListener(this);
        playbtn2.setOnClickListener(this);
        stopBtn2.setOnClickListener(this);
        playbtn3.setOnClickListener(this);
        stopBtn3.setOnClickListener(this);
        playbtn4.setOnClickListener(this);
        stopBtn4.setOnClickListener(this);
        playbtn5.setOnClickListener(this);
        stopBtn5.setOnClickListener(this);
        playbtn6.setOnClickListener(this);
        stopBtn6.setOnClickListener(this);
        playbtn7.setOnClickListener(this);
        stopBtn7.setOnClickListener(this);
        playbtn8.setOnClickListener(this);
        stopBtn8.setOnClickListener(this);
        playbtn9.setOnClickListener(this);
        stopBtn9.setOnClickListener(this);
        playbtn10.setOnClickListener(this);
        stopBtn10.setOnClickListener(this);
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
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;


        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                next(0);

                break;
            case R.id.play2:
                next(1);

                break;
            case R.id.play3:
                next(2);

                break;

            case R.id.play4:
                next(3);

                break;
            case R.id.play5:
                next(4);

                break;
            case R.id.play6:
                next(5);

                break;
            case R.id.play7:
                next(6);

                break;
            case R.id.play8:
                next(7);

                break;
            case R.id.play9:
                next(8);

                break;
            case R.id.play10:
                next(9);

                break;

            case R.id.pause:
            case R.id.pause10:
            case R.id.pause9:
            case R.id.pause8:
            case R.id.pause7:
            case R.id.pause6:
            case R.id.pause5:

            case R.id.pause4:
            case R.id.pause3:
            case R.id.pause2:
                stopPlaying();

                break;


        }
    }


    public void next(int n){
        stopPlaying();
//                seekBar.setMax(mp.getDuration()/1000);
        mp = MediaPlayer.create(SurahAlBaqarah.this, audios[n]);
        mp.start();


        SeekBar s = findViewById(seeks[n]);






//Make sure you update Seekbar on UI thread
        SurahAlBaqarah.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mp != null){
                    int mCurrentPosition = mp.getCurrentPosition() / 1000;
                    s.setProgress(mCurrentPosition);


                }
                mHandler.postDelayed(this, 1000);
            }
        });

//        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                for (int i = 0;i<seeks.length;i++){
//                    SeekBar test = findViewById(seeks[n]);
//                    if(test.getId()!=s.getId()){
//                        test.setProgress(0);
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
//                if(mp != null && fromUser){
//                    mp.seekTo(progress * 1000);
//                }
//            }
//        });
    }
}