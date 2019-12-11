package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Department;

public interface DepartmentService {
	public Department getDepartmentByID(String ID);
	public List<Department> getAllDepartments();
	
	public Integer updateDepartment(Department d);
}
