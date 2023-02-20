package com.example.wifiscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.MacAddress;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiManager mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results = mWifiManager.getScanResults();
        if (results.size() == 0){
            Log.d("HUST", "NULL");
        }
        else{
            for (ScanResult result : results) {
                Log.d("HUST", result.toString());
            }
        }
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        if (wifiInfo != null){
            String str = wifiInfo.getBSSID();
            Log.d("HUST Connect", str);
        }
        Log.d("HUST", "------------");
    }
}