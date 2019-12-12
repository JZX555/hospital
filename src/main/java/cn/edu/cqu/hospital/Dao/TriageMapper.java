package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Triage record);

    int insertSelective(Triage record);

    Triage selectByPrimaryKey(String id);
    
    Triage selectByQueueAndIndex(String q, Integer i);

    int updateByPrimaryKeySelective(Triage record);

    int updateByPrimaryKey(Triage record);
}