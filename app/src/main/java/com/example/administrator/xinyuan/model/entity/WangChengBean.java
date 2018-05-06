package com.example.administrator.xinyuan.model.entity;

/**
 * Created by fghjkl on 2018/5/5.
 */

public class WangChengBean {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"pppp","mobile":"18434786302","photo":null,"id":839,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI4dmlqczAiLCJzdWIiOiI4MzkiLCJleHAiOjE1MjYxMDA5NTgsImlhdCI6MTUyNTQ5NjE1OH0.ixiQMvCXPlWR79Tbufw_qfOQJ3g_rf_6UTw7BLDF9JNVsIn94tuz6oflyXI5fYMofgHdbd3OsgYk9swseNTqwg"}
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
         * nickname : pppp
         * mobile : 18434786302
         * photo : null
         * id : 839
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI4dmlqczAiLCJzdWIiOiI4MzkiLCJleHAiOjE1MjYxMDA5NTgsImlhdCI6MTUyNTQ5NjE1OH0.ixiQMvCXPlWR79Tbufw_qfOQJ3g_rf_6UTw7BLDF9JNVsIn94tuz6oflyXI5fYMofgHdbd3OsgYk9swseNTqwg
         */

        private String nickname;
        private String mobile;
        private Object photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
