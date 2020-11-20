package com.example.demo.vo.bean;

import java.io.Serializable;

/**
 * @Description Excel等批量操作的每条处理结果
 * @Author s73w95
 * @Date 2019/6/20
 **/
public class CommonResult implements Serializable {

    private static final long serialVersionUID = -8617462077304972147L;

    private int rowNum;
    private String errorMsg;

    public CommonResult(int rowNum,String errorMsg){
        this.rowNum = rowNum;
        this.errorMsg = errorMsg;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
