package com.devpro.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "employee_id", nullable = false)
	private Long employeeId;
	
	@Column(name = "employee_number", nullable = false)
	private String employeeNumber;
	
	@Column(name = "employee_name", nullable = false)
	private String employeeName;
	
	@Column(name = "birth")
	private String birth;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "employee_position")
	private String employeePosition;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "manager_id")
	private Long managerId;
	
	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;
	
	public Employee() {
		super();
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Employee(Long employeeId, String employeeNumber, String employeeName, String birth, String gender,
			String address, String employeePosition, String email, String phoneNumber, String salary, Long managerId,
			Section section) {
		super();
		this.employeeId = employeeId;
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.employeePosition = employeePosition;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.managerId = managerId;
		this.section = section;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeId=");
		builder.append(employeeId);
		builder.append(", employeeNumber=");
		builder.append(employeeNumber);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", address=");
		builder.append(address);
		builder.append(", employeePosition=");
		builder.append(employeePosition);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", section=");
		builder.append(section);
		builder.append("]");
		return builder.toString();
	}
	
}
