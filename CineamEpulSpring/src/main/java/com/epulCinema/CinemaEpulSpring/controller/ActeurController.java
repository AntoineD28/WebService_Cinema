package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityActeur;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.ActeurRepository;
import com.epulCinema.CinemaEpulSpring.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private ActeurRepository acteurRepository;

    /*@GetMapping("/{id}")
    public Optional<EntityActeur> get(@PathVariable(value="id")int id){
        return acteurRepository.findById(id);
    }*/

    @GetMapping("/{id}")
    public EntityActeur get(@PathVariable(value= "id")int id) {
        EntityActeur acteur =null;
        try{
            acteur = acteurService.getUnClientID(id);
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return acteur;
    }

}
