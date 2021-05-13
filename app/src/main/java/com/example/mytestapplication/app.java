package com.example.mytestapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;

public class app extends Application {
    private int count;
    SharedPreferences pref;
    private final String key = "CountKey";

    @Override
    public void onCreate() {
        super.onCreate();
        pref = getSharedPreferences("Counter", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (pref.contains(key)){
            count = pref.getInt(key, 1);
        }
        count++;
        edit.putInt(key, count);
        edit.apply();
        if (count == 3){
            Toast.makeText(this, "some text", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "" + count, Toast.LENGTH_LONG).show();
    }
}
