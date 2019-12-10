package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(String id);

    Prescription[] selectByPatientKey(String id);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}