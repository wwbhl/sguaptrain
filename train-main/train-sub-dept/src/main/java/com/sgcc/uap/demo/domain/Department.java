package com.sgcc.uap.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Department的POJO类
 *
 * @author administrator 
 * @date 2019-03-19 22:04:02
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * id
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 42)
    private String id ;
    
    /** 
     * 部门名称
     */
    @Column(name = "depname", nullable = true, length = 20)
    private String depName ;
    
    /** 
     * 父ID
     */
    @Column(name = "depparentid", nullable = true, length = 42)
    private String depParentId ;
    
    /** 
     * 描述
     */
    @Column(name = "depdesc", nullable = true, length = 20)
    private String depDesc ;
    
    /**
     * id的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * id的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * 部门名称的get方法
     * @return depName
     */
    public String getDepName(){
        return depName;
    }
    /**
     * 部门名称的set方法
     * @param depName
     */
    public void setDepName(String depName){
		this.depName = depName;
	} 
    /**
     * 父ID的get方法
     * @return depParentId
     */
    public String getDepParentId(){
        return depParentId;
    }
    /**
     * 父ID的set方法
     * @param depParentId
     */
    public void setDepParentId(String depParentId){
		this.depParentId = depParentId;
	} 
    /**
     * 描述的get方法
     * @return depDesc
     */
    public String getDepDesc(){
        return depDesc;
    }
    /**
     * 描述的set方法
     * @param depDesc
     */
    public void setDepDesc(String depDesc){
		this.depDesc = depDesc;
	} 
    /**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof Department))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		Department other = (Department) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (depName == null) {
			if (other.depName != null) {
				return false;
			}
		} else if (!depName.equals(other.depName)) {
			return false;
		}
		if (depParentId == null) {
			if (other.depParentId != null) {
				return false;
			}
		} else if (!depParentId.equals(other.depParentId)) {
			return false;
		}
		if (depDesc == null) {
			if (other.depDesc != null) {
				return false;
			}
		} else if (!depDesc.equals(other.depDesc)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "Department ["
			+ ", id=" + id
			+ ", depName=" + depName
			+ ", depParentId=" + depParentId
			+ ", depDesc=" + depDesc;
	}
   
    
    /**
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}