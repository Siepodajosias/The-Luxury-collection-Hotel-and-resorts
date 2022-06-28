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

import com.cemedo.data.Medecin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur les Medecins")
public class MedecinController {

	@Autowired
 private IMedecin medecin;
 
@ApiOperation(value = "Récupere la liste des Medecins")
 @GetMapping(value = "/listeM")
 public List<Medecin> getListe(){
	  return medecin.findAll();
 }
 
@ApiOperation(value = "Récupere un Medecin en fonction de son identifiant")
 @GetMapping(value = "/listeM/{id}")
 public Medecin getListeId(@PathVariable(name = "id") Integer id){
	  return medecin.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer un medecin")
	@PostMapping(value = "/listeM")
	public Medecin Enregistrer(@RequestBody Medecin p) {
	     return  medecin.save(p);
	}
 
@ApiOperation(value = "Mise à jour des information d'un medecin")
	@PutMapping(value = "/listeM/{id}")
	public Medecin update(@PathVariable(name="id") Integer id,@RequestBody Medecin p) {
		p.setIdMedecins(id);
	   return medecin.save(p);
	}
@ApiOperation(value = "Retirer un medecin de la base de donnee")
	@DeleteMapping(value = "/listeM/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		medecin.deleteById(id);
	}
}
