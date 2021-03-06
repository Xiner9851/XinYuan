package com.example.administrator.xinyuan.model.entity;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/12.
 */

public class ZanBean {



    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":20,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":17029,"page":1,"rows":20,"userId":668,"title":"你好","content":"赞了你的作业评论","otherUserId":778,"otherUserName":"八戒","otherUserPhoto":"http://qiniu.5roo.com/59a87011-eebf-4354-8e6d-becfbc85670e.jpg","imageUrl":"","linkUrl":"","type":4,"refId":507,"refType":"作业评论","createDate":1526022533000},{"id":17006,"page":1,"rows":20,"userId":668,"title":"你好","content":"赞了你的作业评论","otherUserId":778,"otherUserName":"八戒","otherUserPhoto":"http://qiniu.5roo.com/59a87011-eebf-4354-8e6d-becfbc85670e.jpg","imageUrl":"","linkUrl":"","type":4,"refId":507,"refType":"作业评论","createDate":1526020443000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * pageNum : 1
         * pageSize : 20
         * size : 2
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"id":17029,"page":1,"rows":20,"userId":668,"title":"你好","content":"赞了你的作业评论","otherUserId":778,"otherUserName":"八戒","otherUserPhoto":"http://qiniu.5roo.com/59a87011-eebf-4354-8e6d-becfbc85670e.jpg","imageUrl":"","linkUrl":"","type":4,"refId":507,"refType":"作业评论","createDate":1526022533000},{"id":17006,"page":1,"rows":20,"userId":668,"title":"你好","content":"赞了你的作业评论","otherUserId":778,"otherUserName":"八戒","otherUserPhoto":"http://qiniu.5roo.com/59a87011-eebf-4354-8e6d-becfbc85670e.jpg","imageUrl":"","linkUrl":"","type":4,"refId":507,"refType":"作业评论","createDate":1526020443000}]
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
             * id : 17029
             * page : 1
             * rows : 20
             * userId : 668
             * title : 你好
             * content : 赞了你的作业评论
             * otherUserId : 778
             * otherUserName : 八戒
             * otherUserPhoto : http://qiniu.5roo.com/59a87011-eebf-4354-8e6d-becfbc85670e.jpg
             * imageUrl :
             * linkUrl :
             * type : 4
             * refId : 507
             * refType : 作业评论
             * createDate : 1526022533000
             */

            private int id;
            private int page;
            private int rows;
            private int userId;
            private String title;
            private String content;
            private int otherUserId;
            private String otherUserName;
            private String otherUserPhoto;
            private String imageUrl;
            private String linkUrl;
            private int type;
            private int refId;
            private String refType;
            private long createDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getOtherUserId() {
                return otherUserId;
            }

            public void setOtherUserId(int otherUserId) {
                this.otherUserId = otherUserId;
            }

            public String getOtherUserName() {
                return otherUserName;
            }

            public void setOtherUserName(String otherUserName) {
                this.otherUserName = otherUserName;
            }

            public String getOtherUserPhoto() {
                return otherUserPhoto;
            }

            public void setOtherUserPhoto(String otherUserPhoto) {
                this.otherUserPhoto = otherUserPhoto;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getRefId() {
                return refId;
            }

            public void setRefId(int refId) {
                this.refId = refId;
            }

            public String getRefType() {
                return refType;
            }

            public void setRefType(String refType) {
                this.refType = refType;
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
