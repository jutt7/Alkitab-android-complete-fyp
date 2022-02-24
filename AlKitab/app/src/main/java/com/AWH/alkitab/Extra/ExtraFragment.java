package com.AWH.alkitab.Extra;

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
import com.AWH.alkitab.Extra.Tajweed.TajweedRules;

public class ExtraFragment extends Fragment {
    CardView c1, c2, c3,c4;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_extra, container, false);

        c1 = v.findViewById(R.id.c1);
        c2 = v.findViewById(R.id.c2);
        c3 = v.findViewById(R.id.c3);
        c4 = v.findViewById(R.id.c4);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TajweedRules.class);
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Qibla.class);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), hijriCalender.class);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PrayerTime.class);
                startActivity(intent);
            }
        });
        return v;
    }
}

