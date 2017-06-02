package com.itzyf.bean;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 14:53
 */
public class PageResult<T> {
    private long totalRecord; //总记录数
    private int pageNum;
    private int pageSize;
    private int totalPage; //总页数
    private T list;

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
