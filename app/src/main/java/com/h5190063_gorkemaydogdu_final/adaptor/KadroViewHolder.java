package com.h5190063_gorkemaydogdu_final.adaptor;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190063_gorkemaydogdu_final.R;
import com.h5190063_gorkemaydogdu_final.adaptor.KadroAdaptor;


public class KadroViewHolder extends RecyclerView.ViewHolder {

    ImageView imgOyuncu;
    TextView txtOyuncuAdi;
    TextView txtOyuncuPozisyon;
    TextView txtOyuncuYasi;

    public KadroViewHolder(@NonNull View cardView, KadroAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgOyuncu =cardView.findViewById(R.id.imageView_OyuncuLogo);
        txtOyuncuAdi =cardView.findViewById(R.id.txt_OyuncuAdi);
        txtOyuncuPozisyon =cardView.findViewById(R.id.txt_Pozisyon);
        txtOyuncuYasi =cardView.findViewById(R.id.txt_Yas);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });
    }
}
