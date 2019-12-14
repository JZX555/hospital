package cn.edu.cqu.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cqu.hospital.pojo.Reservation;

public interface ReservationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(String id);
    
    List<Reservation> selectByPatientKey(String id);
    
    List<Reservation> selectByPatientAndDate(@Param("id")String id, @Param("date")String date);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);
}