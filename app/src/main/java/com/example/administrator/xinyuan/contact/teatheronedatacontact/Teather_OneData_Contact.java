package com.example.administrator.xinyuan.contact.teatheronedatacontact;

import com.example.administrator.xinyuan.model.entity.Teather_One_Item;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/7.
 */

public interface Teather_OneData_Contact {
    public interface Presenter{
        void loadData( Map<String,Object> params);
    }
    public interface View{
        void showData(Teather_One_Item teather_one_item);
    }
}
