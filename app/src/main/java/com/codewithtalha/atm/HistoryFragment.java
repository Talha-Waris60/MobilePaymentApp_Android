package com.codewithtalha.atm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Model> arrModel = new ArrayList<>();


    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recyclerContact);

        // Set layout manager to show the view pattern in linear pattern
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrModel.add(new Model(R.drawable.pro1,"Liam","3:20 PM ar 23 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro2,"William","4:10 PM Mar 24 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro3,"Benjamin","5:30 PM Mar 2 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro4,"James liu","1:10 PM Mar 25 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro5,"Wylder","2:50 PM Mar 25 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro6,"Gian","3:34 PM Mar 22 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro7,"Kylian","6:45 PM Mar 23 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro1,"zyair","8:56 PM Mar 2 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro2,"koen","1:40 PM Mar 28 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro3,"Benjamin","2:45 PM Mar 1 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro4,"James liu","4:19 PM Mar 5 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro5,"Wylder","5:12 PM Mar 27 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro6,"Gian","9:23 PM Mar 26 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro7,"Kylian","5:45 PM Mar 19 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro6,"Gian","4:16 PM Mar 15 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro7,"Kylian","6:17 PM Mar 22 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro1,"zyair","9:18 PM Mar 13 ,2022","$149"));
        arrModel.add(new Model(R.drawable.pro2,"koen","1:19 PM Mar 24 ,2022","$149"));

        recyclerView.setAdapter(new RecyclerContactAdapter(this,arrModel));


        // Step Make the view of layout how the data is show
        return view;
    }

}

