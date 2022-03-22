package FactureR;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import Base_Donnee.Factures;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Facture2Controller implements Initializable{
   
   @FXML
   private  TableView<Facture> ListeFacture;
	   @FXML
   private TableColumn<Facture,Integer> IdFacture2;
	   @FXML
   private TableColumn<Facture,Date> DdFacture;
	   @FXML
   private TableColumn<Facture,Double> MontantFacture;
   
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void setFacture1(Set<Factures> factureses) {
		initCol();	
		Set<Facture> fr= new HashSet<Facture>();
			for (Factures facture :factureses) {
				Facture factureR =new Facture();
				factureR.setFactureId(facture.getFactureId());
				factureR.setFactureDate(facture.getFactureDate());
				factureR.setFactureMontant(facture.getFactureMontant());
				fr.add(factureR);
		}
		 ListeFacture.getItems().setAll(fr);
	}
	
	private void initCol() {
		  IdFacture2.setCellValueFactory(new PropertyValueFactory<>("factureId"));
	      DdFacture.setCellValueFactory(new PropertyValueFactory<>("factureDate"));
	      MontantFacture.setCellValueFactory(new PropertyValueFactory<>("factureMontant"));
	}


}
