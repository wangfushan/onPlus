package com.example.demo.vo.bean;

import java.io.Serializable;

public class ResponseBean implements Serializable {

    private static final long serialVersionUID = 5697564529030255379L;

    private long totalSize;
    private int status;
    private String errMsg;
    private Object data;

    public ResponseBean() {
    }

    public ResponseBean(Integer status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }

    public ResponseBean(Integer status, Object data, String errMsg) {
        this.status = status;
        this.data = data;
        this.errMsg = errMsg;
    }

    public ResponseBean(Integer status, Object data, String errMsg, Long totalSize) {
        this(status, data, errMsg);
        this.totalSize = totalSize;
    }

    public final long getTotalSize() {
        return totalSize;
    }

    public final void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public final Object getData() {
        return data;
    }

    public final void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "totalSize=" + totalSize +
                ", data=" + data +
                '}';
    }
}
