package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(String id);
    
    List<Prescription> selectByPatientKey(String id);
    
    List<Prescription> selectByRecordKey(String id);
    
    List<Prescription> selectAllByDispenser();
    
    List<Prescription> selectAllByChemist();
                 
    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}