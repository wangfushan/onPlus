package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangfushan
 * @since 2020-11-10
 */
public interface UserService extends IService<User> {
    public User findByUsername(User user);

    public User findUserById(String userId);

}
