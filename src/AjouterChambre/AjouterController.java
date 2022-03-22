package AjouterChambre;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Base_Donnee.Chambres;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AjouterController implements Initializable {
	@FXML
	AnchorPane rootpaneAChambre;
	@FXML
	JFXTextField IdChambre;
	@FXML
	TextArea Iddescription;
	@FXML
	JFXTextField IdPrix;
	@FXML
	JFXTextField IDNT;
	@FXML
	JFXButton saveButton;	
	@FXML
	JFXButton IDannuler;									    				 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    public void addChambre(){
		String Dchambre=Iddescription.getText();
		
		if(Dchambre.isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Veillez Remplir Tout Les champs");
			alert.showAndWait();
			return;
		}else {
			if(validation2(IdChambre.getText()) && validation2(IDNT.getText()) && validation2(IdPrix.getText())) {
				
				int IDchambre=Integer.parseInt(IdChambre.getText());
				String Dchambre2=Iddescription.getText();
				int numero=Integer.parseInt(IDNT.getText());
				Double prix1=Double.parseDouble(IdPrix.getText());
				
				Chambres chambre  =new Chambres();
				ModelChambre mdChambre=new ModelChambre();
				 chambre.setChambreNumero(IDchambre);
	             chambre.setChambreDescription(Dchambre2);
	             chambre.setChambreTelephone(numero);
	             chambre.setChambrePrix(prix1);
				
			if(	mdChambre.postAll(chambre)) {
				
				IdChambre.setText("");
				Iddescription.setText("");
	            IDNT.setText("");
	            IdPrix.setText("");
	            
				Alert alert=new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("sucess");
				alert.showAndWait();
				
				} 
			}else {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Erreur: utilisé les lettres pour le champ Description et les chiffres pour les autres champs ");
				alert.showAndWait();
			}

		}	
    }
	@FXML
    public void OnAnnuler(){
		Stage stage=(Stage)rootpaneAChambre.getScene().getWindow();
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
