package AjouterEmployes;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Base_Donnee.Employes;
import Base_Donnee.Services;
import Service.ModelService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AjouterEmployeController implements Initializable{
	@FXML
	AnchorPane rootpaneAEmpl;
	@FXML
	JFXTextField nom;
	@FXML
    JFXTextField prenom;
	@FXML
	JFXTextField age;
	@FXML
	JFXTextField IDgenre;
	@FXML
	JFXTextField IDnumero;
	@FXML
	JFXTextField IDville;
	@FXML
	ComboBox<Integer> IDservices;
	@FXML
	JFXButton saveButton; 
	@FXML
	JFXButton IDannuler; 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ModelService service=new ModelService();
		for(Services iterable2 : service.getAll()){
			IDservices.getItems().addAll(FXCollections.observableArrayList(iterable2.getServicesId()));
		}
		
	}
	@FXML
	public void addEmpoye() {
		
		String nom1=nom.getText();
		String prenom1=prenom.getText();
		String genre1=IDgenre.getText();
		String ville1=IDville.getText();
		
		String age1=age.getText();
		String numero1=IDnumero.getText();
		
		
		if(nom1.isEmpty()||prenom1.isEmpty()||age1.isEmpty()||genre1.isEmpty()||numero1.isEmpty()||ville1.isEmpty()){
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Veillez Remplir Tout Les champs");
			alert.showAndWait();
			return;
		}else {
			
			if(validation1(genre1) && validation2(age.getText()) && validation2(IDnumero.getText())) {
				int service=IDservices.getValue();
				
				String nom2=nom.getText();
				String prenom2=prenom.getText();
				int age2=Integer.parseInt(age.getText());
				String genre2=IDgenre.getText();
				int numero2=Integer.parseInt(IDnumero.getText());
				String ville2=IDville.getText();
				
				Employes employe  =new Employes();
				AjouterEDAO mdemploye=new AjouterEDAO();
				ModelService ser=new ModelService();
				employe.setEmployeNom(nom2);
				employe.setEmployePrenom(prenom2);
				employe.setEmployeAge(age2);
				employe.setEmployeGenre(genre2);
				employe.setEmployeNumero(numero2);
				employe.setEmployeVille(ville2);
			    employe.setServices(ser.getAllById(service));

			if(	mdemploye.postAll(employe)) {
				
				nom.setText("");
				prenom.setText("");
				age.setText("");
				IDgenre.setText("");
				IDnumero.setText("");
				IDville.setText("");

				Alert alert=new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Employé enregistré ");
				alert.showAndWait();
				
				} 

			}else{

				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Erreur: utilisé les lettres pour les champs nom,prenom,genre,ville et les chiffres pour les autres champs ");
				alert.showAndWait();
			}
		}	
		
	}
	
	@FXML
	public void OnAnnuler() {
		Stage stage=(Stage)rootpaneAEmpl.getScene().getWindow();
		stage.close();
	}
	
    public boolean validation1(String a) {
    	String caracter="^[a-zA-Z]+[a-z-A-z]{1,25}$";
    	return a.matches(caracter);
    }
    public boolean validation2(String a) {
    	String caracter="^[0-9]+[0-9]{1,11}$";
    	return a.matches(caracter);
    }

}
