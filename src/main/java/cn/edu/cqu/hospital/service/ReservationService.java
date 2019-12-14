package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Reservation;

public interface ReservationService {
	public Reservation getReservationByID(String ID);
	public List<Reservation> getReservationsByPatient(String ID);
	public List<Reservation> getReservationsByPatientAndDate(String ID, String date);
	
	public Integer updateStateByID(String ID, int state);
	
	public Integer createReservation(Reservation r);
	public Integer updateReservation(Reservation r);
	public Integer deleteReservation(String ID);
}
