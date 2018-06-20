package com.fortests.meet5practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment2.OnButtonPressedListener{

    public static final String BROADCAST = "com.fortests.meet5practice";

    BroadcastReceiver mBroadcastReceiver;
    IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
                EditText editTextFrag1 = frag1.getView().findViewById(R.id.fragment_1_edit_text);
                String res = intent.getStringExtra("random");
                editTextFrag1.setText(res);
            }
        };

        mIntentFilter = new IntentFilter(BROADCAST);
        registerReceiver(mBroadcastReceiver,mIntentFilter);
    }

    public void pressButton(){
        Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        EditText editTextFrag1 = frag1.getView().findViewById(R.id.fragment_1_edit_text);
        String resultText = String.valueOf(editTextFrag1.getText());


        Fragment frag2 = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        Fragment frag3 = frag2.getChildFragmentManager().findFragmentById(R.id.fragment_3_container);
        TextView textView = (TextView)frag3.getView().findViewById(R.id.fragment_3_text_view);
        textView.setText(resultText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public void onButtonPressed() {
        // just copied to test
        Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        EditText editTextFrag1 = frag1.getView().findViewById(R.id.fragment_1_edit_text);
        String resultText = String.valueOf(editTextFrag1.getText());


        Fragment frag2 = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        Fragment frag3 = frag2.getChildFragmentManager().findFragmentById(R.id.fragment_3_container);
        TextView textView = (TextView)frag3.getView().findViewById(R.id.fragment_3_text_view);
        textView.setText(resultText);
    }
}
