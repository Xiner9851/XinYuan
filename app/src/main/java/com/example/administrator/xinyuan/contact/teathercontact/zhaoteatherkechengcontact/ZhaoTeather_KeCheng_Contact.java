package com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherkechengcontact;

import com.example.administrator.xinyuan.model.entity.ZhaoTeather_KeCheng;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface ZhaoTeather_KeCheng_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(ZhaoTeather_KeCheng zhaoTeatherKeCheng);
    }
}
