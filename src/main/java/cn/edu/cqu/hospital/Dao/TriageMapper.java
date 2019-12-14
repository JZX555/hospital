package cn.edu.cqu.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Triage record);

    int insertSelective(Triage record);

    Triage selectByPrimaryKey(String id);
    
    Triage selectByQueueAndIndex(@Param("q")String q, @Param("i")Integer i);
    
    List<Triage> selectByPatientKey(String id);

    int updateByPrimaryKeySelective(Triage record);

    int updateByPrimaryKey(Triage record);
}