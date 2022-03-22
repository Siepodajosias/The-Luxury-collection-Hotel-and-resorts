package Base_Donnee;
// Generated 4 mars 2022 � 18:08:38 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clients generated by hbm2java
 */
//heroku_88ae11bd39df693
@Entity
@Table(name = "clients", catalog = "heroku_88ae11bd39df693")
public class Clients implements java.io.Serializable {

	private Integer iclientId;
	private String clientNom;
	private String clientPrenom;
	private int clientAge;
	private int clientNumero;
	private String clientVille;
	private String clientProfession;
	private Set<Reservations> reservationses = new HashSet<Reservations>(0);
	private Set<Occupation> occupations = new HashSet<Occupation>(0);

	public Clients() {
	}

	public Clients(String clientNom, String clientPrenom, int clientAge, int clientNumero, String clientVille,
			String clientProfession) {
		this.clientNom = clientNom;
		this.clientPrenom = clientPrenom;
		this.clientAge = clientAge;
		this.clientNumero = clientNumero;
		this.clientVille = clientVille;
		this.clientProfession = clientProfession;
	}

	public Clients(String clientNom, String clientPrenom, int clientAge, int clientNumero, String clientVille,
			String clientProfession, Set<Reservations> reservationses, Set<Occupation> occupations) {
		this.clientNom = clientNom;
		this.clientPrenom = clientPrenom;
		this.clientAge = clientAge;
		this.clientNumero = clientNumero;
		this.clientVille = clientVille;
		this.clientProfession = clientProfession;
		this.reservationses = reservationses;
		this.occupations = occupations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iClient_Id", unique = true, nullable = false)
	public Integer getIclientId() {
		return this.iclientId;
	}

	public void setIclientId(Integer iclientId) {
		this.iclientId = iclientId;
	}

	@Column(name = "Client_Nom", nullable = false, length = 30)
	public String getClientNom() {
		return this.clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	@Column(name = "Client_Prenom", nullable = false, length = 30)
	public String getClientPrenom() {
		return this.clientPrenom;
	}

	public void setClientPrenom(String clientPrenom) {
		this.clientPrenom = clientPrenom;
	}

	@Column(name = "Client_age", nullable = false)
	public int getClientAge() {
		return this.clientAge;
	}

	public void setClientAge(int clientAge) {
		this.clientAge = clientAge;
	}

	@Column(name = "Client_Numero", nullable = false)
	public int getClientNumero() {
		return this.clientNumero;
	}

	public void setClientNumero(int clientNumero) {
		this.clientNumero = clientNumero;
	}

	@Column(name = "Client_Ville", nullable = false, length = 30)
	public String getClientVille() {
		return this.clientVille;
	}

	public void setClientVille(String clientVille) {
		this.clientVille = clientVille;
	}

	@Column(name = "Client_Profession", nullable = false, length = 30)
	public String getClientProfession() {
		return this.clientProfession;
	}

	public void setClientProfession(String clientProfession) {
		this.clientProfession = clientProfession;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clients")
	public Set<Reservations> getReservationses() {
		return this.reservationses;
	}

	public void setReservationses(Set<Reservations> reservationses) {
		this.reservationses = reservationses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clients")
	public Set<Occupation> getOccupations() {
		return this.occupations;
	}

	public void setOccupations(Set<Occupation> occupations) {
		this.occupations = occupations;
	}

}
