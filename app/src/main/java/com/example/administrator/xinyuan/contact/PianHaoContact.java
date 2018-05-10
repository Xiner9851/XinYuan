package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;

/**
 * Created by fghjkl on 2018/5/9.
 */

public interface PianHaoContact {
    interface View{
        void showPianHao(MyPianHaoBean.DataBean data);
    }
    interface Present{
        void loadPianHao();
    }
}
