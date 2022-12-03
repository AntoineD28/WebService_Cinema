package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityRealisateur;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    @Autowired
    private RealisateurService realisateurService;


    @GetMapping("/{id}")
    public EntityRealisateur get(@PathVariable(value= "id")int id) {
        EntityRealisateur realisateur =null;
        try{
            realisateur = realisateurService.getUnRealisateurID(id);
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return realisateur;
    }



}
