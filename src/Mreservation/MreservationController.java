package Mreservation;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import Accueil.AccueilDAO;
import AjouterChambre.ModelChambre;
import Base_Donnee.Chambres;
import Base_Donnee.Clients;
import Base_Donnee.Reservations;
import Base_Donnee.Services;
import Clients.ModelClient;
import Service.ModelService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MreservationController implements Initializable{
    @FXML
    ComboBox<Integer> IDchambre;
    @FXML
    ComboBox<Integer> IDClient;
    @FXML
    ComboBox<Integer> IDservices;
    @FXML
    ComboBox<Integer> IDreservation;
    
    @FXML
    private Label IDclD;

    @FXML
    private Label IDchD;

    @FXML
    private Label IDserD;
    
    @FXML
    private Label IDreserv1;
    @FXML
    JFXDatePicker IddateD;
    @FXML
    JFXDatePicker IDdateFin; 
    @FXML
    JFXDatePicker IDdatePaye;
    @FXML
    JFXButton IdEnregistrer;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ModelChambre chambre=new ModelChambre();
		ModelService service=new ModelService();
		ModelClient client=new ModelClient();
		AccueilDAO reserv=new AccueilDAO();
		for(Chambres iterable1 : chambre.getAll()) {
			IDchambre.getItems().addAll(FXCollections.observableArrayList(iterable1.getChambreNumero()));
		}
		for(Services iterable2 : service.getAll()){
			IDservices.getItems().addAll(FXCollections.observableArrayList(iterable2.getServicesId()));
		}
		for(Clients iterable3 : client.getAll()) {
			IDClient.getItems().addAll(FXCollections.observableArrayList(iterable3.getIclientId()));
		}
		
		for(Reservations iterable4 : reserv.getAll()) {
			IDreservation.getItems().addAll(FXCollections.observableArrayList(iterable4.getReservationId()));
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
    void loadservice(ActionEvent event) {
    	ModelService ser1=new ModelService();
    	Services service1=ser1.getAllById(IDservices.getValue());
    	IDserD.setText(service1.getServiceDescription());
    }
    @FXML
    void loadreservation(ActionEvent event) {
		Reservations reservation=new Reservations();
		AccueilDAO mdReservation=new AccueilDAO();
		 reservation=mdReservation.getAllById(IDreservation.getValue());
		IDreserv1.setText(String.valueOf(reservation.getReservationId()));
		
    }
	
    @FXML
    public void OnEnregistrer(){
    	
    	int idreser=IDreservation.getValue();
	    int chambre=IDchambre.getValue();
	    int client=IDClient.getValue();
	    int service=IDservices.getValue();
		LocalDate Debut=IddateD.getValue();
		LocalDate Dfin=IDdateFin.getValue();
		LocalDate Paye=IDdatePaye.getValue();
		
			Reservations reservation=new Reservations();
			AccueilDAO mdReservation=new AccueilDAO();
			
			ModelChambre ch2=new ModelChambre();
			ModelClient cl=new ModelClient();
			ModelService ser=new ModelService();
			
			reservation.setReservationId(idreser);
			reservation.setChambres(ch2.getAllById(chambre));
			reservation.setClients(cl.getAllById(client));
			reservation.setServices(ser.getAllById(service));
			reservation.setReservationDateDebut(Date.valueOf(Debut));
            reservation.setReservationDateFin(Date.valueOf(Dfin));
            reservation.setReservationDatePaye(Date.valueOf(Paye));
            
            if(mdReservation.Update(reservation)) {
    			Alert alert=new Alert(Alert.AlertType.INFORMATION);
    			alert.setHeaderText(null);
    			alert.setContentText("Modification effectuée avec success");
    			alert.showAndWait();
            }
            
    }

}
