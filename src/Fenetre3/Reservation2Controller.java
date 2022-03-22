package Fenetre3;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import Base_Donnee.Reservations;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Reservation2Controller implements Initializable{

   
   @FXML
   private  TableView<rReservation> ListeFacture;
	   @FXML
   private TableColumn<rReservation,Integer> IdReserv2;
	   @FXML
   private TableColumn<rReservation,Date> DdReserv2;
	   @FXML
   private TableColumn<rReservation,Date> DfReserv2;
	   @FXML
   private TableColumn<rReservation,Date> DpReserv2;
	   @FXML
   private TableColumn<rReservation,String>  NcReserv2;
	   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void setReservation1(Set<Reservations> reservation1) {
	initCol();
	Set<rReservation> reservations = new HashSet<rReservation>();
		for (Reservations reser1 : reservation1) {
				rReservation Reser =new rReservation();
				Reser.setReservId(reser1.getReservationId());
				Reser.setReservationDateDebut(reser1.getReservationDateDebut());
				Reser.setReservationDateFin(reser1.getReservationDateFin());
				Reser.setReservationDatePaye(reser1.getReservationDatePaye());
				Reser.setNom_clients(reser1.getClients().getClientNom());
				reservations.add(Reser);
	        }
	       ListeFacture.getItems().setAll(reservations);
		
	}
	private void initCol() {
		  IdReserv2.setCellValueFactory(new PropertyValueFactory<>("ReservId"));
	      DdReserv2.setCellValueFactory(new PropertyValueFactory<>("reservationDateDebut"));
	      DfReserv2.setCellValueFactory(new PropertyValueFactory<>("reservationDateFin"));
	      DpReserv2.setCellValueFactory(new PropertyValueFactory<>("reservationDatePaye"));
	      NcReserv2.setCellValueFactory(new PropertyValueFactory<>("nom_clients"));
	}

}
