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

import com.cemedo.data.Infirmier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur les Infirmiers")
public class InfirmierController {


	@Autowired
 private IInfirmerie infirmier;
 
@ApiOperation(value = "Récupere la liste des Infirmiers")
 @GetMapping(value = "/listeInfir")
 public List<Infirmier> getListe(){
	  return infirmier.findAll();
 }
 
@ApiOperation(value = "Récupere un Infirmier en fonction de son identifiant")
 @GetMapping(value = "/listeInfir/{id}")
 public Infirmier getListeId(@PathVariable(name = "id") Integer id){
	  return infirmier.findById(id).get();
 }
 
@ApiOperation(value = "Enregistrer un Infirmier")
	@PostMapping(value = "/listeInfir")
	public Infirmier Enregistrer(@RequestBody Infirmier p) {
	     return  infirmier.save(p);
	}
 
@ApiOperation(value = "Mise à jour des information d'un medecin")
	@PutMapping(value = "/listeM/{id}")
	public Infirmier update(@PathVariable(name="id") Integer id,@RequestBody Infirmier p) {
		p.setIdInfirmier(id);
	   return infirmier.save(p);
	}
@ApiOperation(value = "Retirer un infirmier de la base de donnee")
	@DeleteMapping(value = "/listeInfir/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		infirmier.deleteById(id);
	}
}
