package cn.edu.cqu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.DepartmentMapper;
import cn.edu.cqu.hospital.pojo.Department;
import cn.edu.cqu.hospital.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentDao;
	
	public Department getDepartmentByID(String ID) {
		return this.departmentDao.selectByPrimaryKey(ID);
	}
	
	public List<Department> getAllDepartments() {
		return this.departmentDao.selectAllDepartments();
	}

	public Integer updateDepartment(Department d) {
		return this.departmentDao.updateByPrimaryKeySelective(d);
	}

}
