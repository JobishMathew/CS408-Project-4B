package com.example.jsu.tablayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;

import android.widget.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class MilesKiloFR extends Fragment implements View.OnClickListener {

    Button b;
    EditText tm;
    EditText tk;

    public MilesKiloFR() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.milestokilometer, container, false);

        b = (Button) v.findViewById(R.id.btnCalculateDistance); // Acquire button reference
        tm = (EditText) v.findViewById(R.id.txtMiles);
        tk = (EditText) v.findViewById(R.id.txtKiloMeter);

        b.setOnClickListener(this);                     // Set event handler
        return v;

    }



    public void onClick(View v) {
        String m = tm.getText().toString();
        String k = tk.getText().toString();

        if (m.isEmpty()) {
            if (!k.isEmpty()) {
                double kilometers = Double.parseDouble(k);
                double miles = (0.621371 * kilometers);
                tm.setText(String.format("%.2f", miles) + " Miles");
            }
        } else {
            double miles = Double.parseDouble(m);
            double kilometer = (1.60934 * miles);
            tk.setText(String.format("%.2f", kilometer) + " km");
        }
    }
}
