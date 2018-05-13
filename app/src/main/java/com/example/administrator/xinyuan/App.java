package com.example.administrator.xinyuan;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2018/5/3.
 */

public class App extends Application {

    public static AppCompatActivity context;
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
        PlatformConfig.setQQZone("1106715541", "qOPr22h1Wpi80wVQ");
    }
}
