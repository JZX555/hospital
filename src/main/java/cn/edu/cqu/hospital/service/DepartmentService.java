package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Department;

public interface DepartmentService {
	public Department getDepartmentByID(String ID);
	public Department[] getAllDepartments();
	
	public Integer updateDepartment(Department d);
}
