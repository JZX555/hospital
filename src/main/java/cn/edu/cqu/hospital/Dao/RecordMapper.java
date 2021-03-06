package cn.edu.cqu.hospital.Dao;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;

public interface RecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(RecordWithBLOBs record);

    int insertSelective(RecordWithBLOBs record);

    RecordWithBLOBs selectByPrimaryKey(String id);
    List<RecordWithBLOBs> selectByPatientKey(String id);
    List<RecordWithBLOBs> selectByDoctorKey(String id);

    int updateByPrimaryKeySelective(RecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

    int updateByPrimaryKey(Record record);
}