package com.example.administrator.xinyuan.model.entity;

import java.io.Serializable;

/**
 * Created by fghjkl on 2018/5/13.
 */

public class QQBean implements Serializable{

    /**
     * unionid :
     * is_yellow_vip : 0
     * screen_name : xyxy
     * msg :
     * vip : 0
     * city :
     * accessToken : 5F3B12EB8F9793B65A7BD68C58F8C298
     * gender : 男
     * province :
     * is_yellow_year_vip : 0
     * openid : 6825E1716EA9B7C3BC2ADE09AD052F6E
     * profile_image_url : http://q.qlogo.cn/qqapp/1106499350/6825E1716EA9B7C3BC2ADE09AD052F6E/100
     * yellow_vip_level : 0
     * access_token : 5F3B12EB8F9793B65A7BD68C58F8C298
     * iconurl : http://q.qlogo.cn/qqapp/1106499350/6825E1716EA9B7C3BC2ADE09AD052F6E/100
     * name : xyxy
     * uid : 6825E1716EA9B7C3BC2ADE09AD052F6E
     * expiration : 1516788850111
     * expires_in : 1516788850111
     * ret : 0
     * level : 0
     */

    private String unionid;
    private String is_yellow_vip;
    private String screen_name;
    private String msg;
    private String vip;
    private String city;
    private String accessToken;
    private String gender;
    private String province;
    private String is_yellow_year_vip;
    private String openid;
    private String profile_image_url;
    private String yellow_vip_level;
    private String access_token;
    private String iconurl;
    private String name;
    private String uid;
    private String expiration;
    private String expires_in;
    private String ret;
    private String level;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public void setIs_yellow_vip(String is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }

    public void setIs_yellow_year_vip(String is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public void setYellow_vip_level(String yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "QQLoginModel{" +
                "unionid='" + unionid + '\'' +
                ", is_yellow_vip='" + is_yellow_vip + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", msg='" + msg + '\'' +
                ", vip='" + vip + '\'' +
                ", city='" + city + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", is_yellow_year_vip='" + is_yellow_year_vip + '\'' +
                ", openid='" + openid + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", yellow_vip_level='" + yellow_vip_level + '\'' +
                ", access_token='" + access_token + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", expiration='" + expiration + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", ret='" + ret + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
