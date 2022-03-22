package Vreservation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import Accueil.AccueilDAO;
import Base_Donnee.Reservations;
import FactureR.Facture2Controller;
import Vreservation2.reservation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VreservationController implements Initializable{
	@FXML
    TableView<reservation> ListeReservation;
   @FXML
       TableColumn<reservation,Integer> IdReservation;
   @FXML
       TableColumn<reservation,String> IdClient;
   @FXML
       TableColumn<reservation,String> IdChambre;
   @FXML
       TableColumn<reservation,String> IDservice;
   @FXML
       TableColumn<reservation,Date> IDdateD;
   @FXML
       TableColumn<reservation,Date> IdDateFin;
   @FXML
       TableColumn<reservation,Date> IdDatepaeiment;
   @FXML
   TableColumn<reservation,Date> IdFacture;
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initCol();
		AccueilDAO mdreservation =new AccueilDAO();		
		List<reservation> reservationList=new ArrayList<>();
		
		for (Reservations it : mdreservation.getAll()) {
			
			reservation reserv=new reservation();
			reserv.setReservationId(it.getReservationId());
			reserv.setNom_clients(it.getClients().getClientNom());
			reserv.setChambres(it.getChambres().getChambreDescription());
			reserv.setServices(it.getServices().getServiceDescription());
			reserv.setReservationDateDebut(it.getReservationDateDebut());
			reserv.setReservationDateFin(it.getReservationDateFin());
			reserv.setReservationDatePaye(it.getReservationDatePaye());
			reserv.setFactureses(it.getFactureses());
		    reserv.setActionF(new Button("Voir"));
			
			reserv.getActionF().setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					reservation id2=ListeReservation.getSelectionModel().getSelectedItem();
					FXMLLoader loader= new FXMLLoader(getClass().getResource("/FactureR/Facture.fxml"));
					Parent root = null;
					try {
						root = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Facture2Controller Fact1=loader.getController();
					Fact1.setFacture1(id2.getFactureses());
					Stage stage= new Stage(StageStyle.DECORATED);
					stage.setResizable(false);
					stage.setScene(new Scene(root));
					stage.show();
				}
			});
			
			reservationList.add(reserv);
		}
		
		ListeReservation.getItems().setAll(reservationList);
	}
	private void initCol() {

		IdReservation.setCellValueFactory(new  PropertyValueFactory<>("reservationId"));
		IdClient.setCellValueFactory(new PropertyValueFactory<>("nom_clients"));
		IdChambre.setCellValueFactory(new PropertyValueFactory<>("chambres"));
		IDservice.setCellValueFactory(new PropertyValueFactory<>("services"));
		IdFacture.setCellValueFactory(new PropertyValueFactory<>("actionF"));
		IDdateD.setCellValueFactory(new PropertyValueFactory<>("reservationDateDebut"));
		IdDateFin.setCellValueFactory(new PropertyValueFactory<>("reservationDateFin"));
		IdDatepaeiment.setCellValueFactory(new PropertyValueFactory<>("reservationDatePaye"));		
	}
}
