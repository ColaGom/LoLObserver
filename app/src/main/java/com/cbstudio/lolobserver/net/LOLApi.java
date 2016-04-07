package com.cbstudio.lolobserver.net;

import android.content.Context;

import com.cbstudio.lolobserver.Const;
import com.cbstudio.lolobserver.R;

/**
 * Created by Colabear on 2016-04-07.
 */
public class LOLApi {

    private static String  URL_SERVER;
    private static  String REGION;

    public static void init(Context context)
    {
        URL_SERVER = context.getString(R.string.url_server);
        REGION = context.getString(R.string.region);


    }



    //"https://kr.api.pvp.net/api/lol/kr/v1.4/summoner/by-name/빠른동작?api_key=fb7503db-746c-4db7-bd4d-2b22a67ff1c5";
    private static class QueryBuilder
    {
        public static String buildSummoner(String userName)
        {
            return String.format("%s/api/lol/%s/v1.4/summoner/by-name/%s?api_key=%s",URL_SERVER, REGION, Const.KEY_API, userName);
            //https://kr.api.pvp.net/api/lol/kr/v1.4/summoner/by-name/빠른동작?api_key=fb7503db-746c-4db7-bd4d-2b22a67ff1c5
        }
    }
}
