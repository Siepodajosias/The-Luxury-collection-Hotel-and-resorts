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

import com.cemedo.data.Patient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api("API  Rest pour les opérations CRUD sur les patients")
public class PatientController {
	@Autowired
 private IPatient patient;
 
@ApiOperation(value = "Récupere la liste des patients")
 @GetMapping(value = "/listeP")
 public List<Patient> getListe(){
	  return patient.findAll();
 }
 
 @GetMapping(value = "/listeP/{id}")
 public Patient getListeId(@PathVariable(name = "id") Integer id){
	  return patient.findById(id).get();
 }
 
 
	@PostMapping(value = "/listeP")
	public Patient Enregistrer(@RequestBody Patient p) {
	     return  patient.save(p);
	}
 
	@PutMapping(value = "/listeP/{id}")
	public Patient update(@PathVariable(name="id") Integer id,@RequestBody Patient p) {
		p.setIdPatients(id);
	   return patient.save(p);
	}
	
	@DeleteMapping(value = "/listeP/{id}")
	public void supprimer(@PathVariable(name="id") Integer id) {
		patient.deleteById(id);
	}
}
