package com.example.kravchik.proba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.kravchik.proba2.starbuzz.TopLevelActivity;


public class MainActivity extends Activity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);


            Button btn1 = (Button) findViewById(R.id.btn1);
            Button btn2 = (Button) findViewById(R.id.btn2);
            Button btn3 = (Button) findViewById(R.id.btn3);
            Button btn4 = (Button) findViewById(R.id.btn4);
            Button btn5 = (Button) findViewById(R.id.btn5);
            Button btn6 = (Button) findViewById(R.id.btn6);
            Button btn7 = (Button) findViewById(R.id.btn7);
            Button btn8 = (Button) findViewById(R.id.btn8);
            Button btn9 = (Button) findViewById(R.id.btn9);
            Button btn10 = (Button) findViewById(R.id.btn10);



            OnClickListener btnClk1 = new OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch(v.getId()) {
                        case R.id.btn1:
                            Intent intent=new Intent(MainActivity.this,HelloKitty.class);
                            startActivity(intent);
                            break;
                        case R.id.btn2:
                            Intent intent2=new Intent(MainActivity.this,Vorony_Count.class);
                            startActivity(intent2);
                            break;
                        case R.id.btn3:
                            Intent intent3=new Intent(MainActivity.this,Calculator.class);
                            startActivity(intent3);
                            break;
                        case R.id.btn4:
                            Intent intent4=new Intent(MainActivity.this,TodoList.class);
                            startActivity(intent4);
                            break;
                        case R.id.btn5:
                            Intent intent5=new Intent(MainActivity.this,CreateMessageActivity.class);
                            startActivity(intent5);
                            break;
                        case R.id.btn6:
                            Intent intent6=new Intent(MainActivity.this,Stopwatch.class);
                            startActivity(intent6);
                            break;
                        case R.id.btn7:
                            Intent intent7=new Intent(MainActivity.this,TopLevelActivity.class);
                            startActivity(intent7);
                            break;
                        case R.id.btn8:
                            Intent intent8=new Intent(MainActivity.this,TipCalculator.class);
                            startActivity(intent8);
                            break;
                        case R.id.btn9:
                            Intent intent9=new Intent(MainActivity.this,Tablo.class);
                            startActivity(intent9);
                            break;
                        case R.id.btn10:
                            Intent intent10=new Intent(MainActivity.this,Coffee.class);
                            startActivity(intent10);
                            break;
                        default:
                    }

                }
            };


            btn1.setOnClickListener(btnClk1);
            btn2.setOnClickListener(btnClk1);
            btn3.setOnClickListener(btnClk1);
            btn4.setOnClickListener(btnClk1);
            btn5.setOnClickListener(btnClk1);
            btn6.setOnClickListener(btnClk1);
            btn7.setOnClickListener(btnClk1);
            btn8.setOnClickListener(btnClk1);
            btn9.setOnClickListener(btnClk1);
            btn10.setOnClickListener(btnClk1);
        }



//    public void onClick1 (View view){
//        Intent intent=new Intent(MainActivity.this,HelloKitty.class);
//        startActivity(intent);
//        //          overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
//    }
//    public void onClick2 (View view){
//        Intent intent=new Intent(MainActivity.this,Vorony_Count.class);
//        startActivity(intent);
//        //           overridePendingTransition(R.anim.pull_in_left,R.anim.push_out_right);
//    }
//    public void onClick3 (View view){
//        Intent intent=new Intent(MainActivity.this,Calculator.class);
//        startActivity(intent);
//        //           overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
//    }
//    public void onClick4 (View view){
//        Intent intent=new Intent(MainActivity.this,TodoList.class);
//        startActivity(intent);
//    }
//    public void onClick5 (View view){
//        Intent intent=new Intent(MainActivity.this,CreateMessageActivity.class);
//        startActivity(intent);
//    }
//        public void onClick6 (View view){
//            Intent intent=new Intent(MainActivity.this,Stopwatch.class);
//            startActivity(intent);
//        }
//
//        public void onClick7 (View view){
//            Intent intent=new Intent(MainActivity.this,TopLevelActivity.class);
//            startActivity(intent);
//        }
  }
