package Fenetre3;

import java.util.Date;

public class rReservation {
	
	private Integer ReservId;
	private String nom_clients;
	private Date reservationDateDebut;
	private Date reservationDateFin;
	private Date reservationDatePaye;

	
	public rReservation() {
		
	}


	public Integer getReservId() {
		return ReservId;
	}


	public void setReservId(Integer reservId) {
		ReservId = reservId;
	}


	public String getNom_clients() {
		return nom_clients;
	}


	public void setNom_clients(String nom_clients) {
		this.nom_clients = nom_clients;
	}


	public Date getReservationDateDebut() {
		return reservationDateDebut;
	}


	public void setReservationDateDebut(Date reservationDateDebut) {
		this.reservationDateDebut = reservationDateDebut;
	}


	public Date getReservationDateFin() {
		return reservationDateFin;
	}


	public void setReservationDateFin(Date reservationDateFin) {
		this.reservationDateFin = reservationDateFin;
	}


	public Date getReservationDatePaye() {
		return reservationDatePaye;
	}


	public void setReservationDatePaye(Date reservationDatePaye) {
		this.reservationDatePaye = reservationDatePaye;
	}
	
	
}
