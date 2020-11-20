package com.example.demo.vo;


import com.example.demo.vo.bean.QueryBean;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleVo extends QueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String permissions;

    private String roles;

    private  Integer id;

}
