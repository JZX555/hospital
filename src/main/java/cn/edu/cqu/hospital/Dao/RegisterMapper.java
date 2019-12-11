package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String id);
    
    List<Register> selectByPatientKey(String id);
    
    List<Register> selectByDoctorKey(String id);
    
    List<Register> selectByCollectorKey(String id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}