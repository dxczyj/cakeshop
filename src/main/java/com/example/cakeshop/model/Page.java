package com.example.cakeshop.model;

import java.util.List;

public class Page {

    private int pageNumber;//当前是第几页
    private int totalPage;//总页数
    private int pageSize;//一页显示多少条数
    private int totalCount;//数据总数

    private List<Object> list;

    public void setPageSizeAndTotalCount(int pageSize,int totalCount){
        //每页显示多少个 总记录数
        //4 10 = 3  4 4 2
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        totalPage = (int) Math.ceil((double)totalCount/pageSize);
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
