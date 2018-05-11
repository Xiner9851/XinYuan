package com.example.administrator.xinyuan.contact.huifuliebiaocontact;

import com.example.administrator.xinyuan.model.entity.HuiFuLieBiaoBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/11.
 */

public interface HuiFuLieBiaoContact {
    public interface Presenter{
        void huifuLieBiaoData(Map<String,Object> params);

    }
    public interface View{
        void showHuiFuLieBiao(HuiFuLieBiaoBean huiFuLieBiaoBean);

    }
}
