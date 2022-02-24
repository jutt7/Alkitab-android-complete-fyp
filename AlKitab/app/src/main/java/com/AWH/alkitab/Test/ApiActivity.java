package com.AWH.alkitab.Test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.AWH.alkitab.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Locale;

public class ApiActivity extends AppCompatActivity {

    SpeechRecognizer speechRecognizer;


    private static final int REQUEST_CODE_SPEECH_INPUT = 1;

    //public static final String EXTRA_LANGUAGE_MODEL = "ar-SA";

    private Button button;
    private TextView txt;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        txt = findViewById(R.id.textView10);


        button = findViewById(R.id.button);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},1 );
        }
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-SA");
        //speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ur-PK");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    //listen
                    speechRecognizer.startListening(speechRecognizerIntent);
                    button.setText("Stop");
                    count=1;
                }
                else{
                    speechRecognizer.stopListening();
                    count=0;
                    button.setText("Start");

                }
                }

        });
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> data = results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                System.out.println("-------------------Result-------------------"+data.get(0));
                txt.setText(data.get(0));

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });



//        button.setOnClickListener(v -> {
//            System.out.println("Tapped");
//
//            speak();
//
//
//
//
////            RequestQueue queue = Volley.newRequestQueue(ApiActivity.this);
////            String url ="http://192.168.18.108:8000/words";
////
////
////            // Request a string response from the provided URL.
////            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
////                    new Response.Listener<String>() {
////                        @Override
////                        public void onResponse(String response) {
////                            // Display the first 500 characters of the response string.
////                            System.out.println(("------------------------------------Response is: "+ response.substring(0,500)));
////                        }
////                    }, new Response.ErrorListener() {
////                @Override
////                public void onErrorResponse(VolleyError error) {
////                    System.out.println("----------------------------That didn't work!");
////                }
////            });
////            queue.add(stringRequest);
//        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
             if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                 Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT);
             }
             else{
                 Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT);

             }
        }
    }
}

//    private void speak(){
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-SA");
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi say something...");
//
//        try {
//            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
//        }
//        catch (Exception e){
//
//        }
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case REQUEST_CODE_SPEECH_INPUT:
//                if(resultCode==RESULT_OK && null!=data){
//                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//
//                    txt.setText(result.get(0));
//                }
//                break;
//        }
//    }
//}