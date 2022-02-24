package com.AWH.alkitab.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.AWH.alkitab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class evaluationFragment  extends Fragment {

    String [] EvaluationChapter = {"One", "Two", "Three"};
    int [] EvaluationChapterTotal = {30,20,3};


    SharedPreferences.Editor editor;

    ProgressBar pb1,pb2,pb3;

    TextView tx1,tx2,tx3;

    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    public static final String TAG = "TAG ";
    String userID;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.evaluation_fragment,container,false);


        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        tx1 = (TextView) v.findViewById(R.id.T1);
        tx2 = (TextView) v.findViewById(R.id.T2);
        tx3  = (TextView) v.findViewById(R.id.T3);


        progressDialog = new ProgressDialog(this.getActivity());


        pb1 = (ProgressBar) v.findViewById(R.id.pb1);
        pb2 = (ProgressBar) v.findViewById(R.id.pb2);
        pb3 = (ProgressBar) v.findViewById(R.id.pb3);

        tx1 = (TextView) v.findViewById(R.id.T1);
        tx2 = (TextView) v.findViewById(R.id.T2);
        tx3  = (TextView) v.findViewById(R.id.T3);





        SharedPreferences prefs = this.getActivity().getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        editor = this.getActivity().getSharedPreferences("SharedData", Context.MODE_PRIVATE).edit();

        long check = prefs.getLong("evaluateChapter"+EvaluationChapter[1], 1000);





        if( check != 1000){
            //already installed app
            System.out.println("----------------already installed--------------------");

            SharedPreferences pref = this.getActivity().getSharedPreferences("SharedData", Context.MODE_PRIVATE);

            pb1.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[0], 1000));
            pb2.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[1], 1000));
            pb3.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[2], 1000));



            tx1.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[0], 1000))+"/30");
            tx2.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[1], 1000))+"/20");
            tx3.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[2], 1000))+"/3");


        }
        else{
            //1st time install

            progressDialog.setMessage("Getting Data ...");
            progressDialog.show();

            SharedPreferences pref = this.getActivity().getSharedPreferences("SharedData", Context.MODE_PRIVATE);

            System.out.println("----------------1st time install------------------");

            db.collection("users") .whereEqualTo("id", userID)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    //------------------------------SharedPref--------------------------------------
                                    //Learning...
                                    for (int i = 0;i<3;i++){

                                        //learning data

                                        editor.putLong("evaluateChapter"+EvaluationChapter[i],(long) document.get("evaluateChapter"+EvaluationChapter[i]));
                                        editor.putLong("evaluateChapter"+EvaluationChapterTotal[i]+"Total", (long) (EvaluationChapterTotal[i]));



                                    }

                                    //creating list as a user default


                                    // for chapter 1
                                        ArrayList<Boolean> list = new ArrayList<Boolean>();
                                        String evaluateChapterOneArray = "";
                                        for (int i=0;i<30;i++){
                                            list.add(false);
                                        }
                                        for (int i=0;i<30;i++){
                                            evaluateChapterOneArray = evaluateChapterOneArray+list.get(i)+" ";
                                        }

                                    // for chapter 2
                                    ArrayList<Boolean> list1 = new ArrayList<Boolean>();
                                    String evaluateChapterTwoArray = "";
                                    for (int i=0;i<20;i++){
                                        list1.add(false);
                                    }
                                    for (int i=0;i<20;i++){
                                        evaluateChapterTwoArray = evaluateChapterTwoArray+list1.get(i)+" ";
                                    }

                                    // for chapter 3
                                    ArrayList<Boolean> list3 = new ArrayList<Boolean>();
                                    String evaluateChapterThreeArray = "";
                                    for (int i=0;i<3;i++){
                                        list3.add(false);
                                    }
                                    for (int i=0;i<3;i++){
                                        evaluateChapterThreeArray = evaluateChapterThreeArray+list3.get(i)+" ";
                                    }




                                    editor.putString("evaluateChapterOneArray",evaluateChapterOneArray);
                                    editor.putString("evaluateChapterTwoArray",evaluateChapterTwoArray);
                                    editor.putString("evaluateChapterThreeArray",evaluateChapterThreeArray);


                                    editor.apply();
//                                    //Evaluation...
//
//
                                    progressDialog.dismiss();

                                    pb1.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[0], 1000));
                                    pb2.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[1], 1000));
                                    pb3.setProgress((int) pref.getLong("evaluateChapter"+EvaluationChapter[2], 1000));


                                    tx1.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[0], 1000))+"/30");
                                    tx2.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[1], 1000))+"/20");
                                    tx3.setText(String.valueOf(pref.getLong("evaluateChapter"+EvaluationChapter[2], 1000))+"/3");




                                }



                            }
                            else {

                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });


        }



        return v;
    }


}
