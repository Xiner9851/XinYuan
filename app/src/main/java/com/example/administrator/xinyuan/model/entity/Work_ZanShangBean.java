package com.example.administrator.xinyuan.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Work_ZanShangBean {

    /**
     * code : 0
     * message : 成功
     * data : {"comments":{"pageNum":1,"pageSize":20,"size":6,"startRow":1,"endRow":6,"total":6,"pages":1,"list":[{"nickname":"陈希丶","replyNum":0,"photo":"http://qiniu.5roo.com/6e8d4407-4ba8-426e-9717-53732acf8119.jpg","isPraise":0,"praiseNum":0,"id":559,"userType":1,"userId":874,"content":"艺术气息来源于生活，以及对生活的追求","realname":"","createDate":1526039072000},{"nickname":"发吧","replyNum":0,"photo":"http://qiniu.5roo.com/98ed48c705cc48bcb99146342151672a.jpg","isPraise":0,"praiseNum":0,"id":507,"userType":1,"userId":668,"content":"你好","realname":null,"createDate":1526008086000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":467,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525961448000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":466,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957173000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":465,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957122000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":444,"userType":1,"userId":664,"content":"这是测试什么？","realname":null,"createDate":1525952085000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1},"homewok":{"tUserType":0,"coverImg":"http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ?vframe/png/offset/2/w/480/h/270|imageView2/0/w/480/h/270","praiseNum":1,"source":"求教作品","isPeep":0,"content":"测试","studentId":480,"duration":"4\u2032","path":"http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ","peepPrice":1,"tPhoto":null,"answerContent":null,"answerPicProperty":null,"answerPermission":0,"worksType":"视频","giftNum":13,"nickname":"潇雨哲","id":249,"tRealname":null,"createDate":1525507620000,"answerCoverImg":null,"answerDate":null,"photo":"http://qiniu.5roo.com/7f577e59-8f9b-4e10-9f4c-fac7d9fbde75.jpg","answerPath":null,"majorIds":"5,6","commentNum":6,"tIntro":null,"answerWorksType":null,"picProperty":"480_270","answerDuration":null,"tUserId":0,"isPraise":0,"userType":1,"isAnswer":1,"status":0},"rewardUserList":[{"userPhoto":"http://qiniu.5roo.com/7442666a-d2f4-4381-91a0-02f3af2c9fac.jpg","userName":"邓棒","userId":252}]}
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
         * comments : {"pageNum":1,"pageSize":20,"size":6,"startRow":1,"endRow":6,"total":6,"pages":1,"list":[{"nickname":"陈希丶","replyNum":0,"photo":"http://qiniu.5roo.com/6e8d4407-4ba8-426e-9717-53732acf8119.jpg","isPraise":0,"praiseNum":0,"id":559,"userType":1,"userId":874,"content":"艺术气息来源于生活，以及对生活的追求","realname":"","createDate":1526039072000},{"nickname":"发吧","replyNum":0,"photo":"http://qiniu.5roo.com/98ed48c705cc48bcb99146342151672a.jpg","isPraise":0,"praiseNum":0,"id":507,"userType":1,"userId":668,"content":"你好","realname":null,"createDate":1526008086000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":467,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525961448000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":466,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957173000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":465,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957122000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":444,"userType":1,"userId":664,"content":"这是测试什么？","realname":null,"createDate":1525952085000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         * homewok : {"tUserType":0,"coverImg":"http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ?vframe/png/offset/2/w/480/h/270|imageView2/0/w/480/h/270","praiseNum":1,"source":"求教作品","isPeep":0,"content":"测试","studentId":480,"duration":"4\u2032","path":"http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ","peepPrice":1,"tPhoto":null,"answerContent":null,"answerPicProperty":null,"answerPermission":0,"worksType":"视频","giftNum":13,"nickname":"潇雨哲","id":249,"tRealname":null,"createDate":1525507620000,"answerCoverImg":null,"answerDate":null,"photo":"http://qiniu.5roo.com/7f577e59-8f9b-4e10-9f4c-fac7d9fbde75.jpg","answerPath":null,"majorIds":"5,6","commentNum":6,"tIntro":null,"answerWorksType":null,"picProperty":"480_270","answerDuration":null,"tUserId":0,"isPraise":0,"userType":1,"isAnswer":1,"status":0}
         * rewardUserList : [{"userPhoto":"http://qiniu.5roo.com/7442666a-d2f4-4381-91a0-02f3af2c9fac.jpg","userName":"邓棒","userId":252}]
         */

        private CommentsBean comments;
        private HomewokBean homewok;
        private List<RewardUserListBean> rewardUserList;

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public HomewokBean getHomewok() {
            return homewok;
        }

        public void setHomewok(HomewokBean homewok) {
            this.homewok = homewok;
        }

        public List<RewardUserListBean> getRewardUserList() {
            return rewardUserList;
        }

        public void setRewardUserList(List<RewardUserListBean> rewardUserList) {
            this.rewardUserList = rewardUserList;
        }

        public static class CommentsBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 6
             * startRow : 1
             * endRow : 6
             * total : 6
             * pages : 1
             * list : [{"nickname":"陈希丶","replyNum":0,"photo":"http://qiniu.5roo.com/6e8d4407-4ba8-426e-9717-53732acf8119.jpg","isPraise":0,"praiseNum":0,"id":559,"userType":1,"userId":874,"content":"艺术气息来源于生活，以及对生活的追求","realname":"","createDate":1526039072000},{"nickname":"发吧","replyNum":0,"photo":"http://qiniu.5roo.com/98ed48c705cc48bcb99146342151672a.jpg","isPraise":0,"praiseNum":0,"id":507,"userType":1,"userId":668,"content":"你好","realname":null,"createDate":1526008086000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":467,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525961448000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":466,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957173000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":465,"userType":1,"userId":664,"content":"？","realname":null,"createDate":1525957122000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":444,"userType":1,"userId":664,"content":"这是测试什么？","realname":null,"createDate":1525952085000}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int firstPage;
            private int lastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * nickname : 陈希丶
                 * replyNum : 0
                 * photo : http://qiniu.5roo.com/6e8d4407-4ba8-426e-9717-53732acf8119.jpg
                 * isPraise : 0
                 * praiseNum : 0
                 * id : 559
                 * userType : 1
                 * userId : 874
                 * content : 艺术气息来源于生活，以及对生活的追求
                 * realname :
                 * createDate : 1526039072000
                 */

                private String nickname;
                private int replyNum;
                private String photo;
                private int isPraise;
                private int praiseNum;
                private int id;
                private int userType;
                private int userId;
                private String content;
                private String realname;
                private long createDate;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getReplyNum() {
                    return replyNum;
                }

                public void setReplyNum(int replyNum) {
                    this.replyNum = replyNum;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public int getIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(int isPraise) {
                    this.isPraise = isPraise;
                }

                public int getPraiseNum() {
                    return praiseNum;
                }

                public void setPraiseNum(int praiseNum) {
                    this.praiseNum = praiseNum;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserType() {
                    return userType;
                }

                public void setUserType(int userType) {
                    this.userType = userType;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getRealname() {
                    return realname;
                }

                public void setRealname(String realname) {
                    this.realname = realname;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }
            }
        }

        public static class HomewokBean {
            /**
             * tUserType : 0
             * coverImg : http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ?vframe/png/offset/2/w/480/h/270|imageView2/0/w/480/h/270
             * praiseNum : 1
             * source : 求教作品
             * isPeep : 0
             * content : 测试
             * studentId : 480
             * duration : 4′
             * path : http://qiniu.5roo.com/FjyR-1d4EWoBLCMXYDhmAiVGXwmZ
             * peepPrice : 1
             * tPhoto : null
             * answerContent : null
             * answerPicProperty : null
             * answerPermission : 0
             * worksType : 视频
             * giftNum : 13
             * nickname : 潇雨哲
             * id : 249
             * tRealname : null
             * createDate : 1525507620000
             * answerCoverImg : null
             * answerDate : null
             * photo : http://qiniu.5roo.com/7f577e59-8f9b-4e10-9f4c-fac7d9fbde75.jpg
             * answerPath : null
             * majorIds : 5,6
             * commentNum : 6
             * tIntro : null
             * answerWorksType : null
             * picProperty : 480_270
             * answerDuration : null
             * tUserId : 0
             * isPraise : 0
             * userType : 1
             * isAnswer : 1
             * status : 0
             */

            private int tUserType;
            private String coverImg;
            private int praiseNum;
            private String source;
            private int isPeep;
            private String content;
            private int studentId;
            private String duration;
            private String path;
            private int peepPrice;
            private Object tPhoto;
            private Object answerContent;
            private Object answerPicProperty;
            private int answerPermission;
            private String worksType;
            private int giftNum;
            private String nickname;
            private int id;
            private Object tRealname;
            private long createDate;
            private Object answerCoverImg;
            private Object answerDate;
            private String photo;
            private Object answerPath;
            private String majorIds;
            private int commentNum;
            private Object tIntro;
            private Object answerWorksType;
            private String picProperty;
            private Object answerDuration;
            private int tUserId;
            private int isPraise;
            private int userType;
            private int isAnswer;
            private int status;

            public int getTUserType() {
                return tUserType;
            }

            public void setTUserType(int tUserType) {
                this.tUserType = tUserType;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getIsPeep() {
                return isPeep;
            }

            public void setIsPeep(int isPeep) {
                this.isPeep = isPeep;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStudentId() {
                return studentId;
            }

            public void setStudentId(int studentId) {
                this.studentId = studentId;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getPeepPrice() {
                return peepPrice;
            }

            public void setPeepPrice(int peepPrice) {
                this.peepPrice = peepPrice;
            }

            public Object getTPhoto() {
                return tPhoto;
            }

            public void setTPhoto(Object tPhoto) {
                this.tPhoto = tPhoto;
            }

            public Object getAnswerContent() {
                return answerContent;
            }

            public void setAnswerContent(Object answerContent) {
                this.answerContent = answerContent;
            }

            public Object getAnswerPicProperty() {
                return answerPicProperty;
            }

            public void setAnswerPicProperty(Object answerPicProperty) {
                this.answerPicProperty = answerPicProperty;
            }

            public int getAnswerPermission() {
                return answerPermission;
            }

            public void setAnswerPermission(int answerPermission) {
                this.answerPermission = answerPermission;
            }

            public String getWorksType() {
                return worksType;
            }

            public void setWorksType(String worksType) {
                this.worksType = worksType;
            }

            public int getGiftNum() {
                return giftNum;
            }

            public void setGiftNum(int giftNum) {
                this.giftNum = giftNum;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getTRealname() {
                return tRealname;
            }

            public void setTRealname(Object tRealname) {
                this.tRealname = tRealname;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public Object getAnswerCoverImg() {
                return answerCoverImg;
            }

            public void setAnswerCoverImg(Object answerCoverImg) {
                this.answerCoverImg = answerCoverImg;
            }

            public Object getAnswerDate() {
                return answerDate;
            }

            public void setAnswerDate(Object answerDate) {
                this.answerDate = answerDate;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public Object getAnswerPath() {
                return answerPath;
            }

            public void setAnswerPath(Object answerPath) {
                this.answerPath = answerPath;
            }

            public String getMajorIds() {
                return majorIds;
            }

            public void setMajorIds(String majorIds) {
                this.majorIds = majorIds;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public Object getTIntro() {
                return tIntro;
            }

            public void setTIntro(Object tIntro) {
                this.tIntro = tIntro;
            }

            public Object getAnswerWorksType() {
                return answerWorksType;
            }

            public void setAnswerWorksType(Object answerWorksType) {
                this.answerWorksType = answerWorksType;
            }

            public String getPicProperty() {
                return picProperty;
            }

            public void setPicProperty(String picProperty) {
                this.picProperty = picProperty;
            }

            public Object getAnswerDuration() {
                return answerDuration;
            }

            public void setAnswerDuration(Object answerDuration) {
                this.answerDuration = answerDuration;
            }

            public int getTUserId() {
                return tUserId;
            }

            public void setTUserId(int tUserId) {
                this.tUserId = tUserId;
            }

            public int getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(int isPraise) {
                this.isPraise = isPraise;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getIsAnswer() {
                return isAnswer;
            }

            public void setIsAnswer(int isAnswer) {
                this.isAnswer = isAnswer;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class RewardUserListBean {
            /**
             * userPhoto : http://qiniu.5roo.com/7442666a-d2f4-4381-91a0-02f3af2c9fac.jpg
             * userName : 邓棒
             * userId : 252
             */

            private String userPhoto;
            private String userName;
            private int userId;

            public String getUserPhoto() {
                return userPhoto;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
