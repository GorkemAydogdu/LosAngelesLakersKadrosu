package com.h5190063_gorkemaydogdu_final.util;

import com.google.gson.Gson;
import com.h5190063_gorkemaydogdu_final.lakersKadro.LakersKadro;

public class ObjectUtil {

    public  static String kadroToJsonString(LakersKadro kadro)
    {
        Gson gson = new Gson();
        return   gson.toJson(kadro);
    }

    public  static LakersKadro jsonStringToKadro(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,LakersKadro.class);
    }
}
