package ListeEmployes;

import javafx.scene.control.Button;

public class Employe {
	private Integer employeId;
	private String services;
	private String employeNom;
	private String employePrenom;
	private int employeAge;
	private String employeGenre;
	private String employeVille;
	private int employeNumero;
	private Button action;
	
	public Employe(Integer employeId, String services, String employeNom, String employePrenom, int employeAge,
			String employeGenre, String employeVille, int employeNumero) {
		super();
		this.employeId = employeId;
		this.services = services;
		this.employeNom = employeNom;
		this.employePrenom = employePrenom;
		this.employeAge = employeAge;
		this.employeGenre = employeGenre;
		this.employeVille = employeVille;
		this.employeNumero = employeNumero;
	}
	public Employe() {
	
	}
	public Integer getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Integer employeId) {
		this.employeId = employeId;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getEmployeNom() {
		return employeNom;
	}

	public void setEmployeNom(String employeNom) {
		this.employeNom = employeNom;
	}

	public String getEmployePrenom() {
		return employePrenom;
	}

	public void setEmployePrenom(String employePrenom) {
		this.employePrenom = employePrenom;
	}

	public int getEmployeAge() {
		return employeAge;
	}

	public void setEmployeAge(int employeAge) {
		this.employeAge = employeAge;
	}

	public String getEmployeGenre() {
		return employeGenre;
	}

	public void setEmployeGenre(String employeGenre) {
		this.employeGenre = employeGenre;
	}

	public String getEmployeVille() {
		return employeVille;
	}

	public void setEmployeVille(String employeVille) {
		this.employeVille = employeVille;
	}

	public int getEmployeNumero() {
		return employeNumero;
	}

	public void setEmployeNumero(int employeNumero) {
		this.employeNumero = employeNumero;
	}
	public Button getAction() {
		return action;
	}

	public void setAction(Button action) {
		this.action = action;
	}
}
