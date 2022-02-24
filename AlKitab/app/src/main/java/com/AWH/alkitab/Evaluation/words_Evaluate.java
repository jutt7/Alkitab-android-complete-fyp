package com.AWH.alkitab.Evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.StringTokenizer;

public class words_Evaluate extends AppCompatActivity {


    SpeechRecognizer speechRecognizer;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;

    int count = 0;


    ImageView img3;

    String chr;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;
    public static final String TAG = "TAG ";

    int number;
    String chapter = "";

    private CardView c,c1,c2;

    TextView txt1,result;
    final String languageCodeArabic = "ar-SA";

    int clickedCell;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words__evaluate);



        c1 = findViewById(R.id.c1);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();



        txt1 = findViewById(R.id.txt1);
        result = findViewById(R.id.result);



        img3 =  findViewById(R.id.img3);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            int resId = bundle.getInt("img");
            chr = bundle.getString("chr");
            System.out.println("---------res Id-----------"+resId);
            img3.setImageResource(resId);
            number = bundle.getInt("filenumber");
            chapter = bundle.getString("chapter");
            clickedCell = bundle.getInt("clickedCell");
        }
        System.out.println("------------------------------"+chr);




        //Permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},1 );
        }
        //Speech
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCodeArabic);




        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    //listen
                    result.setText("");
                    speechRecognizer.startListening(speechRecognizerIntent);
                    txt1.setText("Stop");
                    Toast.makeText(words_Evaluate.this,"Recording has started...",Toast.LENGTH_SHORT).show();
                    count=1;
                }
                else{
                    speechRecognizer.stopListening();
                    count=0;
                    txt1.setText("Start");
                    Toast.makeText(words_Evaluate.this,"Recording has stopped...",Toast.LENGTH_SHORT).show();

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
                //txt1.setText(data.get(0));
                if(data.get(0).equals(chr)){
                    System.out.println("---------------Right-------------");
                    result.setTextColor(Color.parseColor("#228b22"));
                    result.setText("Pronounced Correctly");

                    //updating the data
                    updateData();
                }
                else {
                    result.setText("TRY AGAIN!");
                    result.setTextColor(Color.RED);
                    //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
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
        editor.putLong("evaluateChapterTwo",getValue()+1);
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
                        "evaluateChapterTwo", chaptervalue
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
        String itemsValueArray = prefs.getString("evaluateChapterTwoArray", "awais");
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

        String evaluateChapterTwoArray = "";
        for (int i=0;i<list.size();i++){
            evaluateChapterTwoArray = evaluateChapterTwoArray+list.get(i)+" ";
        }


        System.out.println("-------------evaluateChapterTwoArray----------------"+evaluateChapterTwoArray);

        editor = getSharedPreferences("SharedData", Context.MODE_PRIVATE).edit();
        editor.putString("evaluateChapterTwoArray",evaluateChapterTwoArray);
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
                                ArrayList a = (ArrayList) document.get("evaluateChapterTwoArray");

                                a.set(clickedCell,true);
                                System.out.println("----------------a- "+a );

                                // updating the value

                                db.collection("users").document(userID)
                                        .update(
                                                "evaluateChapterTwoArray", a
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
        String itemsValueArray = prefs.getString("evaluateChapterTwoArray", "awais");

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