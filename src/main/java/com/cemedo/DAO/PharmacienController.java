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

import com.cemedo.data.Pharmacien;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur les Pharmaciens")
public class PharmacienController {
	

	@Autowired
 private IPharmacie pharmacien;
 
@ApiOperation(value = "Récupere la liste des Pharmaciens")
 @GetMapping(value = "/listePhar")
 public List<Pharmacien> getListe(){
	  return pharmacien.findAll();
 }
 
@ApiOperation(value = "Récupere un Pharmacien en fonction de son identifiant")
 @GetMapping(value = "/listePhar/{id}")
 public Pharmacien getListeId(@PathVariable(name = "id") Integer id){
	  return pharmacien.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer un Pharmacien")
	@PostMapping(value = "/listePhar")
	public Pharmacien Enregistrer(@RequestBody Pharmacien p) {
	     return  pharmacien.save(p);
	}
 
@ApiOperation(value = "Mise à jour des information d'un pharmacien")
	@PutMapping(value = "/listePhar/{id}")
	public Pharmacien update(@PathVariable(name="id") Integer id,@RequestBody Pharmacien p) {
		p.setIdPharmacien(id);
	   return pharmacien.save(p);
	}
@ApiOperation(value = "Retirer un pharmacien de la base de donnee")
	@DeleteMapping(value = "/listePhar/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		pharmacien.deleteById(id);
	}
}
