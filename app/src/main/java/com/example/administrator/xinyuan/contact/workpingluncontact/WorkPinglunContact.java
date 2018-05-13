package com.example.administrator.xinyuan.contact.workpingluncontact;

import com.example.administrator.xinyuan.model.entity.WorkPingLunLieBiaoBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/11.
 */

public interface WorkPinglunContact {
    public interface Presenter{
        void pinglunData(Map<String,Object> params);

    }
    public interface View{
        void showPingLun(WorkPingLunLieBiaoBean workPingLunLieBiaoBean);

    }
}
