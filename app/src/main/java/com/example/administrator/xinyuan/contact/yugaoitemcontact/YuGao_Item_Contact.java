package com.example.administrator.xinyuan.contact.yugaoitemcontact;

import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface YuGao_Item_Contact {
    public interface Presenter{
        void loadData( Map<String,Object> params);
    }
    public interface View{
        void showData(YuGao_ItemData yuGao_itemData);
    }
}
