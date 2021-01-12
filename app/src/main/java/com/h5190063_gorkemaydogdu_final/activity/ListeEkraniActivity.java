package com.h5190063_gorkemaydogdu_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;


import com.h5190063_gorkemaydogdu_final.util.Constants;
import com.h5190063_gorkemaydogdu_final.adaptor.KadroAdaptor;
import com.h5190063_gorkemaydogdu_final.lakersKadro.LakersKadro;
import com.h5190063_gorkemaydogdu_final.util.ObjectUtil;
import com.h5190063_gorkemaydogdu_final.R;
import com.h5190063_gorkemaydogdu_final.network.Service;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeEkraniActivity extends AppCompatActivity {
    Intent detayEkrani;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_ekrani);
        init();
    }

    private  void  init()
    {
        kadroyuGetir(getApplicationContext());
    }
    void  kadroyuGetir(Context context)
    {
        new Service().getServiceApi().kadroyuGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LakersKadro>>() {

                    List<LakersKadro> oyuncular=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(context.getResources().getString(R.string.retrofit),context.getResources().getString(R.string.onSubscribe));
                    }

                    @Override
                    public void onNext(List<LakersKadro> oyuncularList) {
                        Log.e(context.getResources().getString(R.string.retrofit),context.getResources().getString(R.string.onNext));
                        oyuncular=oyuncularList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e(context.getResources().getString(R.string.retrofit),context.getResources().getString(R.string.onError) + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e(context.getResources().getString(R.string.retrofit),context.getResources().getString(R.string.onComplete));

                        if(oyuncular.size()>0) {
                            initRecycleView(oyuncular,getApplicationContext());
                        }
                    }
                });
    }
    private  void  initRecycleView(List<LakersKadro> kadroList, Context context)
    {
        recyclerView =findViewById(R.id.rcv_kadro);
        KadroAdaptor kadroAdaptor =new KadroAdaptor(kadroList, getApplicationContext(), new KadroAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                LakersKadro tiklananOyuncu = kadroList.get(position);
                Toast.makeText( getApplicationContext(), context.getResources().getString(R.string.tiklanan_adi)+ tiklananOyuncu.getOyuncuAdi(), Toast.LENGTH_SHORT).show();
                progressDialog(getApplicationContext());
                detayEkraniGetir(tiklananOyuncu);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(kadroAdaptor);
    }
    public void progressDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(ListeEkraniActivity.this);
        progressDialog.setMessage(context.getResources().getString(R.string.bekleyiniz));
        progressDialog.show();
    }
    //@Override
    public boolean onKeyDown(int keyCode, KeyEvent event,Context context) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder builder =  new AlertDialog.Builder(ListeEkraniActivity.this);
            builder.setMessage(context.getResources().getString(R.string.uygulamadanCikma));
            builder.setPositiveButton(context.getResources().getString(R.string.evet), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            builder.setNegativeButton(context.getResources().getString(R.string.Hayir), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void detayEkraniGetir(LakersKadro tiklananOyuncu){
        detayEkrani = new Intent(ListeEkraniActivity.this, DetayActivity.class);
        String tiklananOyuncuString = ObjectUtil.kadroToJsonString(tiklananOyuncu);
        detayEkrani.putExtra(Constants.Tıklanan_Oyuncu,tiklananOyuncuString);
        startActivity(detayEkrani);
    }
}