package com.example.administrator.xinyuan.model.entity;

/**
 * Created by fghjkl on 2018/5/13.
 */

public class QQBangDingBean {
    /**
     * code : 0
     * data : {}
     * message : string
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {

    }
}
