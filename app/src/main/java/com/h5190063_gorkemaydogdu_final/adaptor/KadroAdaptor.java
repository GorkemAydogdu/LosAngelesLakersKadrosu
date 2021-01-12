package com.h5190063_gorkemaydogdu_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190063_gorkemaydogdu_final.util.GlideUtil;
import com.h5190063_gorkemaydogdu_final.lakersKadro.LakersKadro;
import com.h5190063_gorkemaydogdu_final.R;

import java.util.List;

public class KadroAdaptor extends RecyclerView.Adapter<KadroViewHolder> {


    List<LakersKadro> lakersKadro;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener{
        void onClick(int position);

    }
    public KadroAdaptor(List<LakersKadro> kadro, Context context,OnItemClickListener listener) {
        this.lakersKadro = kadro;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KadroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_kadro,parent,false);
        return new KadroViewHolder(cardView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KadroViewHolder viewHolder, int position) {

        viewHolder.txtOyuncuAdi.setText(lakersKadro.get(position).getOyuncuAdi());
        viewHolder.txtOyuncuPozisyon.setText(lakersKadro.get(position).getPozisyon());
        viewHolder.txtOyuncuYasi.setText(lakersKadro.get(position).getYasi().toString());
        GlideUtil.resmiIndiripGoster(context,lakersKadro.get(position).getFotoUrl(),viewHolder.imgOyuncu);
    }

    @Override
    public int getItemCount() {
        return lakersKadro.size();
    }
}
