package com.example.administrator.xinyuan.contact.teathercontact.zhaoteathercontact;

import com.example.administrator.xinyuan.model.entity.ZhaoTeatherBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface IZhaoTeather_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(ZhaoTeatherBean zhaoTeatherBean);
    }
}
