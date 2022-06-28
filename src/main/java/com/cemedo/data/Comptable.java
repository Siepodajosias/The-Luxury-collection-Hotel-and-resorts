package com.cemedo.data;
// Generated 28 juin 2022 � 14:55:25 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comptable generated by hbm2java
 */
@Entity
@Table(name = "comptable", catalog = "heroku_88ae11bd39df693")
public class Comptable implements java.io.Serializable {

	private Integer idComptables;
	private String nomComptable;
	private String prenomComptable;
	private String genreComptable;
	private String residenceComptable;
	private String emailComptable;
	private int telephoneComptable;
	private String passwordComptable;
	private int numeroCniComptable;
	private String photoComptable;
	private Double salaireComptable;
	private Double primeComptables;

	public Comptable() {
	}

	public Comptable(String nomComptable, String prenomComptable, String genreComptable, String residenceComptable,
			String emailComptable, int telephoneComptable, String passwordComptable, int numeroCniComptable) {
		this.nomComptable = nomComptable;
		this.prenomComptable = prenomComptable;
		this.genreComptable = genreComptable;
		this.residenceComptable = residenceComptable;
		this.emailComptable = emailComptable;
		this.telephoneComptable = telephoneComptable;
		this.passwordComptable = passwordComptable;
		this.numeroCniComptable = numeroCniComptable;
	}

	public Comptable(String nomComptable, String prenomComptable, String genreComptable, String residenceComptable,
			String emailComptable, int telephoneComptable, String passwordComptable, int numeroCniComptable,
			String photoComptable, Double salaireComptable, Double primeComptables) {
		this.nomComptable = nomComptable;
		this.prenomComptable = prenomComptable;
		this.genreComptable = genreComptable;
		this.residenceComptable = residenceComptable;
		this.emailComptable = emailComptable;
		this.telephoneComptable = telephoneComptable;
		this.passwordComptable = passwordComptable;
		this.numeroCniComptable = numeroCniComptable;
		this.photoComptable = photoComptable;
		this.salaireComptable = salaireComptable;
		this.primeComptables = primeComptables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_comptables", unique = true, nullable = false)
	public Integer getIdComptables() {
		return this.idComptables;
	}

	public void setIdComptables(Integer idComptables) {
		this.idComptables = idComptables;
	}

	@Column(name = "nom_comptable", nullable = false, length = 45)
	public String getNomComptable() {
		return this.nomComptable;
	}

	public void setNomComptable(String nomComptable) {
		this.nomComptable = nomComptable;
	}

	@Column(name = "prenom_comptable", nullable = false, length = 45)
	public String getPrenomComptable() {
		return this.prenomComptable;
	}

	public void setPrenomComptable(String prenomComptable) {
		this.prenomComptable = prenomComptable;
	}

	@Column(name = "genre_comptable", nullable = false, length = 45)
	public String getGenreComptable() {
		return this.genreComptable;
	}

	public void setGenreComptable(String genreComptable) {
		this.genreComptable = genreComptable;
	}

	@Column(name = "residence_comptable", nullable = false, length = 45)
	public String getResidenceComptable() {
		return this.residenceComptable;
	}

	public void setResidenceComptable(String residenceComptable) {
		this.residenceComptable = residenceComptable;
	}

	@Column(name = "email_comptable", nullable = false, length = 45)
	public String getEmailComptable() {
		return this.emailComptable;
	}

	public void setEmailComptable(String emailComptable) {
		this.emailComptable = emailComptable;
	}

	@Column(name = "telephone_comptable", nullable = false)
	public int getTelephoneComptable() {
		return this.telephoneComptable;
	}

	public void setTelephoneComptable(int telephoneComptable) {
		this.telephoneComptable = telephoneComptable;
	}

	@Column(name = "password_comptable", nullable = false, length = 45)
	public String getPasswordComptable() {
		return this.passwordComptable;
	}

	public void setPasswordComptable(String passwordComptable) {
		this.passwordComptable = passwordComptable;
	}

	@Column(name = "numero_CNI_comptable", nullable = false)
	public int getNumeroCniComptable() {
		return this.numeroCniComptable;
	}

	public void setNumeroCniComptable(int numeroCniComptable) {
		this.numeroCniComptable = numeroCniComptable;
	}

	@Column(name = "photo_comptable", length = 45)
	public String getPhotoComptable() {
		return this.photoComptable;
	}

	public void setPhotoComptable(String photoComptable) {
		this.photoComptable = photoComptable;
	}

	@Column(name = "salaire_comptable", precision = 22, scale = 0)
	public Double getSalaireComptable() {
		return this.salaireComptable;
	}

	public void setSalaireComptable(Double salaireComptable) {
		this.salaireComptable = salaireComptable;
	}

	@Column(name = "prime_comptables", precision = 22, scale = 0)
	public Double getPrimeComptables() {
		return this.primeComptables;
	}

	public void setPrimeComptables(Double primeComptables) {
		this.primeComptables = primeComptables;
	}

}
