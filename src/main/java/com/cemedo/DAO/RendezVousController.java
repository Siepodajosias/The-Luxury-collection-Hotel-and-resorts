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

import com.cemedo.data.Rendezvous;

@CrossOrigin("*")
@RestController
public class RendezVousController {

	@Autowired
 private IRendezVous rendezvous;
 
	
 @GetMapping(value = "/listeRdv")
 public List<Rendezvous> getListe(){
	  return rendezvous.findAll();
 }
 
 @GetMapping(value = "/listeRdv/{id}")
 public Rendezvous getListeId(@PathVariable(name = "id") Integer id){
	  return rendezvous.findById(id).get();
 }
 
 
	@PostMapping(value = "/listeRdv")
	public Rendezvous Enregistrer(@RequestBody Rendezvous p) {
	     return  rendezvous.save(p);
	}
 
	@PutMapping(value = "/listeRdv/{id}")
	public Rendezvous update(@PathVariable(name="id") Integer id,@RequestBody Rendezvous p) {
		p.setIdRendezVous(id);
	   return rendezvous.save(p);
	}
	
	@DeleteMapping(value = "/listeRdv/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		rendezvous.deleteById(id);
	}
}
