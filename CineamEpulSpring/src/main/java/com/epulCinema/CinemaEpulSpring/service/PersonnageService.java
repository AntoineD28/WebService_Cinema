package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityPersonnage;
import com.epulCinema.CinemaEpulSpring.repositories.PersonnageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService {
    private PersonnageRepository personnageRepository;

    public PersonnageService(PersonnageRepository pR){this.personnageRepository = pR;}

    public void saveOrUpdate(EntityPersonnage pers){
        personnageRepository.save(pers);
    }
}
