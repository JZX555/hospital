package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Reservation;

public interface ReservationService {
	public Reservation getReservationByID(String ID);
	public Reservation[] getReservationsByPatient(String ID);
	
	public void updateStateByID(String ID, int state);
	
	public void createReservation(Reservation r);
	public void updateReservation(Reservation r);
	public void deleteReservation(String ID);
}
