package com.cemedo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cemedo.data.Logistique;

@CrossOrigin("*")
@RepositoryRestResource
public interface ILogistique extends JpaRepository<Logistique, Integer>{

}
