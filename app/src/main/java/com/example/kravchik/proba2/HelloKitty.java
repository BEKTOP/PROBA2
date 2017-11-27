package com.example.kravchik.proba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kravchik.proba2.beer.BeerExpert;

import java.util.List;

/**
 * Created by kravchik on 22.03.2017.
 */

public class HelloKitty extends AppCompatActivity {
    private TextView mHelloTextView, text;
    private EditText mText;
    private BeerExpert expert = new BeerExpert();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_kitty);


        mHelloTextView = (TextView) findViewById(R.id.textView);
        mText = (EditText) findViewById(R.id.editText);




    }

    public void onClick(View view) {
        if (mText.getText().length() == 0) {
            mHelloTextView.setText("Hello Kitty");
        } else
            mHelloTextView.setText("Hello " + mText.getText());

    }


    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
//Display the beers
        brands.setText(brandsFormatted);
    }
}
