package com.example.administrator.xinyuan.contact.zhaoteatherguanzhucontact;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface ZhaoTeatherGuanZhuContact {
    public interface Presenter{
        void loadGuanZhu(Map<String,Object> params);
        void loadQuGuan(Map<String,Object> params);
    }
    public interface View{
        void guanzhu(ResponseBody responseBody);
        void quguan(ResponseBody responseBody);
    }
}
