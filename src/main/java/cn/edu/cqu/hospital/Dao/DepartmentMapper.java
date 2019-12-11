package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);
    
    List<Department> selectAllDepartments();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}