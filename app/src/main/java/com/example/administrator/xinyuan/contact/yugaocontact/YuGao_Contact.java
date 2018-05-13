package com.example.administrator.xinyuan.contact.yugaocontact;

import com.example.administrator.xinyuan.model.entity.YuDaoBean;

import java.util.Map;

import retrofit2.http.FieldMap;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface YuGao_Contact {
    public interface Presenter{
        void loadData(@FieldMap Map<String,Object> params);
        void loadData();
    }
    public interface View{
        void showData(YuDaoBean yuDaoBean);
    }
}
