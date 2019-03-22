package com.sgcc.uap.demo.feign;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public int getEmployeeCount(String params) {
	// TODO Auto-generated method stub
	return -1;
	}
}
