package com.infosys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer employeeId;
    String employeeName;
    String empAddr;
    
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", empAddr=" + empAddr + "]";
	}

	public Employee(String employeeName, String empAddr) {
		super();
		this.employeeName = employeeName;
		this.empAddr = empAddr;
	}

	public Employee(Integer employeeId, String employeeName, String empAddr) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.empAddr = empAddr;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
