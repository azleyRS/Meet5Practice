package com.fortests.meet5practice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG","service created");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("TAG","Got intent");
        for (int i = 0 ; i<10; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent broadcastIntent = new Intent(MainActivity.BROADCAST);
            broadcastIntent.putExtra("random",String.valueOf(i));
            sendBroadcast(broadcastIntent);
            if (i == 9){
                i = 0;
            }
        }
    }
}
