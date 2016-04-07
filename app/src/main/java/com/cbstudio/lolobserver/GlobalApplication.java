package com.cbstudio.lolobserver;

import android.app.Application;

import com.cbstudio.lolobserver.model.UserPref;
import com.cbstudio.lolobserver.net.LOLClient;
import com.orhanobut.logger.Logger;

/**
 * Created by Colabear on 2016-04-07.
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        UserPref.init(this);
        LOLClient.init(this);
        Logger.init(Const.TAG);
    }
}
