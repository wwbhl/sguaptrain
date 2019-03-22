package com.sgcc.uap.demo.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sgcc.uap.demo.domain.Employee;
import com.sgcc.uap.demo.repositories.EmployeeRepository;
import com.sgcc.uap.rest.support.DicItems;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
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
@RefreshScope
public class EmployeeService  implements IEmployeeService{
	
	@Value("${spring.sex}")
	private String sex = "";
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public QueryResultObject getEmployeeById(String id) {
		Employee employee = employeeRepository.findOne(id);
		List<DicItems> dictList = RestUtils.wrapDictList("sex", sex);
		return RestUtils.wrappQueryResult(employee).addDicItems(dictList);
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
		List<QueryFilter> qList = queryCondition.getQueryFilter();
		Specification<Employee> specification = new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			Predicate predicate = null;
			if(qList != null && !qList.isEmpty()){
			for(QueryFilter queryFilter : qList){
			Path<String> namePath = root.get(queryFilter.getFieldName());
			if(queryFilter.getFieldName().equals("depId")){
			predicate = cb.equal(namePath, queryFilter.getValue());
			}else{
			predicate = cb.like(namePath, "%"+queryFilter.getValue()+"%");
			}
			query.where(predicate);
			}
			}
			return null;
			}
			};
		PageRequest request = this.buildPageRequest(queryCondition);
		Page<Employee> employee = employeeRepository.findAll(request);
		List<Employee> result = null;
		long count = 0;
		result = employee.getContent();
		count = employee.getTotalElements();
		List<DicItems> dictList = RestUtils.wrapDictList("sex", sex);
		return RestUtils.wrappQueryResult(result, count).addDicItems(dictList);
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
	
	@Override
	public Long countByDepId(String depId) {
	// TODO Auto-generated method stub
	return employeeRepository.countByDepId(depId);
	}

}
