package Service;

import java.net.URL;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import Base_Donnee.Services;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ServiceController implements Initializable {
	@FXML
	AnchorPane rootpanService;
	@FXML
	JFXDatePicker IdDservice;
	@FXML
	JFXDatePicker IdFservice;
	@FXML
	TextArea Iddescription;
	@FXML
	JFXButton saveButton;	
	@FXML
	JFXButton IDannuler;									    				 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    public void addService(){
		String service=Iddescription.getText();
		LocalDate debut=IdDservice.getValue();
		LocalDate fin=IdFservice.getValue();
		
		if(service.isEmpty()) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Veillez remplir tout les champs");
			alert.showAndWait();
			return;
		}else {
			Services service2=new Services();
			ModelService mdService=new ModelService();
			service2.setServiceDescription(service);
			service2.setServiceHeureDebut(Date.valueOf(debut));
			service2.setServiceHeureFin(Date.valueOf(fin));

		if(	mdService.postAll(service2)) {
			
			Iddescription.setText("");

			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Service enregistré");
			alert.showAndWait();
			
			} 
		}	

    }
	@FXML
    public void OnAnnuler(){
		Stage stage=(Stage)rootpanService.getScene().getWindow();
		stage.close();
	
    }

}
