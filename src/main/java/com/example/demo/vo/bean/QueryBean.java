package com.example.demo.vo.bean;

import java.io.Serializable;

public class QueryBean<T> extends PageBean implements Serializable {

    private static final long serialVersionUID = -888208924222482655L;

    private String sortField;
    private String sortRule;
    private T queryTerms;
    private Integer debug;
    private String userCode;
    private String ascCode;

    public String getAscCode() {
        return ascCode;
    }

    public void setAscCode(String ascCode) {
        this.ascCode = ascCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getDebug() {
        return debug;
    }

    public void setDebug(Integer debug) {
        this.debug = debug;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortRule() {
        return sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }

    public T getQueryTerms() {
        return queryTerms;
    }

    public void setQueryTerms(T queryTerms) {
        this.queryTerms = queryTerms;
    }


}
