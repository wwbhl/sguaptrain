package com.sgcc.uap.demo.services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sgcc.uap.demo.domain.Department;
import com.sgcc.uap.demo.repositories.DepartmentRepository;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.TreeNode;
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
 * @date 2019-03-19 22:04:08
 * @since 1.0
 */
@Service
public class DepartmentService  implements IDepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public QueryResultObject getDepartmentById(String id) {
		Department department = departmentRepository.findOne(id);
		return RestUtils.wrappQueryResult(department);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		String[] ids = idObject.getIds();
		for (String id : ids)
			departmentRepository.delete(id);
	}
	@Override
	public Department saveDepartment(Map map) {
		
		Department department = new Department();
		if (map.containsKey("id")) {
			
			try {
				String id = (String) map.get("id");
				department = departmentRepository.findOne(id);
				CrudUtils.mapToObject(map, department, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				BeanUtils.populate(department, map);
				if(department.getDepParentId().equals("")){
					department.setDepParentId(null);
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return departmentRepository.save(department);
	}
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter();
		PageRequest request = this.buildPageRequest(queryCondition);
		Specification<Department> specification = new Specification<Department>() {

			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = null;
				if(qList != null && !qList.isEmpty()){
					for(QueryFilter queryFilter : qList){
						Path<String> namePath = root.get(queryFilter.getFieldName());
						if(queryFilter.getValue()==null||queryFilter.getValue().equals("null")||queryFilter.getValue().equals("")){
							predicate = cb.isNull(namePath);
						}else{
							predicate = cb.equal(namePath, queryFilter.getValue());
						}
						query.where(predicate);
					}
				}
				return null;
			}
		};
		Page<Department> department = departmentRepository.findAll(specification,request);
		List<Department> result = null;
		long count = 0;
		result = department.getContent();
		count = department.getTotalElements();
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
	@Override
	public List<TreeNode> listNodes(String nodeId) {
		List<TreeNode> treeList = new ArrayList<>();
		List<Department>  deptList = new ArrayList<Department>();
		if(nodeId == null){
			deptList = departmentRepository.findBydepParentIdIsNull();
		}else{
			deptList = departmentRepository.findBydepParentId(nodeId);
		}
		for(Department dept : deptList){
			TreeNode node = new TreeNode();
			node.setId(dept.getId());
			node.setText(dept.getDepName());
			List<Department> subList = departmentRepository.findBydepParentId(dept.getId());
			if(subList.size() > 0){
				
				node.setHasChildren(true);
			}else{
				node.setHasChildren(false);
			}
			treeList.add(node);
		}
		return treeList;
	}
}
