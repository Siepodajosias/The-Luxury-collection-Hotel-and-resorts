package com.cemedo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cemedo.data.Reception;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur la Reception")
public class ReceptionController {

	@Autowired
 private IReception reception;
 
@ApiOperation(value = "Récupere la liste de la reception")
 @GetMapping(value = "/listeRept")
 public List<Reception> getListe(){
	  return reception.findAll();
 }
 
@ApiOperation(value = "Récupere les informations en fonction de son identifiant")
 @GetMapping(value = "/listeRept/{id}")
 public Reception getListeId(@PathVariable(name = "id") Integer id){
	  return reception.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer une receptionniste")
	@PostMapping(value = "/listeRept")
	public Reception Enregistrer(@RequestBody Reception p) {
	     return  reception.save(p);
	}
 
@ApiOperation(value = "Mise à jour des informations")
	@PutMapping(value = "/listeRept/{id}")
	public Reception update(@PathVariable(name="id") Integer id,@RequestBody Reception p) {
		p.setIdReception(id);
	   return reception.save(p);
	}
@ApiOperation(value = "Retirer une receptionniste de la base de donnee")
	@DeleteMapping(value = "/listeRept/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		reception.deleteById(id);
	}
}
