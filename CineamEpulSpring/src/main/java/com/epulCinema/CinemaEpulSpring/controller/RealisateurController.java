package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityRealisateur;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @PostMapping("/add")
    public int createFilm(@RequestBody EntityRealisateur realisateur){
        realisateurService.add(realisateur);
        return realisateur.getNorea();
    }

}
