package com.example.administrator.xinyuan.contact.xianshangcontact;

import com.example.administrator.xinyuan.model.entity.XianShang_Bean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface XianShang_Contact {
    public interface Presenter{
        void loadData( Map<String,Object> params);
    }
    public interface View{
        void showData(XianShang_Bean xianShang_bean);
    }
}
