package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Requisition;

public interface RequisitionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Requisition record);

    int insertSelective(Requisition record);

    Requisition selectByPrimaryKey(String id);
    
    List<Requisition> selectByPatientKey(String id);
    
    List<Requisition> selectByRecordKey(String id);

    int updateByPrimaryKeySelective(Requisition record);

    int updateByPrimaryKey(Requisition record);
}