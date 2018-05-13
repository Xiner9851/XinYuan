package com.example.administrator.xinyuan.contact.workcontact.workitemcontact;

import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.model.entity.Work_ZanShangBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface Work_Item_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
        void zanShangLoadData(Map<String,Object> params);
    }
    public interface View{
        void showData(Work_Item_Bean work_item_bean);
        void zanShangshowData(Work_ZanShangBean work_item_bean);
    }

}
