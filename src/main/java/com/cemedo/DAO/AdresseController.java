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

import com.cemedo.data.Adresse;

@CrossOrigin("*")
@RestController
public class AdresseController {
	
	@Autowired
 private IAdresse adresse;
 
	
 @GetMapping(value = "/listeAd")
 public List<Adresse> getListe(){
	  return  adresse.findAll();
 }
 
 @GetMapping(value = "/listeAd/{id}")
 public Adresse getListeId(@PathVariable(name = "id") Integer id){
	  return  adresse.findById(id).get();
 }
 
 
	@PostMapping(value = "/listeAd")
	public Adresse Enregistrer(@RequestBody Adresse p) {
	     return   adresse.save(p);
	}
 
	@PutMapping(value = "/listeAd/{id}")
	public Adresse update(@PathVariable(name="id") Integer id,@RequestBody Adresse p) {
		p.setIdAdresse(id);
	   return  adresse.save(p);
	}
	
	@DeleteMapping(value = "/listeAd/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		 adresse.deleteById(id);
	}

}
