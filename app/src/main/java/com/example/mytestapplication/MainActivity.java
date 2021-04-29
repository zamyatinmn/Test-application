package com.example.mytestapplication;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    int count = 0;
    Cursor query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Task2",Arrays.toString(
                decryptData(new int[]{5, 100, 20, 66, 16}, 50, 1, 3)));

        db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS app (id INTEGER PRIMARY KEY AUTOINCREMENT, counter INTEGER DEFAULT (1));");
        query = db.rawQuery("SELECT counter FROM app",null);
        if (query.getCount() == 0){
            count = 1;
            db.execSQL("INSERT into app (id, counter) values (1, " + count + ");");
        } else{
            query.moveToFirst();
            count = query.getInt(0);
            count++;
        }

        if (count == 3){
            Toast.makeText(this, "Some text..", Toast.LENGTH_LONG).show();
        }
        db.execSQL("UPDATE app SET counter = " + count + ";");
    }

    /**
     *
     * @param price - input array
     * @param discount - discount percentage
     * @param offset - from which position to apply the discount
     * @param readLength - how many items to apply the discount
     * @return - an array with the values ​​to which the discount is applied
     */
    public static  @Nullable
    int[] decryptData(@NonNull int[] price,
                      @IntRange(from = 1) int discount,
                      @IntRange(from = 0) int offset,
                      @IntRange(from = 1) int readLength) {
        int[] arr = new int[readLength];
        for (int i = offset; i < readLength+offset; i++) {
            arr[i-offset] = (int) (price[i]-price[i]*((float)discount/100));
        }
        return arr;
    }

    @Override
    protected void onDestroy() {
        query.close();
        db.close();
        super.onDestroy();
    }
}