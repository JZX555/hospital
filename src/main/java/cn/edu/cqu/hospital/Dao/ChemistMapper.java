package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Chemist;

public interface ChemistMapper {
    int deleteByPrimaryKey(String id);

    int insert(Chemist record);

    int insertSelective(Chemist record);

    Chemist selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Chemist record);

    int updateByPrimaryKey(Chemist record);
}