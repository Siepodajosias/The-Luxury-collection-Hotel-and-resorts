package VCHdisponible;

import java.util.HashSet;
import java.util.Set;

import Base_Donnee.Occupation;
import Base_Donnee.Reservations;
import Base_Donnee.Services;
import javafx.scene.control.Button;

public class Chambre {
	private int chambreNumero;
	private int chambreTelephone;
	private String chambreDescription;
	private double chambrePrix;
	private Button reservationses;
	private Button occupations;
	private Button serviceses;
	private Button action;
	private Set<Occupation> fr1= new HashSet<Occupation>(0);
	private Set<Reservations> reservation2 = new HashSet<Reservations>(0);
	private Set<Services> servicese2 = new HashSet<Services>(0);

	
	public  Chambre() {
	}
	
	public Chambre(int chambreNumero, int chambreTelephone, String chambreDescription, double chambrePrix,
			Button reservationses, Button occupations, Button serviceses) {
		super();
		this.chambreNumero = chambreNumero;
		this.chambreTelephone = chambreTelephone;
		this.chambreDescription = chambreDescription;
		this.chambrePrix = chambrePrix;
		this.reservationses = reservationses;
		this.occupations = occupations;
		this.serviceses = serviceses;
	}

	public int getChambreNumero() {
		return chambreNumero;
	}
	public void setChambreNumero(int chambreNumero) {
		this.chambreNumero = chambreNumero;
	}
	public int getChambreTelephone() {
		return chambreTelephone;
	}
	public void setChambreTelephone(int chambreTelephone) {
		this.chambreTelephone = chambreTelephone;
	}
	public String getChambreDescription() {
		return chambreDescription;
	}
	public void setChambreDescription(String chambreDescription) {
		this.chambreDescription = chambreDescription;
	}
	public double getChambrePrix() {
		return chambrePrix;
	}
	public void setChambrePrix(double chambrePrix) {
		this.chambrePrix = chambrePrix;
	}
	public Button getReservationses() {
		return reservationses;
	}
	public void setReservationses(Button reservationses) {
		this.reservationses = reservationses;
	}
	public Button getOccupations() {
		return occupations;
	}
	public void setOccupations(Button occupations) {
		this.occupations = occupations;
	}
	public Button getServiceses() {
		return serviceses;
	}
	public void setServiceses(Button serviceses) {
		this.serviceses = serviceses;
	}

	public Button getAction() {
		return action;
	}

	public void setAction(Button action) {
		this.action = action;
	}

	public Set<Occupation> getFr1() {
		return fr1;
	}

	public void setFr1(Set<Occupation> fr1) {
		this.fr1 = fr1;
	}

	public Set<Services> getServicese2() {
		return servicese2;
	}

	public void setServicese2(Set<Services> servicese2) {
		this.servicese2 = servicese2;
	}

	public Set<Reservations> getReservation2() {
		return reservation2;
	}

	public void setReservation2(Set<Reservations> reservation2) {
		this.reservation2 = reservation2;
	}

}
