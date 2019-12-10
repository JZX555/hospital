package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Refund;

public interface RefundMapper {
    int deleteByPrimaryKey(String id);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(String id);
    
    Refund[] selecctByPatientKey(String id);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}