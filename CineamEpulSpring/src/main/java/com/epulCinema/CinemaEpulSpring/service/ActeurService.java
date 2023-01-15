package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityActeur;
import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.ActeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {
    private ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository aR){this.acteurRepository = aR;}

    public EntityActeur getUnClientID(int id) {
        return acteurRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public List<EntityActeur> getAllActeurs(){
        return acteurRepository.findAll();
    }
}
