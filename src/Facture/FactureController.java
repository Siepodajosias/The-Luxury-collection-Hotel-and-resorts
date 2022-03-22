package Facture;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Base_Donnee.Factures;
import Regler.FactureDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FactureController implements Initializable {
	   @FXML
	     private  TableView<Facture> ListeFacture;
		   @FXML
	     private TableColumn<Facture,Integer> IdFacture;
		   @FXML
	     private TableColumn<Facture,Date> DdFacture;
		   @FXML
	     private TableColumn<Facture,Double> MontantFacture;
		   @FXML
	     private TableColumn<Facture,Integer> IDreservation;
		   @FXML
	     private TableColumn<Facture,String> IDClient;
		   @FXML
		   TableColumn<Facture,Button> IdButton;
		   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	  initCol();
	  
		FactureDAO mdFacture =new FactureDAO();		
		List<Facture> factureList=new ArrayList<>();
		
		for (Factures it : mdFacture.getAll()) {
			Facture fact=new Facture();
	       fact.setFactureId(it.getFactureId());
	       fact.setFactureDate(it.getFactureDate());
	       fact.setFactureMontant(it.getFactureMontant());
	       fact.setIdreservations(it.getReservations().getReservationId());
	       fact.setIdreser_client(it.getReservations().getClients().getClientNom());
	       
			fact.setAction(new Button("Annuler"));
			fact.getAction().setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					int id1=ListeFacture.getSelectionModel().getSelectedItem().getFactureId();
					if(mdFacture.Delete(id1)){
						ListeFacture.getItems().removeAll(ListeFacture.getSelectionModel().getSelectedItem());
					}
					
				}
			});
			factureList.add(fact);
		}
		
		ListeFacture.getItems().setAll(factureList);
		
	}
	private void initCol() {
		
      IdFacture.setCellValueFactory(new PropertyValueFactory<>("factureId"));
      DdFacture.setCellValueFactory(new PropertyValueFactory<>("factureDate"));
      MontantFacture.setCellValueFactory(new PropertyValueFactory<>("factureMontant"));
      IDreservation.setCellValueFactory(new PropertyValueFactory<>("idreservations"));
      IDClient.setCellValueFactory(new PropertyValueFactory<>("idreser_client"));
      IdButton.setCellValueFactory(new PropertyValueFactory<>("action"));
	
	}

}
