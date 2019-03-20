package com.sgcc.uap.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.demo.domain.Department;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author administrator
 * @date 2019-03-19 22:04:08
 * @since 1.0
 */
public interface DepartmentRepository extends JpaRepository<Department,String>,JpaSpecificationExecutor<Department> {

	//查询根节点
	public List<Department> findBydepParentIdIsNull();
	//查询子节点
	public List<Department> findBydepParentId(String nodeId);
}
