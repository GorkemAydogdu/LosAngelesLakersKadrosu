package com.h5190063_gorkemaydogdu_final.activity;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.h5190063_gorkemaydogdu_final.R;


public class SplashEkraniActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    Intent ListeEkrani;
    WifiManager wifiManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ekrani);
        init(getApplicationContext());
    }
    public void init(Context context){
        countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e(context.getResources().getString(R.string.counter),context.getResources().getString(R.string.finish));
            }
            //KOD DÜZELTİLECEK İNTERNET KONTROL VE ALERT DİALOG AYRI METOTLARDA
            @Override
            public void onFinish() {
                internetKontrol();
            }
        }.start();
    }
    public void ikinciEkraniGetir(Context context){
        Log.e(context.getResources().getString(R.string.counter),context.getResources().getString(R.string.finish));
        ListeEkrani = new Intent(SplashEkraniActivity.this, ListeEkraniActivity.class);
        startActivity(ListeEkrani);
    }
    public void internetKontrol(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            ikinciEkraniGetir(getApplicationContext());
        }
        else
        {
            alertDialog(getApplicationContext());
        }
    }
    public void alertDialog(Context context)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashEkraniActivity.this);
        builder.setMessage(context.getResources().getString(R.string.hata_mesaj));
        builder.setTitle(context.getResources().getString(R.string.uyarı));
        builder.setPositiveButton(context.getResources().getString(R.string.interneti_ac), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
                wifiManager.reconnect();
                internetKontrol();
            }
        });
        builder.setNegativeButton(context.getResources().getString(R.string.uygulama_kapat), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}