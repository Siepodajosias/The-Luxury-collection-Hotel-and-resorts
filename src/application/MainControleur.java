package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Base_Donnee.Authentification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainControleur implements Initializable{
	@FXML
	SplitPane rootpane;
	@FXML
	JFXButton Idconnection;
	@FXML
	private JFXButton IdInscription;
	@FXML
	JFXPasswordField IdPwd;
	@FXML
	JFXTextField IdNom;
	@FXML
    JFXTextField IdProfession;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void OnConnecter(ActionEvent a){

		String nom=IdNom.getText();
		String pwd=IdPwd.getText();
		String profession=IdProfession.getText();

		if(nom.isEmpty()||profession.isEmpty()||pwd.isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Veillez remplir tout les champs");
			alert.showAndWait();
			return;
		}else
		{
		if(validation1(nom) && validation2(pwd)) {
			Authentification Auth2=new Authentification();
			ModelMain mdMain=new ModelMain();
	        
       if(profession.equalsIgnoreCase("superviseur")||profession.equalsIgnoreCase("caisse")||profession.equalsIgnoreCase("reception")) {
    	   
	        Auth2=mdMain.getAllById(pwd);
    	        String profession2=Auth2.getProfession();
    			if(profession2.equalsIgnoreCase("superviseur") && nom.equalsIgnoreCase(Auth2.getNomUtilisateur())) {

    				IdNom.setText("");
    				IdPwd.setText("");
    				IdProfession.setText("");
    	            
    				Stage stage=(Stage)rootpane.getScene().getWindow();
    				stage.close();
    				loadWindow("/Superviser/Superviser.fxml", "Superviser");
    				
    				}else if(profession2.equalsIgnoreCase("reception") && nom.equalsIgnoreCase(Auth2.getNomUtilisateur())) {

    					IdNom.setText("");
    					IdPwd.setText("");
    					IdProfession.setText("");
    		            
    					Stage stage=(Stage)rootpane.getScene().getWindow();
    					stage.close();
    					loadWindow("/Accueil/Accueil.fxml", "Accueil");
    					
    				}else if(profession2.equalsIgnoreCase("caisse") && nom.equalsIgnoreCase(Auth2.getNomUtilisateur())){
    					IdNom.setText("");
    					IdPwd.setText("");
    					IdProfession.setText("");
    		            
    					Stage stage=(Stage)rootpane.getScene().getWindow();
    					stage.close();
    					loadWindow("/Regler/Regler.fxml", "Caisse");
    					
    				}else{
    					Alert alert=new Alert(Alert.AlertType.ERROR);
    					alert.setHeaderText(null);
    					alert.setContentText("Nom d'utilisateur incorrecte");
    					alert.showAndWait();
    				}
	        
			}else {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Echec Poste de Travail : superviseur,caisse,reception");
				alert.showAndWait();
			}
		}else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Nom ou Mot de passe incorrecte: Utilisez les lettres pour le nom d utilisateur et l alphanumérique pour le mot de passe");
			alert.showAndWait();
		}
		}
		
	}
	
	@FXML
	public void OnInscription(ActionEvent a){
		Stage stage=(Stage)rootpane.getScene().getWindow();
		stage.close();
			loadWindow("/Sinscrire/inscription.fxml", "Inscription");
	}
	
    private void loadWindow(String loc,String title) {
    	try {
			Parent root=FXMLLoader.load(getClass().getResource(loc));
			Stage stage= new Stage(StageStyle.DECORATED);
			stage.setTitle(title);
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public boolean validation1(String a) {
    	String caracter="^[a-zA-Z]+[a-z-A-z]{2,20}$";
    	return a.matches(caracter);
    }
    public boolean validation2(String a) {
    	String caracter="^[a-zA-Z0-9]+[a-z-A-z0-9]{2,8}$";
    	return a.matches(caracter);
    }
}


