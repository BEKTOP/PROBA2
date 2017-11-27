package com.example.kravchik.proba2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kravchik on 22.03.2017.
 */

public class Vorony_Count extends Activity {

    private Button mCrowsCounterButton;
    private TextView mInfoTextView;
    private  int mCount=0;
    private  int kCount=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vorony_count);

        mCrowsCounterButton = (Button) findViewById(R.id.buttonCrowsCounter);
        mInfoTextView=(TextView)findViewById(R.id.textView2);
        mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText("Я насчитал " + ++mCount + " ворон");

            }
        });
        mCrowsCounterButton = (Button) findViewById(R.id.buttonCatsCounter);
        mInfoTextView=(TextView)findViewById(R.id.textView2);
        mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText("Я насчитал " + ++kCount + " котов");

            }
        });
        TextView text = (TextView) findViewById(R.id.dig_LAC);
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        GsmCellLocation gsmCell = (GsmCellLocation) manager.getCellLocation();
        if (gsmCell != null) {
            text.setText("\n\tCID:\t" + gsmCell.getCid());
            text.append("\n\tLAC:\t" + gsmCell.getLac());
            text.append("\n\tNetworkOperator:\t" + manager.getNetworkOperator());
            text.append("\n\tgetNeighboringCellInfo:\t" + manager.getNeighboringCellInfo().size());


            List<NeighboringCellInfo> NeighboringList = manager.getNeighboringCellInfo();

            String stringNeighboring = "Neighboring List- Lac : Cid : RSSI\n";
            for(int i=0; i < NeighboringList.size(); i++){

                String dBm;
                int rssi = NeighboringList.get(i).getRssi();
                if(rssi == NeighboringCellInfo.UNKNOWN_RSSI){
                    dBm = "Unknown RSSI";
                }else{
                    dBm = String.valueOf(-113 + 2 * rssi) + " dBm";
                }

                stringNeighboring = stringNeighboring
                        + String.valueOf(NeighboringList.get(i).getLac()) +" : "
                        + String.valueOf(NeighboringList.get(i).getCid()) +" : "
                        + String.valueOf(NeighboringList.get(i).getPsc()) +" : "
                        + String.valueOf(NeighboringList.get(i).getNetworkType()) +" : "
                        + dBm +"\n";
            }

            text.append(stringNeighboring);
        }


    }

    public void onClick(View view){
        TextView helloTextView = (TextView) findViewById(R.id.textView2);
        helloTextView.setText("Hello Kitty");
    }




}
