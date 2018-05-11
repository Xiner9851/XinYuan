package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MessageBean;

/**
 * Created by fghjkl on 2018/5/10.
 */

public interface IMessageContact {
    interface View{
        void showData(MessageBean value);
    }
    interface Present{
        void loadShuJu(int id);
    }
}
