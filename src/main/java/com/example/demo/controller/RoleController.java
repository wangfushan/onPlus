package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Role;
import com.example.demo.service.IRoleService;
import com.example.demo.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class RoleController {

    @Autowired
    IRoleService roleService;

    @PostMapping(value = "/testPage")
    public String testPage(String typeCode) {

        Role role = roleService.getById(2);
        return role.toString();
    }

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

        for(int i=1;i<=50;i++){
            Role role=new Role();
           // role.setId(i+3);
            role.setRoles(i+"roles");
            role.setPermissions(i+"psermissions");
            roleService.save(role);
        }

    }

}
