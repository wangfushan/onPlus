package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Role;
import com.example.demo.service.IRoleService;
import com.example.demo.vo.RoleVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangfushan
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/vivi/role")
@ApiModel("RoleController接口返回")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @PostMapping(value = "/testPage")
    @ApiOperation(value="查询单词计数", notes="查询单词计数", produces="application/json")
    @ApiImplicitParam(name = "typeCode", value = "单词", paramType = "query", required = true, dataType = "String")
    public String testPage(String typeCode) {
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",2);
        Map one = (Map) roleService.getOne(queryWrapper);
        return one.toString();
    }

    @PostMapping(value = "/testSave")
    public String getTest(){
      QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
      queryWrapper.eq("id",33);
        Role one = roleService.getOne(queryWrapper);
        return one.toString();
    }
    @ApiOperation(value="商品新增")
    @PostMapping("/selectPage")
    public Page<Role>  selectPage(@RequestBody RoleVo roleVo){
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("roles",roleVo.getRoles());
        Page<Role> page = new Page<>();
        page.setSize(roleVo.getPageSize());
        page.setCurrent(roleVo.getPageNum());
        Page<Role> page1=roleService.page(page);
      //  Role page2=roleService.getOne(queryWrapper);
        return  page1;

    }

    @PostMapping(value = "/insert")
    public void insert(String typeCode) {
        System.out.println();

        for(int i=100;i<=150;i++){
            Role role=new Role();
           // role.setId(i+3);
            role.setRoles(i+"roles");
            role.setPermissions(i+"psermissions");
            roleService.save(role);
        }

    }

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("yyyy-MM-dd"));
        String date="2020-10-02";
        Date parse = simpleDateFormat.parse(date);
        System.out.println(parse);

    }



}
