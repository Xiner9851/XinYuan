package com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherfensicontact;

import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface ZhaoTeather_FenSi_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(ZhaoTeather_FenSi_Bean zhaoTeather_fenSi_bean);
    }
}
