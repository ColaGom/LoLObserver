package com.cbstudio.lolobserver.net;

import android.content.Context;

import com.cbstudio.lolobserver.Const;
import com.cbstudio.lolobserver.R;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Colabear on 2016-04-07.
 */
public class LOLClient  {

    private  static String URL_SERVER;
    private static  String REGION;

    private static API api;

    public static  void init(Context context){
        URL_SERVER = context.getString(R.string.url_server);
        REGION = context.getString(R.string.region);
    }

    protected synchronized static API getApi()
    {
        if(api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_SERVER)
                    .build();

            api = retrofit.create(API.class);
        }

        return api;
    }

    public static void getSummonerByName(String userName, Callback<ResponseBody> callback) {
        getApi().getSummonerByName(REGION, userName, Const.KEY_API).enqueue(callback);
    }
}
