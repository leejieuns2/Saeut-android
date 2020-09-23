package com.teamtips.android.saeut.func.map;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitInterface {
    String APPKEY = "a980cc15274214f283c3a720c92e85ad";

    @Headers("Authorization: KakaoAK 8525854d741143b261b0dd8d304630dc")
    @GET("v2/local/geo/coord2address.json")
    Call<JsonObject> getLocationInfo(@QueryMap Map<String, Double> params);

}
