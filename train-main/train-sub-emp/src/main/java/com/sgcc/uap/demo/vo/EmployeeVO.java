package com.sgcc.uap.demo.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * Employee的VO类
 *
 * @author administrator 
 * @date 2019-03-21 11:26:33
 */
public class EmployeeVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性id
     */  
    @ViewAttribute(name ="id",caption="id", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性部门ID
     */  
    @ViewAttribute(name ="depId",caption="部门ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depId;    
    /** 
     * 属性员工姓名
     */  
    @ViewAttribute(name ="name",caption="员工姓名", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String name;    
    /** 
     * 属性员工编号
     */  
    @ViewAttribute(name ="num",caption="员工编号", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String num;    
    /** 
     * 属性年龄
     */  
    @ViewAttribute(name ="age",caption="年龄", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String age;    
    /** 
     * 属性性别
     */  
    @ViewAttribute(name ="sex",caption="性别", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String sex;    
    /** 
     * 属性地址
     */  
    @ViewAttribute(name ="address",caption="地址", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String address;    
    /** 
     * 属性电话
     */  
    @ViewAttribute(name ="tel",caption="电话", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String tel;    
    /** 
     * 属性入职时间
     */  
    @ViewAttribute(name ="inductiontime",caption="入职时间", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String inductiontime;    
    /**
     * EmployeeVO构造函数
     */
    public EmployeeVO() {
        super();
    } 
   
	 /**
     * EmployeeVO完整的构造函数
     */  
    public EmployeeVO(String id){
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
     * 部门ID的get方法
     * @return depId
     */
    public String getDepId(){
        return depId;
    }
    /**
     * 部门ID的set方法
     * @param depId
     */
    public void setDepId(String depId){
		this.depId = depId;
	} 
    /**
     * 员工姓名的get方法
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * 员工姓名的set方法
     * @param name
     */
    public void setName(String name){
		this.name = name;
	} 
    /**
     * 员工编号的get方法
     * @return num
     */
    public String getNum(){
        return num;
    }
    /**
     * 员工编号的set方法
     * @param num
     */
    public void setNum(String num){
		this.num = num;
	} 
    /**
     * 年龄的get方法
     * @return age
     */
    public String getAge(){
        return age;
    }
    /**
     * 年龄的set方法
     * @param age
     */
    public void setAge(String age){
		this.age = age;
	} 
    /**
     * 性别的get方法
     * @return sex
     */
    public String getSex(){
        return sex;
    }
    /**
     * 性别的set方法
     * @param sex
     */
    public void setSex(String sex){
		this.sex = sex;
	} 
    /**
     * 地址的get方法
     * @return address
     */
    public String getAddress(){
        return address;
    }
    /**
     * 地址的set方法
     * @param address
     */
    public void setAddress(String address){
		this.address = address;
	} 
    /**
     * 电话的get方法
     * @return tel
     */
    public String getTel(){
        return tel;
    }
    /**
     * 电话的set方法
     * @param tel
     */
    public void setTel(String tel){
		this.tel = tel;
	} 
    /**
     * 入职时间的get方法
     * @return inductiontime
     */
    public String getInductiontime(){
        return inductiontime;
    }
    /**
     * 入职时间的set方法
     * @param inductiontime
     */
    public void setInductiontime(String inductiontime){
		this.inductiontime = inductiontime;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("id"+":"+getId())
				.append("depid"+":"+getDepId())
				.append("name"+":"+getName())
				.append("num"+":"+getNum())
				.append("age"+":"+getAge())
				.append("sex"+":"+getSex())
				.append("address"+":"+getAddress())
				.append("tel"+":"+getTel())
				.append("inductiontime"+":"+getInductiontime())
		        .toString(); 
			
    } 
   


}
