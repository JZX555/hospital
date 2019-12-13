package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Medicine;

public interface MedicineMapper {
    int deleteByPrimaryKey(String id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(String id);
    
    List<Medicine> selectAllMedicines();

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
}