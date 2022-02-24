package com.AWH.alkitab.Evaluation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.AWH.alkitab.R;

public class EvaluateFragment extends Fragment {
    private CardView c1,c2,c3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_evaluate,container,false);

        c1 = v.findViewById(R.id.c1);
        c2 = v.findViewById(R.id.c2);
        c3 = v.findViewById(R.id.c3);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),eva_Chapter1.class));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),eva_words.class));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),eva_Ayats.class));
            }
        });




        return v;
    }

}
