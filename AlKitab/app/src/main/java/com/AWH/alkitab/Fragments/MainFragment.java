package com.AWH.alkitab.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.AWH.alkitab.LearnFragment;
import com.AWH.alkitab.R;
import com.AWH.alkitab.adapter.SectionPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainFragment extends Fragment {
    View myFragment;

    TabLayout tabLayout;
    ViewPager viewPager;

    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment getInstance()    {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment =  inflater.inflate(R.layout.main_fragment,container,false);

        tabLayout = myFragment.findViewById(R.id.tabLayout);
        viewPager = myFragment.findViewById(R.id.viewPager);

        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getTabs();

        //setUpViewPager(viewPager);
        //tabLayout.setupWithViewPager(viewPager);

//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


    }
//    private void setUpViewPager(ViewPager viewPager){
//        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
//
//        adapter.addFragment(new evaluationFragment(),"Evaluation");
//        adapter.addFragment(new LearnFragment(),"Learning");
//
//        viewPager.setAdapter(adapter);
//
//    }
    public void getTabs(){
        final SectionPagerAdapter viewPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        new Handler().post(new Runnable() {
            @Override
            public void run() {

                viewPagerAdapter.addFragment(new LearnFragment(),"Learning");
                viewPagerAdapter.addFragment(new evaluationFragment(),"Evaluation");


                viewPager.setAdapter(viewPagerAdapter);

                tabLayout.setupWithViewPager(viewPager);

            }
        });


    }
}

//main_fragment