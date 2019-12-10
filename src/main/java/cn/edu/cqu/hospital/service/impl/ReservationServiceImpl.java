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

	public void updateStateByID(String ID, int state) {
		Reservation reservation = this.reservationDao.selectByPrimaryKey(ID);
		reservation.setState(state);
		
		this.reservationDao.updateByPrimaryKeySelective(reservation);
	}

	public void createReservation(Reservation r) {
		this.reservationDao.insertSelective(r);
	}

	public void updateReservation(Reservation r) {
		this.reservationDao.updateByPrimaryKeySelective(r);
	}

	public void deleteReservation(String ID) {
		this.deleteReservation(ID);
	}

}
