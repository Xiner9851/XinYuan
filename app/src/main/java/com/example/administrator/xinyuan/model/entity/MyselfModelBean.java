package com.example.administrator.xinyuan.model.entity;

/**
 * Created by fghjkl on 2018/5/8.
 */

public class MyselfModelBean {
    /**
     * code : 0
     * message : 成功
     * data : {"artcircleCount":9,"isPreference":1,"mobile":"15701662050","photo":"http://image.5roo.com/uwo-file/fast/data/00/A1/ctcYLloPwu6ARXW1AAAXBjxZVsQ924.jpg","attentionCount":3,"fansCount":2,"userId":73,"realname":"xyxyx","homewokCount":27,"intro":"韧性、精细、善思决定结果指数","nickname":"xyxy","coachingCount":2,"userType":4}
     */

    private int code;




    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * artcircleCount : 9
         * isPreference : 1
         * mobile : 15701662050
         * photo : http://image.5roo.com/uwo-file/fast/data/00/A1/ctcYLloPwu6ARXW1AAAXBjxZVsQ924.jpg
         * attentionCount : 3
         * fansCount : 2
         * userId : 73
         * realname : xyxyx
         * homewokCount : 27
         * intro : 韧性、精细、善思决定结果指数
         * nickname : xyxy
         * coachingCount : 2
         * userType : 4
         */

        private int artcircleCount;
        private int isPreference;
        private String mobile;
        private String photo;
        private int attentionCount;
        private int fansCount;
        private int userId;
        private String realname;
        private int homewokCount;
        private String intro;
        private String nickname;
        private int coachingCount;
        private int userType;
        private int beanAmount;
        private int isAuth;

        public int getArtcircleCount() {
            return artcircleCount;
        }

        public void setArtcircleCount(int artcircleCount) {
            this.artcircleCount = artcircleCount;
        }

        public int getIsPreference() {
            return isPreference;
        }

        public void setIsPreference(int isPreference) {
            this.isPreference = isPreference;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(int attentionCount) {
            this.attentionCount = attentionCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public int getHomewokCount() {
            return homewokCount;
        }

        public void setHomewokCount(int homewokCount) {
            this.homewokCount = homewokCount;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCoachingCount() {
            return coachingCount;
        }

        public void setCoachingCount(int coachingCount) {
            this.coachingCount = coachingCount;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getBeanAmount() {
            return beanAmount;
        }

        public void setBeanAmount(int beanAmount) {
            this.beanAmount = beanAmount;
        }

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }
    }
}
