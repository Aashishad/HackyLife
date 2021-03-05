package com.example.hackylife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class homefrag extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        LayoutInflater inflater1 = getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_homefrag,container,false);

        Button genius = v.findViewById(R.id.Genius);
        genius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),genius.class);
                in.putExtra("some","some data");
                startActivity(in);
            }
        });
        Button drnik = v.findViewById(R.id.drink);
       drnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),foodanddrink.class);
                in.putExtra("some","some data");
                startActivity(in);
            }
        });

        Button techno = v.findViewById(R.id.Techno);
        techno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),techno.class);
                in.putExtra("some","some data");
                startActivity(in);
            }
        });
        Button tips = v.findViewById(R.id.tips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),tips.class);
                in.putExtra("some","some data");
                startActivity(in);
            }
        });
        Button pics = v.findViewById(R.id.pics);
        pics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),pics.class);
                startActivity(in);
            }
        });
        return v;


    }
}

