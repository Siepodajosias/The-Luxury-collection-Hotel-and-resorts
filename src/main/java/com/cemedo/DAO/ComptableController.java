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

import com.cemedo.data.Comptable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur les Comptables")
public class ComptableController {


	@Autowired
 private IComptable comptable;
 
@ApiOperation(value = "Récupere la liste des Comptables")
 @GetMapping(value = "/listeCompt")
 public List<Comptable> getListe(){
	  return comptable.findAll();
 }
 
@ApiOperation(value = "Récupere un Comptable en fonction de son identifiant")
 @GetMapping(value = "/liste*Compt/{id}")
 public Comptable getListeId(@PathVariable(name = "id") Integer id){
	  return comptable.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer un Comptable")
	@PostMapping(value = "/listeCompt")
	public Comptable Enregistrer(@RequestBody Comptable p) {
	     return  comptable.save(p);
	}
 
@ApiOperation(value = "Mise à jour des information d'un comptable")
	@PutMapping(value = "/listeCompt/{id}")
	public Comptable update(@PathVariable(name="id") Integer id,@RequestBody Comptable p) {
		p.setIdComptables(id);
	   return comptable.save(p);
	}
@ApiOperation(value = "Retirer un comptable de la base de donnee")
	@DeleteMapping(value = "/listeCompt/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		comptable.deleteById(id);
	}
}
