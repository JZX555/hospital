package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Queue;

public interface QueueMapper {
    int deleteByPrimaryKey(String id);

    int insert(Queue record);

    int insertSelective(Queue record);

    Queue selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Queue record);

    int updateByPrimaryKey(Queue record);
}