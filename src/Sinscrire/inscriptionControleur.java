package Sinscrire;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Base_Donnee.Authentification;
import application.ModelMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class inscriptionControleur implements Initializable{
	@FXML
	SplitPane rootpaneI;
    @FXML
	private JFXButton Idinscription;
    @FXML
    private JFXPasswordField IdPwd;
    @FXML
    JFXTextField IdProfession;
    @FXML
    private JFXTextField IdNom;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void OnInscrire() {
		
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
				
				Authentification Auth1 =new Authentification();
				ModelMain mdMain=new ModelMain();
		        Auth1.setNomUtilisateur(nom);
		        Auth1.setProfession(profession);
		        Auth1.setModePwd(pwd);
		        
				if(Auth1.getProfession().equalsIgnoreCase("superviseur")||Auth1.getProfession().equalsIgnoreCase("caisse")||Auth1.getProfession().equalsIgnoreCase("reception")) {
					if(	mdMain.postAll(Auth1)) {

						Alert alert=new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setContentText("Inscription Reussit");
						alert.showAndWait();
						
						String profession2=Auth1.getProfession();

						if(profession2.equalsIgnoreCase("superviseur")) {

							IdNom.setText("");
							IdPwd.setText("");
							IdProfession.setText("");
				            
							Stage stage=(Stage)rootpaneI.getScene().getWindow();
							stage.close();
							loadWindow("/Superviser/Superviser.fxml", "Superviser");
							
							}else if(profession2.equalsIgnoreCase("reception")) {

								IdNom.setText("");
								IdPwd.setText("");
								IdProfession.setText("");
					            
								Stage stage=(Stage)rootpaneI.getScene().getWindow();
								stage.close();
								loadWindow("/Accueil/Accueil.fxml", "Accueil");
								
							}else if(profession2.equalsIgnoreCase("caisse")){
								IdNom.setText("");
								IdPwd.setText("");
								IdProfession.setText("");
					            
								Stage stage=(Stage)rootpaneI.getScene().getWindow();
								stage.close();
								loadWindow("/Regler/Regler.fxml", "Caisse");
								
							}
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
