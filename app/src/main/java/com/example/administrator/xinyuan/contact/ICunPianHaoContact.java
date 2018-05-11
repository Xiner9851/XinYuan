package com.example.administrator.xinyuan.contact;

/**
 * Created by fghjkl on 2018/5/11.
 */

public interface ICunPianHaoContact  {
    interface View{
        void pianHao(String a);
    }
    interface Present{
        void cunPianHao(String id,String magorid,String collegeid);
    }
}
