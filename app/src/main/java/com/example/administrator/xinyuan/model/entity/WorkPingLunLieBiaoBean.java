package com.example.administrator.xinyuan.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class WorkPingLunLieBiaoBean {


    /**
     * code : 0
     * message : 成功
     * data : {"comments":{"pageNum":1,"pageSize":20,"size":12,"startRow":1,"endRow":12,"total":12,"pages":1,"list":[{"nickname":"\u2026\u2026","replyNum":0,"photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","isPraise":0,"praiseNum":3,"id":370,"userType":1,"userId":919,"content":"梦想总是这样的，或许走在追梦的路上，我才是最真实的我。","realname":null,"createDate":1525834427000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":1,"id":462,"userType":1,"userId":664,"content":"艺术来源于生活","realname":null,"createDate":1525956058000},{"nickname":"我是五六七八九","replyNum":2,"photo":"","isPraise":0,"praiseNum":0,"id":432,"userType":1,"userId":784,"content":"很好","realname":null,"createDate":1525935014000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":458,"userType":1,"userId":664,"content":"11111","realname":null,"createDate":1525954873000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":418,"userType":1,"userId":874,"content":"少年强则少女扶墙，少女强则少年扶墙","realname":null,"createDate":1525916904000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":411,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865234000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":410,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865201000},{"nickname":"哈哈哈","replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":406,"userType":1,"userId":873,"content":"梦想的启航","realname":null,"createDate":1525860687000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":383,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525858206000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":378,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856573000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":376,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856509000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":375,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856475000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * comments : {"pageNum":1,"pageSize":20,"size":12,"startRow":1,"endRow":12,"total":12,"pages":1,"list":[{"nickname":"\u2026\u2026","replyNum":0,"photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","isPraise":0,"praiseNum":3,"id":370,"userType":1,"userId":919,"content":"梦想总是这样的，或许走在追梦的路上，我才是最真实的我。","realname":null,"createDate":1525834427000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":1,"id":462,"userType":1,"userId":664,"content":"艺术来源于生活","realname":null,"createDate":1525956058000},{"nickname":"我是五六七八九","replyNum":2,"photo":"","isPraise":0,"praiseNum":0,"id":432,"userType":1,"userId":784,"content":"很好","realname":null,"createDate":1525935014000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":458,"userType":1,"userId":664,"content":"11111","realname":null,"createDate":1525954873000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":418,"userType":1,"userId":874,"content":"少年强则少女扶墙，少女强则少年扶墙","realname":null,"createDate":1525916904000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":411,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865234000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":410,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865201000},{"nickname":"哈哈哈","replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":406,"userType":1,"userId":873,"content":"梦想的启航","realname":null,"createDate":1525860687000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":383,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525858206000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":378,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856573000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":376,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856509000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":375,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856475000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         */

        private CommentsBean comments;

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 12
             * startRow : 1
             * endRow : 12
             * total : 12
             * pages : 1
             * list : [{"nickname":"\u2026\u2026","replyNum":0,"photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","isPraise":0,"praiseNum":3,"id":370,"userType":1,"userId":919,"content":"梦想总是这样的，或许走在追梦的路上，我才是最真实的我。","realname":null,"createDate":1525834427000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":1,"id":462,"userType":1,"userId":664,"content":"艺术来源于生活","realname":null,"createDate":1525956058000},{"nickname":"我是五六七八九","replyNum":2,"photo":"","isPraise":0,"praiseNum":0,"id":432,"userType":1,"userId":784,"content":"很好","realname":null,"createDate":1525935014000},{"nickname":"大爷","replyNum":0,"photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","isPraise":0,"praiseNum":0,"id":458,"userType":1,"userId":664,"content":"11111","realname":null,"createDate":1525954873000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":418,"userType":1,"userId":874,"content":"少年强则少女扶墙，少女强则少年扶墙","realname":null,"createDate":1525916904000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":411,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865234000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":410,"userType":null,"userId":0,"content":"","realname":null,"createDate":1525865201000},{"nickname":"哈哈哈","replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":406,"userType":1,"userId":873,"content":"梦想的启航","realname":null,"createDate":1525860687000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":383,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525858206000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":378,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856573000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":376,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856509000},{"nickname":"韩宇","replyNum":0,"photo":"http://qiniu.5roo.com/1e1f36c1-dbcb-443e-ba5c-cf4e3787353f.jpg","isPraise":0,"praiseNum":0,"id":375,"userType":1,"userId":874,"content":"qaaaaa","realname":null,"createDate":1525856475000}]
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
                 * nickname : ……
                 * replyNum : 0
                 * photo : http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg
                 * isPraise : 0
                 * praiseNum : 3
                 * id : 370
                 * userType : 1
                 * userId : 919
                 * content : 梦想总是这样的，或许走在追梦的路上，我才是最真实的我。
                 * realname : null
                 * createDate : 1525834427000
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
                private Object realname;
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

                public Object getRealname() {
                    return realname;
                }

                public void setRealname(Object realname) {
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
    }
}
