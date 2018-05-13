package com.example.administrator.xinyuan.contact;

/**
 * Created by fghjkl on 2018/5/13.
 */

public interface QQBangDContact {
    interface View{
        void showQQ(String s);
    }
    interface Present{
        void QQBangD(String id,String uid,String openId);
    }
}
