package com.sgcc.uap.demo.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * Department的VO类
 *
 * @author administrator 
 * @date 2019-03-19 22:04:07
 */
public class DepartmentVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性id
     */  
    @ViewAttribute(name ="id",caption="id", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性部门名称
     */  
    @ViewAttribute(name ="depName",caption="部门名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depName;    
    /** 
     * 属性父ID
     */  
    @ViewAttribute(name ="depParentId",caption="父ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depParentId;    
    /** 
     * 属性描述
     */  
    @ViewAttribute(name ="depDesc",caption="描述", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depDesc;    
    /**
     * DepartmentVO构造函数
     */
    public DepartmentVO() {
        super();
    } 
   
	 /**
     * DepartmentVO完整的构造函数
     */  
    public DepartmentVO(String id){
        this.id = id;
    }
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("id"+":"+getId())
				.append("depname"+":"+getDepName())
				.append("depparentid"+":"+getDepParentId())
				.append("depdesc"+":"+getDepDesc())
		        .toString(); 
			
    } 
   


}
