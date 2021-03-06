package com.example.administrator.xinyuan.model.entity;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class TieZiBean {

    /**
     * code : 0
     * message : 成功
     * data : {"artcircleList":{"pageNum":1,"pageSize":20,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"coverImg":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg?imageView2/0/w/480/h/270","photo":"http://qiniu.5roo.com/458bdfd7-0afd-4b4f-86a7-a9d8a1484f32.jpg","praiseNum":13,"title":"专业演员的吻戏和床戏体验，那些羞羞的画面原来是这样拍出来的","userId":296,"content":"<p><img src=\"http://qiniu.5roo.com/511cd76b-62fa-4342-9c54-33129e7c105d.bmp\" style=\"max-width:100%;\"><br><\/p><p>专业演员拍吻戏和床戏是什么感觉？<\/p><p>&nbsp;请看以下文字。<\/p><p>（<span style=\"font-size: 14px;\">部分文字来源于网络）<\/span><\/p><p><br><\/p><p><img src=\"http://qiniu.5roo.com/55701815-7092-490d-8f1e-7b91abe52a4b.bmp\" style=\"max-width:100%;\"><img src=\"http://qiniu.5roo.com/ad06b980-2f96-4458-a1b3-051e92cb2984.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d2fa4c32-e5d1-404e-80cb-3f3a1c972bff.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b95a329e-54cf-4cea-b397-7fe6a9e21605.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/455695cc-e433-45ab-96af-027f8d392cae.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b9fb8b41-3085-496f-b0a0-513743a38f60.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e3e0e119-b798-48ce-8d04-9c6921089195.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b15be0f8-098a-410d-8a6c-da5f3ecabe9d.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/c588e86c-ca88-4df7-a706-5a2ba8e21cf8.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/defe1af6-443e-4627-92b6-2a49597aa4aa.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d7da2b49-490f-4166-bab2-4c93cb484047.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/9994f3fd-c090-4192-a6b2-ef03938108ac.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/060d2bae-4b22-446b-bcee-f71d8367e05e.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e4ae75dc-4468-4ac3-8c50-7c4a24749fb9.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/5aea2aef-245b-4bd4-9c0b-24559b9afc32.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b43abe3f-7e44-4027-a660-6b8f9ccd81fb.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8710d476-1c32-49a4-89b1-294d95ee7301.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/02fe7501-fb72-4baf-b977-2b156c6e2e09.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8c34a6cf-8c95-4eb7-a60a-588b84aa9134.bmp\" style=\"font-size: 14px; max-width: 100%;\"><br><\/p>","favoriteNum":1,"duration":null,"majorIds":"6","commentNum":0,"path":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg","picProperty":"479_270","worksType":"图片","nickname":"星愿艺教","isPraise":1,"userType":1,"id":238,"contentType":"经验分享","createDate":1525744474000,"isFavorite":1}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * artcircleList : {"pageNum":1,"pageSize":20,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"coverImg":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg?imageView2/0/w/480/h/270","photo":"http://qiniu.5roo.com/458bdfd7-0afd-4b4f-86a7-a9d8a1484f32.jpg","praiseNum":13,"title":"专业演员的吻戏和床戏体验，那些羞羞的画面原来是这样拍出来的","userId":296,"content":"<p><img src=\"http://qiniu.5roo.com/511cd76b-62fa-4342-9c54-33129e7c105d.bmp\" style=\"max-width:100%;\"><br><\/p><p>专业演员拍吻戏和床戏是什么感觉？<\/p><p>&nbsp;请看以下文字。<\/p><p>（<span style=\"font-size: 14px;\">部分文字来源于网络）<\/span><\/p><p><br><\/p><p><img src=\"http://qiniu.5roo.com/55701815-7092-490d-8f1e-7b91abe52a4b.bmp\" style=\"max-width:100%;\"><img src=\"http://qiniu.5roo.com/ad06b980-2f96-4458-a1b3-051e92cb2984.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d2fa4c32-e5d1-404e-80cb-3f3a1c972bff.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b95a329e-54cf-4cea-b397-7fe6a9e21605.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/455695cc-e433-45ab-96af-027f8d392cae.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b9fb8b41-3085-496f-b0a0-513743a38f60.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e3e0e119-b798-48ce-8d04-9c6921089195.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b15be0f8-098a-410d-8a6c-da5f3ecabe9d.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/c588e86c-ca88-4df7-a706-5a2ba8e21cf8.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/defe1af6-443e-4627-92b6-2a49597aa4aa.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d7da2b49-490f-4166-bab2-4c93cb484047.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/9994f3fd-c090-4192-a6b2-ef03938108ac.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/060d2bae-4b22-446b-bcee-f71d8367e05e.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e4ae75dc-4468-4ac3-8c50-7c4a24749fb9.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/5aea2aef-245b-4bd4-9c0b-24559b9afc32.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b43abe3f-7e44-4027-a660-6b8f9ccd81fb.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8710d476-1c32-49a4-89b1-294d95ee7301.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/02fe7501-fb72-4baf-b977-2b156c6e2e09.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8c34a6cf-8c95-4eb7-a60a-588b84aa9134.bmp\" style=\"font-size: 14px; max-width: 100%;\"><br><\/p>","favoriteNum":1,"duration":null,"majorIds":"6","commentNum":0,"path":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg","picProperty":"479_270","worksType":"图片","nickname":"星愿艺教","isPraise":1,"userType":1,"id":238,"contentType":"经验分享","createDate":1525744474000,"isFavorite":1}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         */

        private ArtcircleListBean artcircleList;

        public ArtcircleListBean getArtcircleList() {
            return artcircleList;
        }

        public void setArtcircleList(ArtcircleListBean artcircleList) {
            this.artcircleList = artcircleList;
        }

        public static class ArtcircleListBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 1
             * startRow : 1
             * endRow : 1
             * total : 1
             * pages : 1
             * list : [{"coverImg":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg?imageView2/0/w/480/h/270","photo":"http://qiniu.5roo.com/458bdfd7-0afd-4b4f-86a7-a9d8a1484f32.jpg","praiseNum":13,"title":"专业演员的吻戏和床戏体验，那些羞羞的画面原来是这样拍出来的","userId":296,"content":"<p><img src=\"http://qiniu.5roo.com/511cd76b-62fa-4342-9c54-33129e7c105d.bmp\" style=\"max-width:100%;\"><br><\/p><p>专业演员拍吻戏和床戏是什么感觉？<\/p><p>&nbsp;请看以下文字。<\/p><p>（<span style=\"font-size: 14px;\">部分文字来源于网络）<\/span><\/p><p><br><\/p><p><img src=\"http://qiniu.5roo.com/55701815-7092-490d-8f1e-7b91abe52a4b.bmp\" style=\"max-width:100%;\"><img src=\"http://qiniu.5roo.com/ad06b980-2f96-4458-a1b3-051e92cb2984.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d2fa4c32-e5d1-404e-80cb-3f3a1c972bff.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b95a329e-54cf-4cea-b397-7fe6a9e21605.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/455695cc-e433-45ab-96af-027f8d392cae.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b9fb8b41-3085-496f-b0a0-513743a38f60.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e3e0e119-b798-48ce-8d04-9c6921089195.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b15be0f8-098a-410d-8a6c-da5f3ecabe9d.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/c588e86c-ca88-4df7-a706-5a2ba8e21cf8.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/defe1af6-443e-4627-92b6-2a49597aa4aa.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/d7da2b49-490f-4166-bab2-4c93cb484047.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/9994f3fd-c090-4192-a6b2-ef03938108ac.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/060d2bae-4b22-446b-bcee-f71d8367e05e.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/e4ae75dc-4468-4ac3-8c50-7c4a24749fb9.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/5aea2aef-245b-4bd4-9c0b-24559b9afc32.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/b43abe3f-7e44-4027-a660-6b8f9ccd81fb.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8710d476-1c32-49a4-89b1-294d95ee7301.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/02fe7501-fb72-4baf-b977-2b156c6e2e09.bmp\" style=\"font-size: 14px; max-width: 100%;\"><img src=\"http://qiniu.5roo.com/8c34a6cf-8c95-4eb7-a60a-588b84aa9134.bmp\" style=\"font-size: 14px; max-width: 100%;\"><br><\/p>","favoriteNum":1,"duration":null,"majorIds":"6","commentNum":0,"path":"http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg","picProperty":"479_270","worksType":"图片","nickname":"星愿艺教","isPraise":1,"userType":1,"id":238,"contentType":"经验分享","createDate":1525744474000,"isFavorite":1}]
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
                 * coverImg : http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg?imageView2/0/w/480/h/270
                 * photo : http://qiniu.5roo.com/458bdfd7-0afd-4b4f-86a7-a9d8a1484f32.jpg
                 * praiseNum : 13
                 * title : 专业演员的吻戏和床戏体验，那些羞羞的画面原来是这样拍出来的
                 * userId : 296
                 * content : <p><img src="http://qiniu.5roo.com/511cd76b-62fa-4342-9c54-33129e7c105d.bmp" style="max-width:100%;"><br></p><p>专业演员拍吻戏和床戏是什么感觉？</p><p>&nbsp;请看以下文字。</p><p>（<span style="font-size: 14px;">部分文字来源于网络）</span></p><p><br></p><p><img src="http://qiniu.5roo.com/55701815-7092-490d-8f1e-7b91abe52a4b.bmp" style="max-width:100%;"><img src="http://qiniu.5roo.com/ad06b980-2f96-4458-a1b3-051e92cb2984.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/d2fa4c32-e5d1-404e-80cb-3f3a1c972bff.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/b95a329e-54cf-4cea-b397-7fe6a9e21605.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/455695cc-e433-45ab-96af-027f8d392cae.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/b9fb8b41-3085-496f-b0a0-513743a38f60.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/e3e0e119-b798-48ce-8d04-9c6921089195.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/b15be0f8-098a-410d-8a6c-da5f3ecabe9d.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/c588e86c-ca88-4df7-a706-5a2ba8e21cf8.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/defe1af6-443e-4627-92b6-2a49597aa4aa.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/d7da2b49-490f-4166-bab2-4c93cb484047.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/9994f3fd-c090-4192-a6b2-ef03938108ac.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/060d2bae-4b22-446b-bcee-f71d8367e05e.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/e4ae75dc-4468-4ac3-8c50-7c4a24749fb9.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/5aea2aef-245b-4bd4-9c0b-24559b9afc32.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/b43abe3f-7e44-4027-a660-6b8f9ccd81fb.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/8710d476-1c32-49a4-89b1-294d95ee7301.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/02fe7501-fb72-4baf-b977-2b156c6e2e09.bmp" style="font-size: 14px; max-width: 100%;"><img src="http://qiniu.5roo.com/8c34a6cf-8c95-4eb7-a60a-588b84aa9134.bmp" style="font-size: 14px; max-width: 100%;"><br></p>
                 * favoriteNum : 1
                 * duration : null
                 * majorIds : 6
                 * commentNum : 0
                 * path : http://qiniu.5roo.com/44c5639a-e398-4738-84a8-7445be4b59a6.jpg
                 * picProperty : 479_270
                 * worksType : 图片
                 * nickname : 星愿艺教
                 * isPraise : 1
                 * userType : 1
                 * id : 238
                 * contentType : 经验分享
                 * createDate : 1525744474000
                 * isFavorite : 1
                 */

                private String coverImg;
                private String photo;
                private int praiseNum;
                private String title;
                private int userId;
                private String content;
                private int favoriteNum;
                private Object duration;
                private String majorIds;
                private int commentNum;
                private String path;
                private String picProperty;
                private String worksType;
                private String nickname;
                private int isPraise;
                private int userType;
                private int id;
                private String contentType;
                private long createDate;
                private int isFavorite;

                public String getCoverImg() {
                    return coverImg;
                }

                public void setCoverImg(String coverImg) {
                    this.coverImg = coverImg;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public int getPraiseNum() {
                    return praiseNum;
                }

                public void setPraiseNum(int praiseNum) {
                    this.praiseNum = praiseNum;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
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

                public int getFavoriteNum() {
                    return favoriteNum;
                }

                public void setFavoriteNum(int favoriteNum) {
                    this.favoriteNum = favoriteNum;
                }

                public Object getDuration() {
                    return duration;
                }

                public void setDuration(Object duration) {
                    this.duration = duration;
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

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getPicProperty() {
                    return picProperty;
                }

                public void setPicProperty(String picProperty) {
                    this.picProperty = picProperty;
                }

                public String getWorksType() {
                    return worksType;
                }

                public void setWorksType(String worksType) {
                    this.worksType = worksType;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getContentType() {
                    return contentType;
                }

                public void setContentType(String contentType) {
                    this.contentType = contentType;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }

                public int getIsFavorite() {
                    return isFavorite;
                }

                public void setIsFavorite(int isFavorite) {
                    this.isFavorite = isFavorite;
                }
            }
        }
    }
}
