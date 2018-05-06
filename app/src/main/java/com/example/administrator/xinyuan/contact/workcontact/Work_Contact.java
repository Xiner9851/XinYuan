package com.example.administrator.xinyuan.contact.workcontact;

import com.example.administrator.xinyuan.model.entity.WorkBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/5.
 */

public interface Work_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(WorkBean workBean);
    }
}
