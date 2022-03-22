package Clients;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Base_Donnee.Clients;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClientController implements Initializable {
	@FXML
	AnchorPane rootpaneAclient;
	@FXML
	JFXTextField Idnom;
	@FXML
    JFXTextField Idprenom;
	@FXML
	JFXTextField Idage;
	@FXML
	JFXTextField IDProfession;
	@FXML
	JFXTextField IDnumero;
	@FXML
	JFXTextField IDville;
	@FXML
	JFXButton saveButton;
	@FXML
    JFXButton  IDannuler;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void addClient(){
		
		String nom1=Idnom.getText();
		String prenom1=Idprenom.getText();
		String age1=Idage.getText();
		String profession1=IDProfession.getText();
		String numero1=IDnumero.getText();
		String ville1=IDville.getText();
		
		if(nom1.isEmpty()||prenom1.isEmpty()||age1.isEmpty()||profession1.isEmpty()||numero1.isEmpty()||ville1.isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Veillez remplir tout les champs");
			alert.showAndWait();
			return;
		}else {
			if(validation1(profession1) && validation1(ville1) && validation2(Idage.getText()) && validation2(IDnumero.getText())) {
				String nom2=Idnom.getText();
				String prenom2=Idprenom.getText();
				int age2=Integer.parseInt(Idage.getText());
				String profession2=IDProfession.getText();
				int numero2=Integer.parseInt(IDnumero.getText());
				String ville2=IDville.getText();
				
				
				Clients client=new Clients();
				ModelClient mdClient=new ModelClient();
				client.setClientNom(nom2);   
				client.setClientPrenom(prenom2);
				client.setClientAge(age2);
				client.setClientProfession(profession2);
				client.setClientNumero(numero2);
				client.setClientVille(ville2);
				
			if(	mdClient.postAll(client)) {
				
				Idnom.setText("");
				Idprenom.setText("");
				Idage.setText("");
				IDProfession.setText("");
				IDnumero.setText("");
				IDville.setText("");
				
				Alert alert=new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Client enregistré");
				alert.showAndWait();

				} 
			}else {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Erreur: utilisé les lettres pour les champs nom,prenom,profession,ville et les chiffres pour les autres champs ");
				alert.showAndWait();
			}
		}	
	 }
	@FXML
	public void OnAnnuler(){
		Stage stage=(Stage)rootpaneAclient.getScene().getWindow();
		stage.close();
		 
	 }
	
    public boolean validation1(String a) {
    	String caracter="^[a-zA-Z]+[a-z-A-z]{2,20}$";
    	return a.matches(caracter);
    }
    public boolean validation2(String a) {
    	String caracter="^[0-9]+[0-9]{1,8}$";
    	return a.matches(caracter);
    }

}
