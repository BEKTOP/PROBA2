package com.example.kravchik.proba2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Victor.Kravchik on 28.09.2017.
 */

public class Coffee  extends AppCompatActivity {
        int quantity=1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.coffee);
        }



        public void submitOrder(View view) {

            int price = quantity * 5;
            CheckBox box1 = (CheckBox) findViewById(R.id.checkBox1);
            boolean ch1 = box1.isChecked();
            CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
            boolean ch2 = box2.isChecked();
            if (ch1) price = price + quantity;
            if (ch2) price = price + quantity * 2;
            Log.v("MainActivity", "The price is:" + price);
            EditText editText = (EditText) findViewById(R.id.editText);
            String name = editText.getText().toString();
            String message = name + "\nAdd whipped Cream? " + ch1 + "\nAdd Chocolate? " + ch2 + "\nTotal: $" + price + "\nThank You";
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"5809909@tut.by"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Order");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
            if (emailIntent.resolveActivity(getPackageManager())!=null){
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
            displayMessage(message);
        }

        public void decrement(View view){
            quantity--;
            if (quantity<1){
                quantity=1;
                Toast.makeText(getApplicationContext(), "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            }

            displayQuantity(quantity);
        }
        public void increment (View view){
            quantity++;
            if (quantity>10){
                quantity=10;
                Toast.makeText(getApplicationContext(), "You cannot have too many coffees", Toast.LENGTH_SHORT).show();
            }
            displayQuantity(quantity);
        }


        private void displayQuantity(int number) {
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + number);
        }

        private void displayMessage(String message) {
            TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
            orderSummaryTextView.setText(message);
        }

    }



