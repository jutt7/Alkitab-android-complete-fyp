package com.AWH.alkitab.Tafseer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.AWH.alkitab.R;

public class SurahFaatihah extends AppCompatActivity {
    MediaPlayer mp;
    Button playbtn, stopBtn;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_faatihah);

        playbtn = findViewById(R.id.play);
        stopBtn = findViewById(R.id.pause);

        seekBar = findViewById(R.id.seekBar);

         Handler mHandler = new Handler();


        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
//                seekBar.setMax(mp.getDuration()/1000);
                mp = MediaPlayer.create(SurahFaatihah.this, R.raw.surahfatihah);
                mp.start();



//Make sure you update Seekbar on UI thread
                SurahFaatihah.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if(mp != null){
                            int mCurrentPosition = mp.getCurrentPosition() / 1000;
                            seekBar.setProgress(mCurrentPosition);


                        }
                        mHandler.postDelayed(this, 1000);
                    }
                });

            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
            }
        });


//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(mp != null && fromUser){
//                    mp.seekTo(progress * 1000);
//                }
//            }
//        });


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
            seekBar.setProgress(0);
        }
    }
}