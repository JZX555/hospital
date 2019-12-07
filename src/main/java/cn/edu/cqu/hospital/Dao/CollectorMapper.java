package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Collector;

public interface CollectorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Collector record);

    int insertSelective(Collector record);

    Collector selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Collector record);

    int updateByPrimaryKey(Collector record);
}