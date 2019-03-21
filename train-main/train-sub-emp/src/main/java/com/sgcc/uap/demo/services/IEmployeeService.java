package com.sgcc.uap.demo.services;

import java.util.Map;

import com.sgcc.uap.demo.domain.Employee;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;

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
public interface IEmployeeService {
	/**
	 * 查询部门下的员工数
	 * @param depId
	 * @return
	 */
	public Long countByDepId(String depId);
	/**
	 * 根据主键 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject getEmployeeById(String id);
	/**
	 * 根据idObject删除
	 * @param idObject
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * 保存
	 * @param map
	 * @return
	 */
	public Employee saveEmployee(Map map);
	/**
	 * 根据查询条件 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject query(RequestCondition queryCondition);
}
