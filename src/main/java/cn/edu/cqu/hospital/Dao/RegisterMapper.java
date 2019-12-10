package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String id);
    
    Register[] selectByPatientKey(String id);
    
    Register[] selectByDoctorKey(String id);
    
    Register[] selectByCollectorKey(String id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}