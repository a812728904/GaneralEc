package com.lmx.generalec.bean;


/**
 * Author:GeneralBean
 * Created by LMX on 2018/4/17
 * Description: 原始实体父类
 */
public class GeneralBean<T> {

    /**
     * count : 1
     * start : 0
     * total : 577
     */
    private int count;
    private int start;
    private int total;
    private T books;

    public T getBooks() {
        return books;
    }

    public void setBooks(T books) {
        this.books = books;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
