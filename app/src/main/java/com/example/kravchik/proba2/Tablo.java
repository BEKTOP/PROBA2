package com.example.kravchik.proba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Victor.Kravchik on 27.09.2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class Tablo extends AppCompatActivity {
        int scoreTeamA=0;
        int scoreTeamB=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tablo);
        }

        public void a2(View view){
            scoreTeamA=scoreTeamA+2;
            displayForTeamA(scoreTeamA);
        }
        public void a1(View view){
            scoreTeamA=scoreTeamA+1;
            displayForTeamA(scoreTeamA);
        }
        public void a3(View view){
            scoreTeamA=scoreTeamA+3;
            displayForTeamA(scoreTeamA);
        }
        public void b2(View view){
            scoreTeamB=scoreTeamB+2;
            displayForTeamB(scoreTeamB);
        }
        public void b1(View view){
            scoreTeamB=scoreTeamB+1;
            displayForTeamB(scoreTeamB);
        }
        public void b3(View view){
            scoreTeamB=scoreTeamB+3;
            displayForTeamB(scoreTeamB);
        }
        public void res(View view){
            scoreTeamB=0;
            scoreTeamA=0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
        }


        // Displays the given score for Team A.

        public void displayForTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));}

        public void displayForTeamB(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score));
        }


    }
