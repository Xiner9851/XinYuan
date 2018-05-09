package com.example.administrator.xinyuan.contact.baodiancontact.baodianitemcontact;

import com.example.administrator.xinyuan.model.entity.BaoDian_Item_Bean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface BaoDian_Item_Contact {
    public interface Presenter{
        void loadData( Map<String,Object> params);
    }
    public interface View{
        void showData(BaoDian_Item_Bean baoDian_item_bean);
    }
}
