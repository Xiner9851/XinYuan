package com.example.administrator.xinyuan.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class Work_Item_Bean {

    /**
     * code : 0
     * message : 成功
     * data : {"comments":{"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0},"homewok":{"tUserType":2,"coverImg":"http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5?imageView2/0/w/480/h/270","praiseNum":7,"source":"求教作品","isPeep":0,"content":"老师，您帮我看下我的这张画有什么需要改进的地方呢？","studentId":557,"duration":null,"path":"http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5","peepPrice":1,"tPhoto":"http://qiniu.5roo.com/c5d845a86e22482e8371b4567b6b69be.jpg","answerContent":"这个速写基本的人物形态体现出来了，但是在细节上没有太多的去画。\n1.头发耳朵画的太粗糙\n2.眼睛也没有认真的去画，右眼感觉好像是多出来的一块，\n3.手的形态基本没有，关节手指太粗糙了\n4.鞋子就出来一个型，其他没有了\n5.右腿没有关节体现\n6.胳膊的关节处也没有体现出来\n希望下次能够画的再认真一些，速写需要长期的练习，不断的积累。加油","answerPicProperty":null,"answerPermission":0,"worksType":"图片","giftNum":0,"nickname":"一颗小豆芽","id":250,"tRealname":"王一飞","createDate":1525770219000,"answerCoverImg":"http://qiniu.5roo.com/","answerDate":1525771903000,"photo":"http://qiniu.5roo.com/e2f4cf3f-1c37-4854-aa3f-b6b8c0ec19ae.jpg","answerPath":"http://qiniu.5roo.com/","majorIds":"7","commentNum":0,"tIntro":"我是导师","answerWorksType":"","picProperty":"270_347","answerDuration":null,"tUserId":535,"isPraise":0,"userType":1,"isAnswer":0,"status":1},"rewardUserList":[]}
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
         * comments : {"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0}
         * homewok : {"tUserType":2,"coverImg":"http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5?imageView2/0/w/480/h/270","praiseNum":7,"source":"求教作品","isPeep":0,"content":"老师，您帮我看下我的这张画有什么需要改进的地方呢？","studentId":557,"duration":null,"path":"http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5","peepPrice":1,"tPhoto":"http://qiniu.5roo.com/c5d845a86e22482e8371b4567b6b69be.jpg","answerContent":"这个速写基本的人物形态体现出来了，但是在细节上没有太多的去画。\n1.头发耳朵画的太粗糙\n2.眼睛也没有认真的去画，右眼感觉好像是多出来的一块，\n3.手的形态基本没有，关节手指太粗糙了\n4.鞋子就出来一个型，其他没有了\n5.右腿没有关节体现\n6.胳膊的关节处也没有体现出来\n希望下次能够画的再认真一些，速写需要长期的练习，不断的积累。加油","answerPicProperty":null,"answerPermission":0,"worksType":"图片","giftNum":0,"nickname":"一颗小豆芽","id":250,"tRealname":"王一飞","createDate":1525770219000,"answerCoverImg":"http://qiniu.5roo.com/","answerDate":1525771903000,"photo":"http://qiniu.5roo.com/e2f4cf3f-1c37-4854-aa3f-b6b8c0ec19ae.jpg","answerPath":"http://qiniu.5roo.com/","majorIds":"7","commentNum":0,"tIntro":"我是导师","answerWorksType":"","picProperty":"270_347","answerDuration":null,"tUserId":535,"isPraise":0,"userType":1,"isAnswer":0,"status":1}
         * rewardUserList : []
         */

        private CommentsBean comments;
        private HomewokBean homewok;
        private List<?> rewardUserList;

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

        public List<?> getRewardUserList() {
            return rewardUserList;
        }

        public void setRewardUserList(List<?> rewardUserList) {
            this.rewardUserList = rewardUserList;
        }

        public static class CommentsBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 0
             * startRow : 0
             * endRow : 0
             * total : 0
             * pages : 0
             * list : []
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : []
             * navigateFirstPage : 0
             * navigateLastPage : 0
             * firstPage : 0
             * lastPage : 0
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
            private List<?> list;
            private List<?> navigatepageNums;

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

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }

            public List<?> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<?> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }
        }

        public static class HomewokBean {
            /**
             * tUserType : 2
             * coverImg : http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5?imageView2/0/w/480/h/270
             * praiseNum : 7
             * source : 求教作品
             * isPeep : 0
             * content : 老师，您帮我看下我的这张画有什么需要改进的地方呢？
             * studentId : 557
             * duration : null
             * path : http://qiniu.5roo.com/Flxm9rhxQh5uON9pocTp0hHWAIJ5
             * peepPrice : 1
             * tPhoto : http://qiniu.5roo.com/c5d845a86e22482e8371b4567b6b69be.jpg
             * answerContent : 这个速写基本的人物形态体现出来了，但是在细节上没有太多的去画。
             1.头发耳朵画的太粗糙
             2.眼睛也没有认真的去画，右眼感觉好像是多出来的一块，
             3.手的形态基本没有，关节手指太粗糙了
             4.鞋子就出来一个型，其他没有了
             5.右腿没有关节体现
             6.胳膊的关节处也没有体现出来
             希望下次能够画的再认真一些，速写需要长期的练习，不断的积累。加油
             * answerPicProperty : null
             * answerPermission : 0
             * worksType : 图片
             * giftNum : 0
             * nickname : 一颗小豆芽
             * id : 250
             * tRealname : 王一飞
             * createDate : 1525770219000
             * answerCoverImg : http://qiniu.5roo.com/
             * answerDate : 1525771903000
             * photo : http://qiniu.5roo.com/e2f4cf3f-1c37-4854-aa3f-b6b8c0ec19ae.jpg
             * answerPath : http://qiniu.5roo.com/
             * majorIds : 7
             * commentNum : 0
             * tIntro : 我是导师
             * answerWorksType :
             * picProperty : 270_347
             * answerDuration : null
             * tUserId : 535
             * isPraise : 0
             * userType : 1
             * isAnswer : 0
             * status : 1
             */

            private int tUserType;
            private String coverImg;
            private int praiseNum;
            private String source;
            private int isPeep;
            private String content;
            private int studentId;
            private Object duration;
            private String path;
            private int peepPrice;
            private String tPhoto;
            private String answerContent;
            private Object answerPicProperty;
            private int answerPermission;
            private String worksType;
            private int giftNum;
            private String nickname;
            private int id;
            private String tRealname;
            private long createDate;
            private String answerCoverImg;
            private long answerDate;
            private String photo;
            private String answerPath;
            private String majorIds;
            private int commentNum;
            private String tIntro;
            private String answerWorksType;
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

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
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

            public String getTPhoto() {
                return tPhoto;
            }

            public void setTPhoto(String tPhoto) {
                this.tPhoto = tPhoto;
            }

            public String getAnswerContent() {
                return answerContent;
            }

            public void setAnswerContent(String answerContent) {
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

            public String getTRealname() {
                return tRealname;
            }

            public void setTRealname(String tRealname) {
                this.tRealname = tRealname;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public String getAnswerCoverImg() {
                return answerCoverImg;
            }

            public void setAnswerCoverImg(String answerCoverImg) {
                this.answerCoverImg = answerCoverImg;
            }

            public long getAnswerDate() {
                return answerDate;
            }

            public void setAnswerDate(long answerDate) {
                this.answerDate = answerDate;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getAnswerPath() {
                return answerPath;
            }

            public void setAnswerPath(String answerPath) {
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

            public String getTIntro() {
                return tIntro;
            }

            public void setTIntro(String tIntro) {
                this.tIntro = tIntro;
            }

            public String getAnswerWorksType() {
                return answerWorksType;
            }

            public void setAnswerWorksType(String answerWorksType) {
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
    }
}
