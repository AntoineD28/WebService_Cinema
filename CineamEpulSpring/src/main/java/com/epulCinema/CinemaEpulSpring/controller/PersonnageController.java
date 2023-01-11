package com.epulCinema.CinemaEpulSpring.controller;


import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import com.epulCinema.CinemaEpulSpring.domains.EntityPersonnage;
import com.epulCinema.CinemaEpulSpring.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/personnages")
public class PersonnageController {
    @Autowired
    private PersonnageService personnageService;

    @PostMapping("/create")
    public String createPersonnage(@RequestBody EntityPersonnage pers){
        personnageService.saveOrUpdate(pers);
        return pers.getNomPers();
    }

    @PutMapping("/update")
    public void updatePersonnage(@RequestBody EntityPersonnage perso){
        personnageService.saveOrUpdate(perso);
    }

    /*@GetMapping("byFilm/{id}")
    public List<EntityPersonnage> getPersonnageByFilm(@PathVariable(value= "id")int id){
        List<EntityPersonnage> personnages = null;
        personnages = personnageService.getPersonnagesByFilmId(id);
        return personnages;
    }*/
}
