package Accueil;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import AjouterChambre.ModelChambre;
import Base_Donnee.Chambres;
import Base_Donnee.Clients;
import Base_Donnee.Reservations;
import Base_Donnee.Services;
import Clients.ModelClient;
import Service.ModelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AccueilController implements Initializable {
	
	
    @FXML
    private Label IDclD;

    @FXML
    private Label IDchD;

    @FXML
    private Label IDserD;
    
    @FXML
    Button idAclient;
    @FXML
    Button idMreservation; 
    @FXML
    Button IdVChambre;
    @FXML
    Button IdOcpChambre;
    @FXML
    Button IdAnnuler;
    @FXML
    JFXButton IdEnregistrer;
    @FXML
    JFXButton IdRecherche;
    @FXML
    public ComboBox<Integer> IDchambre;
    @FXML
    public ComboBox<Integer> IDClient;
    @FXML
    public  ComboBox<Integer> IDservices;
    @FXML
    JFXDatePicker IddateD;
    @FXML
    JFXDatePicker IDdateFin; 
    @FXML
    JFXDatePicker IDdatePaye;
    @FXML
    JFXTextField IdReserCour;
    @FXML
    private ListView<String> ListeReservation;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ModelChambre chambre=new ModelChambre();
		ModelService service=new ModelService();
		ModelClient client=new ModelClient();
		for(Chambres iterable1 : chambre.getAll()) {
			IDchambre.getItems().addAll(FXCollections.observableArrayList(iterable1.getChambreNumero()));
		}
		for(Services iterable2 : service.getAll()){
			IDservices.getItems().addAll(FXCollections.observableArrayList(iterable2.getServicesId()));
		}
		for(Clients iterable3 : client.getAll()) {
			IDClient.getItems().addAll(FXCollections.observableArrayList(iterable3.getIclientId()));
		}
		
	}

    @FXML
    public void   Onclient(ActionEvent e) {
      loadWindow("/Clients/Client.fxml", "Formulaire Client");
	}
    @FXML
    public void OnMreservation(ActionEvent e) {
    	loadWindow("/Mreservation/Mreservation.fxml", "Modifier une reservation");
	}
    @FXML
    public void OnChambre( ActionEvent e) {
    	loadWindow("/VCHdisponible/VCHdisponible.fxml", "Liste Des Chambres");
	}
    @FXML
    public void OnOccpChambre(ActionEvent e){
    	loadWindow("/Occupation/Occupation.fxml", "Chambres Occuper");
    }
    @FXML
    public void OnAnnuler(ActionEvent e){
    	loadWindow("/Vreservation2/Vreservation.fxml", "Annuler");
    }
    
    @FXML
    void OnActualiser(ActionEvent event) {
		ModelChambre chambre=new ModelChambre();
		ModelService service=new ModelService();
		ModelClient client=new ModelClient();
		for(Chambres iterable1 : chambre.getAll()) {
			IDchambre.getItems().addAll(FXCollections.observableArrayList(iterable1.getChambreNumero()));
		}
		for(Services iterable2 : service.getAll()){
			IDservices.getItems().addAll(FXCollections.observableArrayList(iterable2.getServicesId()));
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
    void loadservice(ActionEvent event) {
    	ModelService ser1=new ModelService();
    	Services service1=ser1.getAllById(IDservices.getValue());
    	IDserD.setText(service1.getServiceDescription());
    }
    
    @FXML
    public void OnEnregistrer(){
    	
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
			Chambres cl1=new Chambres();
			cl1=ch2.getAllById(chambre);
			Services serv1=new Services();
			serv1=ser.getAllById(service);
			Clients cli1=new Clients();
			cli1=cl.getAllById(client);
			
			reservation.setChambres(cl1);
			reservation.setClients(cli1);
			reservation.setServices(serv1);
			reservation.setReservationDateDebut(Date.valueOf(Debut));
            reservation.setReservationDateFin(Date.valueOf(Dfin));
            reservation.setReservationDatePaye(Date.valueOf(Paye));
            
            if(mdReservation.postAll(reservation)) {
				Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setContentText("Reservation Enregistrée");
				alert.showAndWait();
				return;
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

    
    @FXML
    public void loadReservation(ActionEvent e){
    ObservableList<String> Reservation1=FXCollections.observableArrayList();
    	
	int p=Integer.parseInt( IdReserCour.getText());
	AccueilDAO model=new AccueilDAO();
	
	Reservations reservation=model.getAllById(p);
	
	Reservation1.add("Numéro de reservation :" + String.valueOf(reservation.getReservationId()));
	Reservation1.add("Date Debut reservation :" + String.valueOf(reservation.getReservationDateDebut()));
	Reservation1.add("Date Fin reservation :" + String.valueOf(reservation.getReservationDateFin()));
	Reservation1.add("Date de Paiement :" + String.valueOf(reservation.getReservationDatePaye()));
	Reservation1.add("Chambre reservée :" + String.valueOf(reservation.getChambres().getChambreDescription()));
	Reservation1.add("Nom du Client :" + String.valueOf(reservation.getClients().getClientNom()));
	Reservation1.add("Prenom du Client :" + String.valueOf(reservation.getClients().getClientPrenom()));
	Reservation1.add("Profession du Client :" + String.valueOf(reservation.getClients().getClientProfession()));
	Reservation1.add("Ville du Client :" + String.valueOf(reservation.getClients().getClientVille()));
	Reservation1.add("Service :" + String.valueOf(reservation.getServices().getServiceDescription()));

	ListeReservation.getItems().setAll(Reservation1);
	
    }
    
}
