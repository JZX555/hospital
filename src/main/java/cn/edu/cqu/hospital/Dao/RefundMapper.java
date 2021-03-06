package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Refund;

public interface RefundMapper {
    int deleteByPrimaryKey(String id);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(String id);
    
    List<Refund> selecctByPatientKey(String id);

    List<Refund> selectByDate(String date);
    
    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}