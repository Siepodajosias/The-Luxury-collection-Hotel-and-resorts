package com.cemedo.data;
// Generated 28 juin 2022 � 14:55:25 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Logistique generated by hbm2java
 */
@Entity
@Table(name = "logistique", catalog = "heroku_88ae11bd39df693")
public class Logistique implements java.io.Serializable {

	private Integer idLogistiques;
	private String nomLogistiques;
	private String prenomLogistiques;
	private String genreLogistiques;
	private String residenceLogistiques;
	private String emailLogistiques;
	private String telephoneLogistiques;
	private String passwordLogistiques;
	private String photoLogistique;

	public Logistique() {
	}

	public Logistique(String nomLogistiques, String prenomLogistiques, String genreLogistiques,
			String residenceLogistiques, String emailLogistiques, String telephoneLogistiques,
			String passwordLogistiques) {
		this.nomLogistiques = nomLogistiques;
		this.prenomLogistiques = prenomLogistiques;
		this.genreLogistiques = genreLogistiques;
		this.residenceLogistiques = residenceLogistiques;
		this.emailLogistiques = emailLogistiques;
		this.telephoneLogistiques = telephoneLogistiques;
		this.passwordLogistiques = passwordLogistiques;
	}

	public Logistique(String nomLogistiques, String prenomLogistiques, String genreLogistiques,
			String residenceLogistiques, String emailLogistiques, String telephoneLogistiques,
			String passwordLogistiques, String photoLogistique) {
		this.nomLogistiques = nomLogistiques;
		this.prenomLogistiques = prenomLogistiques;
		this.genreLogistiques = genreLogistiques;
		this.residenceLogistiques = residenceLogistiques;
		this.emailLogistiques = emailLogistiques;
		this.telephoneLogistiques = telephoneLogistiques;
		this.passwordLogistiques = passwordLogistiques;
		this.photoLogistique = photoLogistique;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_logistiques", unique = true, nullable = false)
	public Integer getIdLogistiques() {
		return this.idLogistiques;
	}

	public void setIdLogistiques(Integer idLogistiques) {
		this.idLogistiques = idLogistiques;
	}

	@Column(name = "nom_logistiques", nullable = false, length = 45)
	public String getNomLogistiques() {
		return this.nomLogistiques;
	}

	public void setNomLogistiques(String nomLogistiques) {
		this.nomLogistiques = nomLogistiques;
	}

	@Column(name = "prenom_logistiques", nullable = false, length = 45)
	public String getPrenomLogistiques() {
		return this.prenomLogistiques;
	}

	public void setPrenomLogistiques(String prenomLogistiques) {
		this.prenomLogistiques = prenomLogistiques;
	}

	@Column(name = "genre_logistiques", nullable = false, length = 45)
	public String getGenreLogistiques() {
		return this.genreLogistiques;
	}

	public void setGenreLogistiques(String genreLogistiques) {
		this.genreLogistiques = genreLogistiques;
	}

	@Column(name = "residence_logistiques", nullable = false, length = 45)
	public String getResidenceLogistiques() {
		return this.residenceLogistiques;
	}

	public void setResidenceLogistiques(String residenceLogistiques) {
		this.residenceLogistiques = residenceLogistiques;
	}

	@Column(name = "email_logistiques", nullable = false, length = 45)
	public String getEmailLogistiques() {
		return this.emailLogistiques;
	}

	public void setEmailLogistiques(String emailLogistiques) {
		this.emailLogistiques = emailLogistiques;
	}

	@Column(name = "telephone_logistiques", nullable = false, length = 45)
	public String getTelephoneLogistiques() {
		return this.telephoneLogistiques;
	}

	public void setTelephoneLogistiques(String telephoneLogistiques) {
		this.telephoneLogistiques = telephoneLogistiques;
	}

	@Column(name = "password_logistiques", nullable = false, length = 45)
	public String getPasswordLogistiques() {
		return this.passwordLogistiques;
	}

	public void setPasswordLogistiques(String passwordLogistiques) {
		this.passwordLogistiques = passwordLogistiques;
	}

	@Column(name = "photo_logistique", length = 45)
	public String getPhotoLogistique() {
		return this.photoLogistique;
	}

	public void setPhotoLogistique(String photoLogistique) {
		this.photoLogistique = photoLogistique;
	}

}