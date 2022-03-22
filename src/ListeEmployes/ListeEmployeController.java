package ListeEmployes;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import AjouterEmployes.AjouterEDAO;
import Base_Donnee.Employes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListeEmployeController implements Initializable{
	   @FXML
     private  TableView<Employe> ListeEmployes;
	   @FXML
     private TableColumn<Employe,Integer> IdEmploye;
	   @FXML
     private TableColumn<Employe,String> NomEmploye;
	   @FXML
     private TableColumn<Employe,String> PrenomEmploye;
	   @FXML
     private TableColumn<Employe,Integer> AgeEmploye;
	   @FXML
     private TableColumn<Employe,String> GEmploye;
	   @FXML
     private TableColumn<Employe,String> villeEmploye;
	   @FXML
     private TableColumn<Employe,Integer> NumEmploye;
	   @FXML
     private TableColumn<Employe,String> serviceEmploye;
	   @FXML
	   TableColumn<Employe,Button> IdButton;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initCol();
		AjouterEDAO mdemploye =new AjouterEDAO();
		List<Employe> employeList=new ArrayList<>();
		
		for (Employes it : mdemploye.getAll()) {
			
			Employe employe=new Employe();
            employe.setEmployeId(it.getEmployeId());
			employe.setEmployeNom(it.getEmployeNom());
			employe.setEmployePrenom(it.getEmployePrenom());
			employe.setEmployeAge(it.getEmployeAge());
			employe.setEmployeGenre(it.getEmployeGenre());
			employe.setEmployeVille(it.getEmployeVille());
			employe.setEmployeNumero(it.getEmployeNumero());
			employe.setServices(it.getServices().getServiceDescription());
			
			employe.setAction(new Button("Supprimer"));
			employe.getAction().setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					int id1=ListeEmployes.getSelectionModel().getSelectedItem().getEmployeId();
					if(mdemploye.Delete(id1)){
						ListeEmployes.getItems().removeAll(ListeEmployes.getSelectionModel().getSelectedItem());
					}
				}
			});
			
			employeList.add(employe);
		}
		
		ListeEmployes.getItems().setAll(employeList);
	}
	
	private void initCol() {
		IdEmploye.setCellValueFactory(new  PropertyValueFactory<>("employeId"));
		NomEmploye.setCellValueFactory(new PropertyValueFactory<>("employeNom"));
		PrenomEmploye.setCellValueFactory(new PropertyValueFactory<>("employePrenom"));
		AgeEmploye.setCellValueFactory(new PropertyValueFactory<>("employeAge"));
		GEmploye.setCellValueFactory(new PropertyValueFactory<>("employeGenre"));
		villeEmploye.setCellValueFactory(new PropertyValueFactory<>("employeVille"));
		NumEmploye.setCellValueFactory(new PropertyValueFactory<>("employeNumero"));
		serviceEmploye.setCellValueFactory(new PropertyValueFactory<>("services"));
		IdButton.setCellValueFactory(new PropertyValueFactory<>("action"));
	
	}

}
