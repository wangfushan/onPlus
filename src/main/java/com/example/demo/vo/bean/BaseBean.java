package com.example.demo.vo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 4657599285601237934L;

    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;

    private static final String TIMEZONE_GMT_8 = "GMT+8";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String DATE_TIME_FORMAT_DD = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT_SS = "yyyy-MM-dd HH:mm:ss";

    @JsonFormat(pattern = DATE_TIME_FORMAT_SS, timezone = TIMEZONE_GMT_8)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = DATE_TIME_FORMAT_SS, timezone = TIMEZONE_GMT_8)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }


}
