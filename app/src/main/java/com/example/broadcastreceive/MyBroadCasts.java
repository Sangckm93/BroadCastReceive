package com.example.broadcastreceive;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class MyBroadCasts extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            if(Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON, 0)!= 0){
                EventBus.getDefault().post(new MessageEvent(true));
            }else{
                EventBus.getDefault().post(new MessageEvent(false));
            }
        }
    }
}
