package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Payment;

public interface PaymentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String id);
    
    List<Payment> selectByPatientKey(String id);
    
    List<Payment> selectByDate(String date);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}