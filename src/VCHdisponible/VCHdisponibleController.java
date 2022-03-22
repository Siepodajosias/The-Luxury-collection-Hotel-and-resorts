package VCHdisponible;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import AjouterChambre.ModelChambre;
import Base_Donnee.Chambres;
import Fenetre1.OccupationController;
import Fenetre2.Service2Controller;
import Fenetre3.Reservation2Controller;
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

public class VCHdisponibleController implements Initializable{
	   @FXML
	     private  TableView<Chambre> IDlisteChambre;
		   @FXML
	     private TableColumn<Chambre,Integer> IdNum;
		   @FXML
		 private TableColumn<Chambre,String> IDdesc;
		   @FXML
	     private TableColumn<Chambre,Integer> IDprix;
		   @FXML
	     private TableColumn<Chambre,Integer> IDtele;
		   @FXML
	     private TableColumn<Chambre,String> GEmploye;
		   @FXML
	     private TableColumn<Chambre,Button> IDoccp;
		   @FXML
	     private TableColumn<Chambre,Button> idReserv;
		   @FXML
	     private TableColumn<Chambre,Button> IDserv;
		   @FXML
		   TableColumn<Chambre,Button> IdButton;

		@Override
		public void initialize(URL location, ResourceBundle resources) {

			initCol();
			ModelChambre mdChambre =new ModelChambre();
			List<Chambre> chambreList=new ArrayList<>();
			
			for (Chambres it : mdChambre.getAll()) {
				
				Chambre chambre=new Chambre();
				chambre.setChambreNumero(it.getChambreNumero());
				chambre.setChambreDescription(it.getChambreDescription());
				chambre.setChambrePrix(it.getChambrePrix());
				chambre.setChambreTelephone(it.getChambreTelephone());
				chambre.setFr1(it.getOccupations());
				chambre.setReservation2(it.getReservationses());
				chambre.setServicese2(it.getServiceses());
				//chambre.setOccupations);
			
				chambre.setOccupations(new Button("Voir"));
				chambre.getOccupations().setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						Chambre id2=IDlisteChambre.getSelectionModel().getSelectedItem();
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/Fenetre1/Occupation.fxml"));
						Parent root = null;
						try {
							root = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						OccupationController Occp1=loader.getController();
						Occp1.setFr2(id2.getFr1());
						Stage stage= new Stage(StageStyle.DECORATED);
						stage.setResizable(false);
						stage.setScene(new Scene(root));
						stage.show();
					}
				});
				chambre.setReservationses(new Button("Voir Reservation"));
				chambre.getReservationses().setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {

						Chambre id2=IDlisteChambre.getSelectionModel().getSelectedItem();
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/Fenetre3/Reservation.fxml"));
						Parent root = null;
						try {
							root = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Reservation2Controller Reser1=loader.getController();
						Reser1.setReservation1(id2.getReservation2());
						Stage stage= new Stage(StageStyle.DECORATED);
						stage.setResizable(false);
						stage.setScene(new Scene(root));
						stage.show();
					}
				});
				
				chambre.setServiceses(new Button("Voir services"));
				chambre.getServiceses().setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						
						Chambre id2=IDlisteChambre.getSelectionModel().getSelectedItem();
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/Fenetre2/Service.fxml"));
						Parent root = null;
						try {
							root = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Service2Controller Ser1=loader.getController();
						Ser1.setServiceses(id2.getServicese2());
						Stage stage= new Stage(StageStyle.DECORATED);
						stage.setResizable(false);
						stage.setScene(new Scene(root));
						stage.show();
					}
				});

				chambre.setAction(new Button("Retirer"));
				chambre.getAction().setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						int id1=IDlisteChambre.getSelectionModel().getSelectedItem().getChambreNumero();
						
						if(mdChambre.Delete(id1)){
							IDlisteChambre.getItems().removeAll(IDlisteChambre.getSelectionModel().getSelectedItem());
						}
						
					}
				});
				
				chambreList.add(chambre);
			}
			
			IDlisteChambre.getItems().setAll( chambreList);
		}

		private void initCol() {
			IdNum.setCellValueFactory(new  PropertyValueFactory<>("chambreNumero"));
			IDdesc.setCellValueFactory(new PropertyValueFactory<>("chambreDescription"));
			IDprix.setCellValueFactory(new PropertyValueFactory<>("chambrePrix"));
			IDtele.setCellValueFactory(new PropertyValueFactory<>("chambreTelephone"));
			IDoccp.setCellValueFactory(new PropertyValueFactory<>("occupations"));
			IdButton.setCellValueFactory(new PropertyValueFactory<>("action"));
			idReserv.setCellValueFactory(new PropertyValueFactory<>("reservationses"));
			IDserv.setCellValueFactory(new PropertyValueFactory<>("serviceses"));
			IdButton.setCellValueFactory(new PropertyValueFactory<>("action"));
			
		}

}
