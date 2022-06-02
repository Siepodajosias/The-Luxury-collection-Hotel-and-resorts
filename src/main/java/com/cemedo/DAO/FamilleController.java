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

import com.cemedo.data.Famille;

@CrossOrigin("*")
@RestController
public class FamilleController {

	@Autowired
 private IFamille famille;
 
	
 @GetMapping(value = "/listeF")
 public List<Famille> getListe(){
	  return famille.findAll();
 }
 
 @GetMapping(value = "/listeF/{id}")
 public Famille getListeId(@PathVariable(name = "id") Integer id){
	  return famille.findById(id).get();
 }
 
 
	@PostMapping(value = "/listeF")
	public Famille Enregistrer(@RequestBody Famille p) {
	     return  famille.save(p);
	}
 
	@PutMapping(value = "/listeF/{id}")
	public Famille update(@PathVariable(name="id") Integer id,@RequestBody Famille p) {
		p.setIdFamille(id);
	   return famille.save(p);
	}
	
	@DeleteMapping(value = "/listeF/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		famille.deleteById(id);
	}
}
