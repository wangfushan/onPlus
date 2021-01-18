package com.example.demo.common.aop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Log4j2
@Component//（把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
//@Component,@Service,@Controller,@Repository注解的类，并把这些类纳入进spring容器中管理。
@Aspect
public class ColorSqlAsp {


    @Pointcut("@annotation(com.example.demo.common.annotation.AspectColor)")
    public void aspectBankPointCut() {
    }

    @Pointcut("@annotation(com.example.demo.common.annotation.AspectColor)")
    public void adPointCut() {
    }

    @Before("aspectBankPointCut()")
    public void colorAddSql() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        System.out.println("开始运行当前方法，当前方法为："+Thread.currentThread().getStackTrace()[1].getMethodName()+LocalDateTime.now(ZoneOffset.of("+8")).format(formatter));
    }

    @After("aspectBankPointCut()")
    public void ad() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        System.out.println("当前方法运行结束，当前方法为："+Thread.currentThread().getStackTrace()[1].getMethodName()+LocalDateTime.now(ZoneOffset.of("+8")).format(formatter));
    }

}
