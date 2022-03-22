package Vreservation;

import java.util.Date;

import javafx.scene.control.Button;

public class reservation {
	private Integer reservationId;
	private String chambres;
	private String nom_clients;
	private String prenom_clients;
	private String services;
	private Date reservationDateDebut;
	private Date reservationDateFin;
	private Date reservationDatePaye;
	private Button actionF;
	
	public reservation(Integer reservationId, String chambres, String nom_clients, String prenom_clients,
			String services, Date reservationDateDebut, Date reservationDateFin, Date reservationDatePaye) {
		super();
		this.reservationId = reservationId;
		this.chambres = chambres;
		this.nom_clients = nom_clients;
		this.prenom_clients = prenom_clients;
		this.services = services;
		this.reservationDateDebut = reservationDateDebut;
		this.reservationDateFin = reservationDateFin;
		this.reservationDatePaye = reservationDatePaye;
	}
	
	public reservation() {
		
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String getChambres() {
		return chambres;
	}

	public void setChambres(String chambres) {
		this.chambres = chambres;
	}

	public String getNom_clients() {
		return nom_clients;
	}

	public void setNom_clients(String nom_clients) {
		this.nom_clients = nom_clients;
	}

	public String getPrenom_clients() {
		return prenom_clients;
	}

	public void setPrenom_clients(String prenom_clients) {
		this.prenom_clients = prenom_clients;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
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

	public Button getActionF() {
		return actionF;
	}

	public void setActionF(Button actionF) {
		this.actionF = actionF;
	}

}
