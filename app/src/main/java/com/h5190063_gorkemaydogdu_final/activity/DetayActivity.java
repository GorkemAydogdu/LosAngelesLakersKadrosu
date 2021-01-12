package com.h5190063_gorkemaydogdu_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.h5190063_gorkemaydogdu_final.util.Constants;
import com.h5190063_gorkemaydogdu_final.util.GlideUtil;
import com.h5190063_gorkemaydogdu_final.lakersKadro.LakersKadro;
import com.h5190063_gorkemaydogdu_final.util.ObjectUtil;
import com.h5190063_gorkemaydogdu_final.R;

public class DetayActivity extends AppCompatActivity {
    ImageView imgKapak;
    TextView txtOyuncuAdi;
    TextView txtBoy;
    TextView txtKilo;
    TextView txtDraftTarihi;
    TextView txtAciklama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init();
    }
    public void init()
    {
        String tiklananOyuncuString = getIntent().getStringExtra(Constants.Tıklanan_Oyuncu);
        LakersKadro lakersKadro = ObjectUtil.jsonStringToKadro(tiklananOyuncuString);

        imgKapak = findViewById(R.id.imageView_Kapak);
        txtOyuncuAdi = findViewById(R.id.textView_OyuncuAdi);
        txtBoy = findViewById(R.id.textView_Boy);
        txtKilo = findViewById(R.id.textView_Kilo);
        txtDraftTarihi = findViewById(R.id.textView_DraftTarihi);
        txtAciklama = findViewById(R.id.textView_Aciklama);

        GlideUtil.resmiIndiripGoster(getApplicationContext(),lakersKadro.getKapakFotoUrl(),imgKapak);
        txtOyuncuAdi.setText(lakersKadro.getOyuncuAdi());
        txtBoy.setText(lakersKadro.getBoy());
        txtKilo.setText(lakersKadro.getKilo());
        txtDraftTarihi.setText(lakersKadro.getDraftTarihi());
        txtAciklama.setText(lakersKadro.getAciklama());
    }
}