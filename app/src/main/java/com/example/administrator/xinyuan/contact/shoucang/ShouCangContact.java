package com.example.administrator.xinyuan.contact.shoucang;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface ShouCangContact {
    public interface Presenter{
        void loadShouCang(Map<String,Object> params);
        void loadQuShouCang(Map<String,Object> params);
    }
    public interface View{
        void shouCang(ResponseBody responseBody);
        void quShouCang(ResponseBody responseBody);
    }
}
