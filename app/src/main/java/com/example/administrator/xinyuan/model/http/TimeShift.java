package com.example.administrator.xinyuan.model.http;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class TimeShift {
    public  static String getChatTime(long timesamp) {
        String result = "";
        Date today = new Date(System.currentTimeMillis());
        Date otherDay = new Date(timesamp);

        long time=today.getTime() - otherDay.getTime();

        long mill = time /1000;//秒前

        long minute = time/60/1000;// 分钟前

        long hour = time/60/60/1000;// 小时

        long day = time/24/60/60/1000;// 天前

        if (day - 1 >= 0) {
            if(day<=7){
                result=(day +"天");
            }else {
                return  getTimeStr(timesamp);
            }

        } else if (hour - 1 >= 0) {
            if (hour >= 24) {
                result=("1天");
            } else {
                result=(hour + "小时");
            }
        } else if (minute - 1 >= 0) {
            if (minute == 60) {
                result=("1小时");
            } else {
                result=(minute + "分钟");
            }
        } else if (mill - 1 >= 0) {
            if (mill == 60) {
                result=("1分钟");
            } else {
                result="刚刚";
            }
        } else {
            result="刚刚";
        }
        if (!"刚刚".equals(result.toString())) {
            result=result+"前";
        }
        return result;
    }

    private static String getTimeStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        return format.format(new Date(time));
    }
}
