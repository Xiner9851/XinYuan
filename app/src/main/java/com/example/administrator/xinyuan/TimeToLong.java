package com.example.administrator.xinyuan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/12.
 */

public class TimeToLong {
    /**
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        Date d=new Date();
        long t=d.getTime();
        System.out.println(t);

        //将字符串类型转化成Date类型
        String s="2009-08-04 14:37:47";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2=null;
        d2=sdf.parse(s);//将String to Date类型
        System.out.println(d2);

        long t3=d2.getTime();
        System.out.println(t3);
    }
}
