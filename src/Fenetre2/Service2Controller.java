package Fenetre2;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import Base_Donnee.Services;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Service2Controller implements Initializable{
   
   @FXML
   private  TableView<Service> ListeServ;
	   @FXML
   private TableColumn<Service,Integer> Idservice;
	   @FXML
   private TableColumn<Service,String> IdDescp;
	   @FXML
   private TableColumn<Service,Date> IdDDserv;
	   @FXML
   private TableColumn<Service,Date> IdDFserv;  
	   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	private void initCol() {
		  Idservice.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
	      IdDescp.setCellValueFactory(new PropertyValueFactory<>("Descp"));
	      IdDDserv.setCellValueFactory(new PropertyValueFactory<>("DDserv"));
	      IdDFserv.setCellValueFactory(new PropertyValueFactory<>("DFserv"));
	}

	public void setServiceses(Set<Services> servicese1) {
		initCol();
		Set<Service> Serv= new HashSet<Service>();
			for (Services serv1 : servicese1) {
				 Service serv2 =new Service();
				serv2.setServiceId(serv1.getServicesId());
				serv2.setDescp(serv1.getServiceDescription());
				serv2.setDDserv(serv1.getServiceHeureDebut());
				serv2.setDFserv(serv1.getServiceHeureFin());
			    Serv.add(serv2);
		     }
			 ListeServ.getItems().setAll(Serv);
	      }
	
}
