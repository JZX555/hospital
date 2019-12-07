package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}