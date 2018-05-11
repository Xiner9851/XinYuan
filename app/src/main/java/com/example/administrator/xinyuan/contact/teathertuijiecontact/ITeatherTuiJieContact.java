package com.example.administrator.xinyuan.contact.teathertuijiecontact;

import com.example.administrator.xinyuan.model.entity.TeatherTuiJie_Item;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface ITeatherTuiJieContact {


    public interface Presenter{
        void loadData( Map<String,Object> params);
    }
    public interface View{
        void showData(TeatherTuiJie_Item teatherTuiJie_item);
    }
}
