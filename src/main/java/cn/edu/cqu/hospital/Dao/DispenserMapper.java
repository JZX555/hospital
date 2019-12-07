package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Dispenser;

public interface DispenserMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dispenser record);

    int insertSelective(Dispenser record);

    Dispenser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dispenser record);

    int updateByPrimaryKey(Dispenser record);
}