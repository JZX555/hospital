package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Requisition;

public interface RequisitionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Requisition record);

    int insertSelective(Requisition record);

    Requisition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Requisition record);

    int updateByPrimaryKey(Requisition record);
}