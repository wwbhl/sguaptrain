package com.sgcc.uap.demo.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sgcc.uap.demo.domain.Employee;
import com.sgcc.uap.demo.repositories.EmployeeRepository;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author administrator
 * @date 2019-03-21 11:26:33
 * @since 1.0
 */
@Service
public class EmployeeService  implements IEmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public QueryResultObject getEmployeeById(String id) {
		Employee employee = employeeRepository.findOne(id);
		return RestUtils.wrappQueryResult(employee);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		String[] ids = idObject.getIds();
		for (String id : ids)
			employeeRepository.delete(id);
	}
	@Override
	public Employee saveEmployee(Map map) {
		
		Employee employee = new Employee();
		if (map.containsKey("id")) {
			
			try {
				String id = (String) map.get("id");
				employee = employeeRepository.findOne(id);
				CrudUtils.mapToObject(map, employee, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				BeanUtils.populate(employee, map);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return employeeRepository.save(employee);
	}
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		PageRequest request = this.buildPageRequest(queryCondition);
		Page<Employee> employee = employeeRepository.findAll(request);
		List<Employee> result = null;
		long count = 0;
		result = employee.getContent();
		count = employee.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}

	/**
	 * 构建PageRequest
	 * @param queryCondition
	 * @return 页面请求对象
	 */
	private PageRequest buildPageRequest(RequestCondition queryCondition) {
		int pageIndex = 1, pageSize = 1;
		if (queryCondition.getPageIndex() != null && queryCondition.getPageSize() != null) {
			pageIndex = queryCondition.getPageIndex();
			pageSize = queryCondition.getPageSize();
		}
		return new PageRequest(pageIndex - 1, pageSize, null);
	}
}
