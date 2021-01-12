package com.h5190063_gorkemaydogdu_final.network;

import com.h5190063_gorkemaydogdu_final.lakersKadro.LakersKadro;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("LosAngelesLakersKadrosu.json")
    Observable<List<LakersKadro>> kadroyuGetir();
}
