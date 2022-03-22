package Base_Donnee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//heroku_88ae11bd39df693
@Entity
@Table(name = "authentification", catalog = "heroku_88ae11bd39df693")
public class Authentification {
	private String nomUtilisateur;
	private String profession;
	private String modePwd;
	
	public Authentification() {
	}

	public Authentification(String nomUtilisateur, String profession, String modePwd) {
		this.nomUtilisateur = nomUtilisateur;
		this.profession = profession;
		this.modePwd = modePwd;
	}
	
	@Id
	@Column(name = "Mode_Pwd", nullable = false, length = 45)
	public String getModePwd() {
		return this.modePwd;
	}
	
	@Column(name = "Nom_Utilisateur", nullable = false, length = 30)
	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	@Column(name = "Profession", nullable = false, length = 45)
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setModePwd(String modePwd) {
		this.modePwd = modePwd;
	}

}
