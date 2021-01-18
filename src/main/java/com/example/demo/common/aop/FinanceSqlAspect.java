package com.example.demo.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Aspect
@Component
public class FinanceSqlAspect {

	@Pointcut("@annotation(com.example.demo.common.annotation.AspectColor)")
	public void aspectBankPointCut() {
	}

	@SuppressWarnings("unchecked")
	@Before("aspectBankPointCut()")
	public void addCurrentAdminInfo(JoinPoint joinPoint) {
		log.info("进入数据切面...");
		joinPoint.toString();
		String a=joinPoint.getThis().toString();
		try {
			Object[] args = joinPoint.getArgs();
			for (Object arg : args) {
				if (arg instanceof Map) {
					Map<String, Object> map = (Map<String, Object>) arg;
					/*SessionUser currentUser = BaseEntity.getCurrentUser();
					if (currentUser != null) {
						map.put("bankId", currentUser.getBankId());
						map.put("cityId", currentUser.getCityId());
						map.put("companyCodes", currentUser.getCompanyCodes());
						map.put("cityCodes", currentUser.getCityCodes());
						log.info("数据切面添加数据,map={}", JsonHelper.parseToJson(map));
					}*/
				} else {
					return;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("切面添加数据异常...");
		}
	}

}
