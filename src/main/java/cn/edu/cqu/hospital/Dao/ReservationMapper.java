package cn.edu.cqu.hospital.Dao;

import cn.edu.cqu.hospital.pojo.Reservation;

public interface ReservationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);
}