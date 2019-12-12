package cn.edu.cqu.hospital.Dao;

import org.apache.ibatis.annotations.Param;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Triage record);

    int insertSelective(Triage record);

    Triage selectByPrimaryKey(String id);
    
    Triage selectByQueueAndIndex(@Param("q")String q, @Param("i")Integer i);

    int updateByPrimaryKeySelective(Triage record);

    int updateByPrimaryKey(Triage record);
}