package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
}