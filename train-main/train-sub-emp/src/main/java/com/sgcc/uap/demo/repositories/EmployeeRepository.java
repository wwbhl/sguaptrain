package com.sgcc.uap.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.demo.domain.Employee;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author administrator
 * @date 2019-03-21 11:26:33
 * @since 1.0
 */
public interface EmployeeRepository extends JpaRepository<Employee,String>,JpaSpecificationExecutor<Employee> {
	public Long countByDepId(String depId);
}
