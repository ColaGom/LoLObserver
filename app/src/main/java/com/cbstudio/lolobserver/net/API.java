package com.cbstudio.lolobserver.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Colabear on 2016-04-07.
 */
public interface API {
    @GET("/api/lol/{region}/v1.4/summoner/by-name/{name}")
    Call<ResponseBody> getSummonerByName(@Path("region") String region, @Path("name") String name, @Query("api_key") String apiKey);
}
