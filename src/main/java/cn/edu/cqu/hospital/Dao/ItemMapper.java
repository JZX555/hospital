package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(String id);
    
    List<Item> selectAllItems();

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}