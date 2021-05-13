package com.example.mytestapplication;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Task2",Arrays.toString(
                decryptData(new int[]{5, 100, 20, 66, 16}, 50, 1, 3)));
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
}