package Regler;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import Accueil.AccueilDAO;
import Base_Donnee.Factures;
import Base_Donnee.Reservations;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReglerController implements Initializable{
    
    @FXML
    Button IdVreservation;
    @FXML
    JFXButton IdEnregistrer;
    @FXML
    ComboBox<Integer> IDReservation;
    @FXML
    TextField IDMontant;
    @FXML
    JFXTextField IdFactureCour;
    @FXML
    JFXDatePicker IDFacture;
    
    @FXML
    ListView<String> ListeFacture;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AccueilDAO reservation=new AccueilDAO();
		for(Reservations iterable1 : reservation.getAll()) {
			IDReservation.getItems().addAll(FXCollections.observableArrayList(iterable1.getReservationId()));
		}
	}

    @FXML
    public void OnReservation(ActionEvent e) {
    	 loadWindow("/Vreservation/Vreservation.fxml", "Reservation");
	}
    @FXML
    public void OnEnregistrer(ActionEvent e) {
    	
	    int reservation1=IDReservation.getValue();
	    double montant=Double.parseDouble(IDMontant.getText());
		LocalDate Debut=IDFacture.getValue();
			
			FactureDAO facture1=new FactureDAO();
			Factures facture2=new Factures();
			AccueilDAO mdReservation=new AccueilDAO();

			   facture2.setReservations(mdReservation.getAllById(reservation1));
			   facture2.setFactureMontant(montant);
		       facture2.setFactureDate(Date.valueOf(Debut));
             
		       if(facture1.postAll(facture2)) {
		    	   
		    	   IDMontant.setText("");
					Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
					alert.setHeaderText(null);
					alert.setContentText("Facture Enregistrer");
					alert.showAndWait();
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
	public void loadFacture(ActionEvent e){
	ObservableList<String> Facture1=FXCollections.observableArrayList();
		
	int p=Integer.parseInt(IdFactureCour.getText());
	FactureDAO model=new FactureDAO();
	Factures Facture2=model.getAllById(p);

	Facture1.add("Numéro de la Facture : " + String.valueOf(Facture2.getFactureId()));
	Facture1.add("Montant de La Facture : " + String.valueOf(Facture2.getFactureMontant()));
	Facture1.add("Date de la Facture : " + String.valueOf(Facture2.getFactureDate()));
	Facture1.add("Numéro de la Reservation: " +String.valueOf(Facture2.getReservations().getReservationId()));
	Facture1.add("Nom du Client : " + String.valueOf(Facture2.getReservations().getClients().getClientNom()));
	Facture1.add("Prenom du Client : " + String.valueOf(Facture2.getReservations().getClients().getClientPrenom()));
	Facture1.add("Profession du Client : " + String.valueOf(Facture2.getReservations().getClients().getClientProfession()));
	Facture1.add("Ville du Client : " + String.valueOf(Facture2.getReservations().getClients().getClientVille()));
	
	ListeFacture.getItems().setAll(Facture1);
	}
	
	}