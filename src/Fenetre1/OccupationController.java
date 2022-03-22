package Fenetre1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import Base_Donnee.Occupation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OccupationController implements Initializable{
    
   @FXML
   private  TableView<OccupationCh> ListeFacture;
	   @FXML
   private TableColumn<OccupationCh,Date> DDOccup;
	   @FXML
   private TableColumn<OccupationCh,Date> DFOccup;
	   @FXML
   private TableColumn<OccupationCh,String> ClientOccup;
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
	}
	private void initCol() {
		  DDOccup.setCellValueFactory(new PropertyValueFactory<>("DateD"));
	      DFOccup.setCellValueFactory(new PropertyValueFactory<>("DateF"));
	      ClientOccup.setCellValueFactory(new PropertyValueFactory<>("client"));
	}

	public void setFr2(Set<Occupation> set) {
		initCol();
		List<OccupationCh> fr = new ArrayList<OccupationCh>();
			for (Occupation Occp : set) {
				OccupationCh Occup =new OccupationCh();
				Occup.setDateD(Occp.getOccupationDateDebut());
				Occup.setDateF(Occp.getOccupationDateFin());
				Occup.setClient(Occp.getClients().getClientNom());
			   fr.add(Occup);
		    }
		  ListeFacture.getItems().setAll(fr);
		
	}
}
