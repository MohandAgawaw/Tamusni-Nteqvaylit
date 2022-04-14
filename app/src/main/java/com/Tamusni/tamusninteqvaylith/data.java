package com.Tamusni.tamusninteqvaylith;

import android.app.Application;

import com.parse.Parse;

public class data extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext()).applicationId(getString(R.string.appid_back4)).clientKey(getString(R.string.key_back4))
        .server(getString(R.string.server_back4)).build());
    }
}
