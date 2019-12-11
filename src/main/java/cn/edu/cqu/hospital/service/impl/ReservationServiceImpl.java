package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.ReservationMapper;
import cn.edu.cqu.hospital.pojo.Reservation;
import cn.edu.cqu.hospital.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationMapper reservationDao;
	
	public Reservation getReservationByID(String ID) {
		return this.reservationDao.selectByPrimaryKey(ID);
	}

	public Reservation[] getReservationsByPatient(String ID) {
		return this.reservationDao.selectByPatientKey(ID);
	}

	public Integer updateStateByID(String ID, int state) {
		Reservation reservation = this.reservationDao.selectByPrimaryKey(ID);
		reservation.setState(state);
		
		return this.reservationDao.updateByPrimaryKeySelective(reservation);
	}

	public Integer createReservation(Reservation r) {
		return this.reservationDao.insertSelective(r);
	}

	public Integer updateReservation(Reservation r) {
		return this.reservationDao.updateByPrimaryKeySelective(r);
	}

	public Integer deleteReservation(String ID) {
		return this.deleteReservation(ID);
	}

}
