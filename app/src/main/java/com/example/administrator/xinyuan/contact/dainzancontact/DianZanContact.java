package com.example.administrator.xinyuan.contact.dainzancontact;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface DianZanContact {
    public interface Presenter{
        void loadDianZan(Map<String,Object> params);
        void loadQuDianZan(Map<String,Object> params);
    }
    public interface View{
        void dianZan(ResponseBody responseBody);
        void quDianZan(ResponseBody responseBody);
    }
}
