package com.h5190063_gorkemaydogdu_final.lakersKadro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LakersKadro {
    @SerializedName("OyuncuAdi")
    @Expose
    private String oyuncuAdi;
    @SerializedName("Pozisyon")
    @Expose
    private String pozisyon;
    @SerializedName("Boy")
    @Expose
    private String boy;
    @SerializedName("Kilo")
    @Expose
    private String kilo;
    @SerializedName("Yasi")
    @Expose
    private Integer yasi;
    @SerializedName("Draft Tarihi")
    @Expose
    private String draftTarihi;
    @SerializedName("FotoUrl")
    @Expose
    private String fotoUrl;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public Integer getYasi() {
        return yasi;
    }

    public void setYasi(Integer yasi) {
        this.yasi = yasi;
    }

    public String getDraftTarihi() {
        return draftTarihi;
    }

    public void setDraftTarihi(String draftTarihi) {
        this.draftTarihi = draftTarihi;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
