package com.sgcc.uap.demo.vo;


import com.sgcc.uap.demo.domain.Department;

public class DepartmentTransfer {

	public static Department toPO(DepartmentVO vo) {
		Department department = new Department();
		if(vo != null){
			department.setId(vo.getId());
			department.setDepName(vo.getDepName());
			department.setDepParentId(vo.getDepParentId());
			department.setDepDesc(vo.getDepDesc());
        }
		return department;
	}

	public static DepartmentVO toVO(Department po) {
		DepartmentVO vo = new DepartmentVO();
		vo.setId(po.getId());
		vo.setDepName(po.getDepName());
		vo.setDepParentId(po.getDepParentId());
		vo.setDepDesc(po.getDepDesc());
		return vo;
	}
}
