package Facture;

import java.util.Date;

import javafx.scene.control.Button;

public class Facture {
	
	private Integer factureId;
	private int idreservations;
	private String idreser_client;
	private double factureMontant;
	private Date factureDate;
	private Button action;
	
	public Facture() {
		
	}
	
	public Facture(Integer factureId, int idreservations, String idreser_client, double factureMontant,
			Date factureDate) {
		super();
		this.factureId = factureId;
		this.idreservations = idreservations;
		this.idreser_client = idreser_client;
		this.factureMontant = factureMontant;
		this.factureDate = factureDate;
	}


	public Integer getFactureId() {
		return factureId;
	}
	public void setFactureId(Integer factureId) {
		this.factureId = factureId;
	}
	public int getIdreservations() {
		return idreservations;
	}
	public void setIdreservations(int idreservations) {
		this.idreservations = idreservations;
	}
	public String getIdreser_client() {
		return idreser_client;
	}
	public void setIdreser_client(String idreser_client) {
		this.idreser_client = idreser_client;
	}
	public double getFactureMontant() {
		return factureMontant;
	}
	public void setFactureMontant(double factureMontant) {
		this.factureMontant = factureMontant;
	}
	public Date getFactureDate() {
		return factureDate;
	}
	public void setFactureDate(Date factureDate) {
		this.factureDate = factureDate;
	}
	
	public Button getAction() {
		return action;
	}

	public void setAction(Button action) {
		this.action = action;
	}
	
}
