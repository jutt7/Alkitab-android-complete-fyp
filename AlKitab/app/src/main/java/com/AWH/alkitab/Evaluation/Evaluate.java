package com.AWH.alkitab.Evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.AWH.alkitab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Evaluate extends AppCompatActivity {

    SpeechRecognizer speechRecognizer;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;

    int count = 0;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;
    public static final String TAG = "TAG ";

    ImageView img3;
    SharedPreferences.Editor editor;
    String chr;

    int number;
    int check = 0;
    String chapter = "";
    int LangCode;

    private CardView c,c1,c2;

    TextView txt1,result;
    final String languageCodeUrdu = "ur-PK";
    final String languageCodeArabic = "ar-SA";

    int clickedCell ;

    ArrayList<String> characters = new ArrayList<>();

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        progressDialog = new ProgressDialog(this);

        c = findViewById(R.id.c);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);


        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
      

        txt1 = findViewById(R.id.txt1);
        result = findViewById(R.id.result);





        img3 = (ImageView) findViewById(R.id.img3);
        //img3.setVisibility(View.GONE);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            int resId = bundle.getInt("img");
             chr = bundle.getString("chr");
             LangCode = bundle.getInt("LangCode");
            img3.setImageResource(resId);
            number = bundle.getInt("filenumber");
            chapter = bundle.getString("chapter");
            clickedCell = bundle.getInt("clickedCell");
        }
        System.out.println("-------------char-----------------"+chr);

       if(clickedCell==6){
           characters.add("خا");
           characters.add("کھا");
       }
       if(clickedCell==23){
           characters.add("م");
           characters.add("میم");
       }
        //System.out.println("-------------char-----------------"+characters);









        //Permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},1 );
        }
        //Speech
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        if(LangCode==0){
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCodeUrdu);
        }
        else{
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCodeArabic);
        }


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    //listen
                    result.setText("");
                    speechRecognizer.startListening(speechRecognizerIntent);
                    txt1.setText("Stop");
                    Toast.makeText(Evaluate.this,"Recording has started...",Toast.LENGTH_SHORT).show();
                    count=1;
                }
                else{
                    speechRecognizer.stopListening();
                    count=0;

                    txt1.setText("Start");
                    Toast.makeText(Evaluate.this,"Recording has stopped...",Toast.LENGTH_SHORT).show();
                    progressDialog.setMessage("Calcualting ...");
                    progressDialog.show();

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
                System.out.println("------size of buffer-------"+buffer);
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
                progressDialog.setMessage("Calcualting ...");
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //txt1.setText(data.get(0));

                        if(clickedCell==6){
                            if(data.get(0).equals(characters.get(0))){
                                System.out.println("---------------Right-------------");
                                result.setText("Pronounced Correctly");
                                result.setTextColor(Color.parseColor("#228b22"));
                                // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();

                                //updating local storage and server
                                updateData();

                            }
                            else if(data.get(0).equals(characters.get(1))){
                                System.out.println("---------------Right-------------");
                                result.setText("Pronounced Correctly");
                                result.setTextColor(Color.parseColor("#228b22"));
                                // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();

                                //updating local storage and server
                                updateData();
                            }
                            else {
                                result.setText("TRY AGAIN!");
                                result.setTextColor(Color.RED);
                                //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(clickedCell==23){
                            if(data.get(0).equals(characters.get(0))){
                                System.out.println("---------------Right-------------");
                                result.setText("Pronounced Correctly");
                                result.setTextColor(Color.parseColor("#228b22"));
                                // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();

                                //updating local storage and server
                                updateData();

                            }
                            else if(data.get(0).equals(characters.get(1))){
                                System.out.println("---------------Right-------------");
                                result.setText("Pronounced Correctly");
                                result.setTextColor(Color.parseColor("#228b22"));
                                // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();

                                //updating local storage and server
                                updateData();
                            }
                            else {
                                result.setText("TRY AGAIN!");
                                result.setTextColor(Color.RED);
                                //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            if(data.get(0).equals(chr)){
                                System.out.println("---------------Right-------------");
                                result.setText("Pronounced Correctly");
                                result.setTextColor(Color.parseColor("#228b22"));
                                // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();

                                //updating local storage and server
                                updateData();

                            }
                            else {
                                result.setText("TRY AGAIN!");
                                result.setTextColor(Color.RED);
                                //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                            }
                        }



                    }
                },1000);
                progressDialog.dismiss();

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
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

    public void updateData()
    {


        SharedPreferences.Editor editor = getSharedPreferences("SharedData", MODE_PRIVATE).edit();
        editor.putLong("evaluateChapterOne",getValue()+1);
        editor.apply();

        updateArray();

        //updating server
        updateOnServer(getValue());
       updateServerList();


    }

    public void updateOnServer(long chaptervalue){


        userID = mAuth.getCurrentUser().getUid();

        db.collection("users").document(userID)
                .update(
                        "evaluateChapterOne", chaptervalue
                )
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

    public void updateArray(){
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        String itemsValueArray = prefs.getString("evaluateChapterOneArray", "awais");
        System.out.println("-------------itemsValueArray----------------"+itemsValueArray);

        //creating tokens
        StringTokenizer tokenArray = new StringTokenizer(itemsValueArray," ");
        while (tokenArray.hasMoreTokens()) {
            boolean b = Boolean.parseBoolean(tokenArray.nextToken());
            list.add(b);
        }

        //updating
        System.out.println(list.size());
        list.set(clickedCell,true);

        System.out.println(list);

        //converting to string
        String evaluateChapterOneArray = "";
        for (int i=0;i<30;i++){
            evaluateChapterOneArray = evaluateChapterOneArray+list.get(i)+" ";
        }


        System.out.println("-------------evaluateChapterOneArray----------------"+evaluateChapterOneArray);

        editor = getSharedPreferences("SharedData", Context.MODE_PRIVATE).edit();
        editor.putString("evaluateChapterOneArray",evaluateChapterOneArray);
        editor.apply();

    }

    public void updateServerList(){
        userID = mAuth.getCurrentUser().getUid();
        System.out.println("----------------in function-------------");
        db.collection("users") .whereEqualTo("id", userID)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ArrayList a = (ArrayList) document.get("evaluateChapterOneArray");

                                a.set(clickedCell,true);

                                // updating the value

                                db.collection("users").document(userID)
                                        .update(
                                                "evaluateChapterOneArray", a
                                        )
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully updated! in this");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error updating document", e);
                                            }
                                        });


                            }


                        }
                        else {

                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public int getValue(){
        int totalEvaluate = 0;
        SharedPreferences prefs = getSharedPreferences("SharedData", MODE_PRIVATE);
        String itemsValueArray = prefs.getString("evaluateChapterOneArray", "awais");

        //creating tokens
        StringTokenizer tokenArray = new StringTokenizer(itemsValueArray," ");
        while (tokenArray.hasMoreTokens()) {
            boolean b = Boolean.parseBoolean(tokenArray.nextToken());
            if (b){
                totalEvaluate++;
            }
            }

        return  totalEvaluate;

        }
    }


