package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(String id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}