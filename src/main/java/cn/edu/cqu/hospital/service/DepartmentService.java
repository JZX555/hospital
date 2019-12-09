package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Department;

public interface DepartmentService {
	public Department getDepartmentByID(String ID);
	
	public void updateDepartment(Department d);
}
