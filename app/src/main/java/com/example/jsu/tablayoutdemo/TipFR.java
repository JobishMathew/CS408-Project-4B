package com.example.jsu.tablayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
/**
 * A simple {@link Fragment} subclass.
 */
public class TipFR extends Fragment implements View.OnClickListener {

    Button b;
    EditText tb;
    EditText tp;
    EditText np;
    TextView tpp;

    public TipFR() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.tipcalculator, container, false);

        b = (Button) v.findViewById(R.id.btnTIPCalculate); // Acquire button reference
        tb = (EditText)v.findViewById(R.id.txtTotalBill);
        tp = (EditText)v.findViewById(R.id.txtTipPercentage);
        np = (EditText)v.findViewById(R.id.txtNumberOfPeople);
        tpp= (TextView) v.findViewById(R.id.txtTotalPerPerson);

        b.setOnClickListener(this);                     // Set event handler

        return v;
    }


    public void onClick(View V) {

        if (!(tb.getText().toString().matches("") || tp.getText().toString().matches("") || np.getText().toString().matches(""))) {
            double totalAmount = Double.parseDouble(tb.getText().toString());
            double tipPercentage = Double.parseDouble(tp.getText().toString());
            int people = Integer.parseInt(np.getText().toString());
            double individualTax = (((tipPercentage / totalAmount) * 100) / people);
            double individualPay = (totalAmount / people) + individualTax;

            tpp.setText("Amount per person: $" + String.format("%.2f", individualPay));
        } else {
            tpp.setText("Please enter all fields");
        }
    }
}
