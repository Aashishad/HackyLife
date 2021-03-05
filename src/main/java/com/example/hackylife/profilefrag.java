package com.example.hackylife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profilefrag extends Fragment {
    private TextView display;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_profilefrag,container, false);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        display = (TextView)v.findViewById(R.id.display);
        display.setText(user.getEmail());


        Button logout = v.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Toast.makeText(getActivity(),"logout sucessfull",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getActivity(),MainActivity.class);
                startActivity(in);
            }

        });
        return v;

    }
}
