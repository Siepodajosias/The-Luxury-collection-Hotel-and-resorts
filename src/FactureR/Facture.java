package FactureR;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Base_Donnee.Factures;

public class Facture {
	
	private Integer factureId;
	private double factureMontant;
	private Date factureDate;
	private Set<Factures> factureses = new HashSet<Factures>(0);
	
	public Facture() {
		
	}
	
	public Facture(Integer factureId, double factureMontant,
			Date factureDate) {
		super();
		this.factureId = factureId;
		this.factureMontant = factureMontant;
		this.factureDate = factureDate;
	}


	public Integer getFactureId() {
		return factureId;
	}
	public void setFactureId(Integer factureId) {
		this.factureId = factureId;
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

	public Set<Factures> getFactureses() {
		return factureses;
	}

	public void setFactureses(Set<Factures> factureses) {
		this.factureses = factureses;
	}
	
	
}
