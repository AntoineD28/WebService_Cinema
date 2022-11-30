package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityActeur;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.ActeurRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonnageService {
    private ActeurRepository acteurRepository;

    public PersonnageService(ActeurRepository aR){this.acteurRepository = aR;}

    public EntityActeur getUnClientID(int id) {
        return acteurRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
}
