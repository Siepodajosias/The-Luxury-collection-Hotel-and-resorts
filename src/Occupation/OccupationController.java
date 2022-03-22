package Occupation;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;

import AjouterChambre.ModelChambre;
import Base_Donnee.Chambres;
import Base_Donnee.Clients;
import Base_Donnee.Occupation;
import Clients.ModelClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class OccupationController implements Initializable {
    @FXML
    ComboBox<Integer> IDchambre;
    @FXML
    ComboBox<Integer> IDClient;
    @FXML
    JFXDatePicker IddateD;
    @FXML
    JFXDatePicker IDdateFin; 
    @FXML
    private Label IDclD;
    @FXML
    private Label IDchD;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ModelChambre chambre=new ModelChambre();
		ModelClient client=new ModelClient();
		for(Chambres iterable1 : chambre.getAll()) {
			IDchambre.getItems().addAll(FXCollections.observableArrayList(iterable1.getChambreNumero()));
		}
		
		for(Clients iterable3 : client.getAll()) {
			IDClient.getItems().addAll(FXCollections.observableArrayList(iterable3.getIclientId()));
		}
		
	}
	
    @FXML
    public void loadchambre(){
    	ModelChambre ch1=new ModelChambre();
    	Chambres chamb1=ch1.getAllById(IDchambre.getValue());
    	IDchD.setText(chamb1.getChambreDescription());
    }
    @FXML
    void LoadClient(ActionEvent event) {
    	ModelClient cl1=new ModelClient();
    	Clients client1=cl1.getAllById(IDClient.getValue());
    	IDclD.setText(client1.getClientNom() + " " +client1.getClientPrenom());
    }

    @FXML
    public void OnEnregistrer(){
	    int chambre=IDchambre.getValue();
	    int client=IDClient.getValue();
		LocalDate Debut=IddateD.getValue();
		LocalDate Dfin=IDdateFin.getValue();
		
        OccupationDAO mdOccupation=new OccupationDAO();
        Occupation occupation=new Occupation();
        
			ModelChambre ch2=new ModelChambre();
			ModelClient cl=new ModelClient();
			
			occupation.setChambres(ch2.getAllById(chambre));
			occupation.setClients(cl.getAllById(client));
			occupation.setOccupationDateDebut(Date.valueOf(Debut));
			occupation.setOccupationDateFin(Date.valueOf(Dfin));
            
			if(mdOccupation.postAll(occupation)) {
				
				Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setContentText("Enregistrement effectuée");
				alert.showAndWait();
				return;
			}
    }

}
