package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityActeur;
import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

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

    @GetMapping("/all")
    public List<EntityActeur> getAll(){
        List<EntityActeur> acteurs= new ArrayList<>();
        try{
            acteurs = acteurService.getAllActeurs();
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return acteurs;
    }
}
