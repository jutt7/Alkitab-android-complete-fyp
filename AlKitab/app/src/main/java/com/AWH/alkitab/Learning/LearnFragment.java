package com.AWH.alkitab.Learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.AWH.alkitab.Learning.Quiz.Quiz_select;
import com.AWH.alkitab.R;
import com.AWH.alkitab.Learning.Kalima.kalima_selection;
import com.AWH.alkitab.Learning.Prayer.prayer_select;
import com.AWH.alkitab.Tafseer.TafseerSelect;

public class LearnFragment extends Fragment {
    private CardView c1,c2,c3,c4,c5;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_learn, container, false);

        c1 = v.findViewById(R.id.c1);
        c2 = v.findViewById(R.id.c2);
        c3 = v.findViewById(R.id.c3);
        c4 = v.findViewById(R.id.c4);
        c5 = v.findViewById(R.id.c5);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Learn_select.class);
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(), prayer_select.class);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), kalima_selection.class);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz_select.class);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TafseerSelect.class);
                startActivity(intent);
            }
        });
        return v;
    }





}
