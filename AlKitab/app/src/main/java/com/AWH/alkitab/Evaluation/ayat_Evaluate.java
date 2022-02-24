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

public class ayat_Evaluate extends AppCompatActivity {

    TextView ayatText;
    int ayatNum ;
    String ayatTxt = "";

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;
    public static final String TAG = "TAG ";

    int count = 0;

    private CardView c1;

    SpeechRecognizer speechRecognizer;

    final String languageCodeArabic = "ar-SA";

    ArrayList<String> ayats = new ArrayList<String>();

    TextView txt1,result;

    int clickedCell;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat__evaluate);

        ayatText = findViewById(R.id.ayatText);
        c1 = findViewById(R.id.c1);
        txt1 = findViewById(R.id.txt1);
        result = findViewById(R.id.result);



        ayats.add("انا اعطيناك الكوثر");
        ayats.add("فصل لربك وانحر");
        ayats.add("ان شانئك هو الابتر");
        ayats.add("فصلي لربك وانحر");

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();





        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            ayatNum = bundle.getInt("AyatNum");
            ayatTxt  =bundle.getString("Ayat");
            clickedCell = ayatNum;

        }
        System.out.println("------------------------------"+ayatNum);
        ayatText.setText(ayatTxt);


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
                    count=1;
                    Toast.makeText(ayat_Evaluate.this,"Recording has started...",Toast.LENGTH_SHORT).show();
                }
                else{
                    speechRecognizer.stopListening();
                    count=0;
                    txt1.setText("Start");
                    Toast.makeText(ayat_Evaluate.this,"Recording has stopped...",Toast.LENGTH_SHORT).show();

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
                if(ayatNum==1){
                    if((data.get(0).equals(ayats.get(ayatNum))) || (data.get(0).equals(ayats.get(3)))){

                        System.out.println("---------------Right-------------");
                        result.setText("Pronounced Correctly");
                        result.setTextColor(Color.parseColor("#228b22"));

                        //updating the data
                        updateData();
                    }
                    else {
                        System.out.println("--------------in else-------------------");
                        result.setText("TRY AGAIN!");
                        result.setTextColor(Color.RED);
                        //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    if(data.get(0).equals(ayats.get(ayatNum))){

                        System.out.println("---------------Right-------------");
                        result.setText("Pronounced Correctly");
                        result.setTextColor(Color.parseColor("#228b22"));
                        // Toast.makeText(Evaluate.this,"Right",Toast.LENGTH_SHORT).show();
                        updateData();
                    }
                    else {
                        System.out.println("--------------in 2nd else-------------------");
                        result.setText("TRY AGAIN!");
                        result.setTextColor(Color.RED);
                        //Toast.makeText(Evaluate.this,"Wrong",Toast.LENGTH_SHORT).show();
                    }

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
    public void updateData()
    {


        SharedPreferences.Editor editor = getSharedPreferences("SharedData", MODE_PRIVATE).edit();
        editor.putLong("evaluateChapterThree",getValue()+1);
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
                        "evaluateChapterThree", chaptervalue
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
        String itemsValueArray = prefs.getString("evaluateChapterThreeArray", "awais");
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

        String evaluateChapterThreeArray = "";
        for (int i=0;i<list.size();i++){
            evaluateChapterThreeArray = evaluateChapterThreeArray+list.get(i)+" ";
        }


        System.out.println("-------------evaluateChapterThreeArray----------------"+evaluateChapterThreeArray);

        editor = getSharedPreferences("SharedData", Context.MODE_PRIVATE).edit();
        editor.putString("evaluateChapterThreeArray",evaluateChapterThreeArray);
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
                                ArrayList a = (ArrayList) document.get("evaluateChapterThreeArray");

                                a.set(clickedCell,true);
                                System.out.println("----------------a- "+a );

                                // updating the value

                                db.collection("users").document(userID)
                                        .update(
                                                "evaluateChapterThreeArray", a
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
        String itemsValueArray = prefs.getString("evaluateChapterThreeArray", "awais");

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