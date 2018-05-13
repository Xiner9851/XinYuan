package com.example.administrator.xinyuan.contact.liwucontact;

import com.example.administrator.xinyuan.model.entity.LiWuBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/13.
 */

public interface LiWuContact {
    public interface Presenter{
        void liwuLieBiaoData(Map<String,Object> params);

    }
    public interface View{
        void showLiWuLieBiao(LiWuBean liWuBean);

    }
}
