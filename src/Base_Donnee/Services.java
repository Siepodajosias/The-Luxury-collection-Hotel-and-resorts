package Base_Donnee;
// Generated 4 mars 2022 ? 18:08:38 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Services generated by hbm2java
 */
//heroku_88ae11bd39df693
@Entity
@Table(name = "services", catalog = "heroku_88ae11bd39df693")
public class Services implements java.io.Serializable {

	private Integer servicesId;
	private String serviceDescription;
	private Date serviceHeureDebut;
	private Date serviceHeureFin;
	private Set<Chambres> chambreses = new HashSet<Chambres>(0);
	private Set<Reservations> reservationses = new HashSet<Reservations>(0);
	private Set<Employes> employeses = new HashSet<Employes>(0);

	public Services() {
	}

	public Services(String serviceDescription, Date serviceHeureDebut, Date serviceHeureFin) {
		this.serviceDescription = serviceDescription;
		this.serviceHeureDebut = serviceHeureDebut;
		this.serviceHeureFin = serviceHeureFin;
	}

	public Services(String serviceDescription, Date serviceHeureDebut, Date serviceHeureFin, Set<Chambres> chambreses,
			Set<Reservations> reservationses, Set<Employes> employeses) {
		this.serviceDescription = serviceDescription;
		this.serviceHeureDebut = serviceHeureDebut;
		this.serviceHeureFin = serviceHeureFin;
		this.chambreses = chambreses;
		this.reservationses = reservationses;
		this.employeses = employeses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Services_Id", unique = true, nullable = false)
	public Integer getServicesId() {
		return this.servicesId;
	}

	public void setServicesId(Integer servicesId) {
		this.servicesId = servicesId;
	}

	@Column(name = "Service_Description", nullable = false, length = 45)
	public String getServiceDescription() {
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Service_Heure_Debut", nullable = false, length = 10)
	public Date getServiceHeureDebut() {
		return this.serviceHeureDebut;
	}

	public void setServiceHeureDebut(Date serviceHeureDebut) {
		this.serviceHeureDebut = serviceHeureDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Service_Heure_Fin", nullable = false, length = 10)
	public Date getServiceHeureFin() {
		return this.serviceHeureFin;
	}

	public void setServiceHeureFin(Date serviceHeureFin) {
		this.serviceHeureFin = serviceHeureFin;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "avoir", catalog = "heroku_88ae11bd39df693", joinColumns = {
			@JoinColumn(name = "id_Service", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_Chambre", nullable = false, updatable = false) })
	public Set<Chambres> getChambreses() {
		return this.chambreses;
	}

	public void setChambreses(Set<Chambres> chambreses) {
		this.chambreses = chambreses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "services")
	public Set<Reservations> getReservationses() {
		return this.reservationses;
	}

	public void setReservationses(Set<Reservations> reservationses) {
		this.reservationses = reservationses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "services")
	public Set<Employes> getEmployeses() {
		return this.employeses;
	}

	public void setEmployeses(Set<Employes> employeses) {
		this.employeses = employeses;
	}

}
