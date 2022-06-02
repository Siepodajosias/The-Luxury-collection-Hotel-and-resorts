package com.cemedo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cemedo.data.Antecedant;

@RestController
public class AntecedentController {
	

	@Autowired
 private IAntecedent antecedent;
 
	
 @GetMapping(value = "/listeAnt")
 public List<Antecedant> getListe(){
	  return antecedent.findAll();
 }
 
 @GetMapping(value = "/listeAnt/{id}")
 public Antecedant getListeId(@PathVariable(name = "id") Integer id){
	  return antecedent.findById(id).get();
 }
 
 
	@PostMapping(value = "/listeAnt")
	public Antecedant Enregistrer(@RequestBody Antecedant p) {
	     return  antecedent.save(p);
	}
 
	@PutMapping(value = "/listeAnt/{id}")
	public Antecedant update(@PathVariable(name="id") Integer id,@RequestBody Antecedant p) {
		p.setIdAntecedants(id);
	   return antecedent.save(p);
	}
	
	@DeleteMapping(value = "/listeant/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		antecedent.deleteById(id);
	}

}
