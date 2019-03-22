package com.sgcc.uap.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//@FeignClient(name="train-sub-emp",fallback=HystrixClientFallback.class)  
public interface UserFeignClient {
	@RequestMapping(value = "/employee/count/{params}")
	public int getEmployeeCount(@PathVariable("params") String params);
}
