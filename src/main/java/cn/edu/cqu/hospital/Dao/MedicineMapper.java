package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Medicine;

public interface MedicineMapper {
    int deleteByPrimaryKey(String id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
}