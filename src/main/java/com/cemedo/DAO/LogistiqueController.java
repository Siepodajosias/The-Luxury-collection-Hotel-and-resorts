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

import com.cemedo.data.Logistique;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur la Logistique")
public class LogistiqueController {


	@Autowired
 private ILogistique logistique;
 
@ApiOperation(value = "Récupere la liste Logistique")
 @GetMapping(value = "/listeLog")
 public List<Logistique> getListe(){
	  return logistique.findAll();
 }
 
@ApiOperation(value = "Récupere une information en fonction de son identifiant")
 @GetMapping(value = "/listeLog/{id}")
 public Logistique getListeId(@PathVariable(name = "id") Integer id){
	  return logistique.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer une information")
	@PostMapping(value = "/listeLog")
	public Logistique Enregistrer(@RequestBody Logistique p) {
	     return  logistique.save(p);
	}
 
@ApiOperation(value = "Mise à jour des informations")
	@PutMapping(value = "/listeLog/{id}")
	public Logistique update(@PathVariable(name="id") Integer id,@RequestBody Logistique p) {
		p.setIdLogistiques(id);
	   return logistique.save(p);
	}
@ApiOperation(value = "Retirer une information de la base de donnee")
	@DeleteMapping(value = "/listeLog/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		logistique.deleteById(id);
	}
}
