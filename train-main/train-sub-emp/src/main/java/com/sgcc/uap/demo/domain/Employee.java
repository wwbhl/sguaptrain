package com.sgcc.uap.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Employee的POJO类
 *
 * @author administrator 
 * @date 2019-03-21 11:26:33
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

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
    @Column(name = "id", nullable = false, length = 50)
    private String id ;
    
    /** 
     * 部门ID
     */
    @Column(name = "depid", nullable = true, length = 50)
    private String depId ;
    
    /** 
     * 员工姓名
     */
    @Column(name = "name", nullable = true, length = 50)
    private String name ;
    
    /** 
     * 员工编号
     */
    @Column(name = "num", nullable = true, length = 50)
    private String num ;
    
    /** 
     * 年龄
     */
    @Column(name = "age", nullable = true, length = 10)
    private String age ;
    
    /** 
     * 性别
     */
    @Column(name = "sex", nullable = true, length = 10)
    private String sex ;
    
    /** 
     * 地址
     */
    @Column(name = "address", nullable = true, length = 255)
    private String address ;
    
    /** 
     * 电话
     */
    @Column(name = "tel", nullable = true, length = 50)
    private String tel ;
    
    /** 
     * 入职时间
     */
    @Column(name = "inductiontime", nullable = true, length = 50)
    private String inductiontime ;
    
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
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof Employee))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (depId == null) {
			if (other.depId != null) {
				return false;
			}
		} else if (!depId.equals(other.depId)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (num == null) {
			if (other.num != null) {
				return false;
			}
		} else if (!num.equals(other.num)) {
			return false;
		}
		if (age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!age.equals(other.age)) {
			return false;
		}
		if (sex == null) {
			if (other.sex != null) {
				return false;
			}
		} else if (!sex.equals(other.sex)) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (tel == null) {
			if (other.tel != null) {
				return false;
			}
		} else if (!tel.equals(other.tel)) {
			return false;
		}
		if (inductiontime == null) {
			if (other.inductiontime != null) {
				return false;
			}
		} else if (!inductiontime.equals(other.inductiontime)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "Employee ["
			+ ", id=" + id
			+ ", depId=" + depId
			+ ", name=" + name
			+ ", num=" + num
			+ ", age=" + age
			+ ", sex=" + sex
			+ ", address=" + address
			+ ", tel=" + tel
			+ ", inductiontime=" + inductiontime;
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