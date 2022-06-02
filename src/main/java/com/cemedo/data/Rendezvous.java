package  com.cemedo.data;
// Generated 1 juin 2022 � 14:01:29 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rendezvous generated by hbm2java
 */
@Entity
@Table(name = "rendezvous", catalog = "heroku_88ae11bd39df693")
public class Rendezvous implements java.io.Serializable {

	private Integer idRendezVous;
	private Medecin medecin;
	private Patient patient;
	private Reception reception;
	private String lieuRendezVous;
	private float latitudeRendezVous;
	private float longitudeRendezVous;
	private String commentaireRendezVous;
	private Date dateRendezVous;
	private String typeRendezVous;

	public Rendezvous() {
	}

	public Rendezvous(Patient patient, String lieuRendezVous, float latitudeRendezVous, float longitudeRendezVous,
			Date dateRendezVous) {
		this.patient = patient;
		this.lieuRendezVous = lieuRendezVous;
		this.latitudeRendezVous = latitudeRendezVous;
		this.longitudeRendezVous = longitudeRendezVous;
		this.dateRendezVous = dateRendezVous;
	}

	public Rendezvous(Medecin medecin, Patient patient, Reception reception, String lieuRendezVous,
			float latitudeRendezVous, float longitudeRendezVous, String commentaireRendezVous, Date dateRendezVous,
			String typeRendezVous) {
		this.medecin = medecin;
		this.patient = patient;
		this.reception = reception;
		this.lieuRendezVous = lieuRendezVous;
		this.latitudeRendezVous = latitudeRendezVous;
		this.longitudeRendezVous = longitudeRendezVous;
		this.commentaireRendezVous = commentaireRendezVous;
		this.dateRendezVous = dateRendezVous;
		this.typeRendezVous = typeRendezVous;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id_rendezVous", unique = true, nullable = false)
	public Integer getIdRendezVous() {
		return this.idRendezVous;
	}

	public void setIdRendezVous(Integer idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Medecins_id_Medecins")
	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Patients_id_Patients", nullable = false)
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Receptions_id_reception")
	public Reception getReception() {
		return this.reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	@Column(name = "lieu_rendezVous", nullable = false, length = 45)
	public String getLieuRendezVous() {
		return this.lieuRendezVous;
	}

	public void setLieuRendezVous(String lieuRendezVous) {
		this.lieuRendezVous = lieuRendezVous;
	}

	@Column(name = "latitude_rendezVous", nullable = false, precision = 12, scale = 0)
	public float getLatitudeRendezVous() {
		return this.latitudeRendezVous;
	}

	public void setLatitudeRendezVous(float latitudeRendezVous) {
		this.latitudeRendezVous = latitudeRendezVous;
	}

	@Column(name = "longitude_rendezVous", nullable = false, precision = 12, scale = 0)
	public float getLongitudeRendezVous() {
		return this.longitudeRendezVous;
	}

	public void setLongitudeRendezVous(float longitudeRendezVous) {
		this.longitudeRendezVous = longitudeRendezVous;
	}

	@Column(name = "commentaire_rendezVous", length = 45)
	public String getCommentaireRendezVous() {
		return this.commentaireRendezVous;
	}

	public void setCommentaireRendezVous(String commentaireRendezVous) {
		this.commentaireRendezVous = commentaireRendezVous;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_rendezVous", nullable = false, length = 10)
	public Date getDateRendezVous() {
		return this.dateRendezVous;
	}

	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	@Column(name = "Type_RendezVous", length = 45)
	public String getTypeRendezVous() {
		return this.typeRendezVous;
	}

	public void setTypeRendezVous(String typeRendezVous) {
		this.typeRendezVous = typeRendezVous;
	}

}
