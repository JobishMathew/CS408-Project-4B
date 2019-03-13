package com.example.jsu.tablayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FarenheitToCelcius extends Fragment implements View.OnClickListener{

    Button b;
    EditText faren;
    EditText ceclius;

    public FarenheitToCelcius() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.FarenheitToCelcius, container, false);

         b = (Button)v.findViewById(R.id.btnCalculate); // Acquire button reference
         faren = (EditText)v.findViewById(R.id.txtFarenheit);
         ceclius = (EditText)v.findViewById(R.id.txtCelcius);

        b.setOnClickListener(this);                     // Set event handler
        return v;

    }

    public void onlclick(View v){
        String f = faren.getText().toString();
        String c =ceclius.getText().toString();

        if (f.isEmpty()){
            if(!c.isEmpty()) {
                double celcius = Double.parseDouble(c);
                double farenh = ((celcius * 9 / 5) + 32);
                faren.setText(String.format("%.2f",faren) + " \u2109");
            }
        }
        else{
            double farenh = Double.parseDouble(f);
            double celcius = ((farenh - 32) * 5 /9);
            ceclius.setText(String.format("%.2f",celcius)+ " \u2103");
        }
    }


}
