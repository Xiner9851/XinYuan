package com.example.administrator.xinyuan;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2018/5/3.
 */

public class App extends Application {
    public static AppCompatActivity context;
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106715541", "qOPr22h1Wpi80wVQ");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }

}
