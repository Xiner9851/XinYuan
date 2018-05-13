package com.example.administrator.xinyuan.contact.worktijiaopinglun;

import com.example.administrator.xinyuan.model.entity.WorkTiJIaoBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/11.
 */

public interface WorkTiJiaoPingLunContact {
    public interface Presenter{
        void tijiaoData(Map<String,Object> params);

    }
    public interface View{
        void showTiJiao(WorkTiJIaoBean workTiJIaoBean);

    }
}
