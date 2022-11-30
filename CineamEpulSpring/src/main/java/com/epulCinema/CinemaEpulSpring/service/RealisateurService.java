package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityRealisateur;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.RealisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService {
    private RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository aR){this.realisateurRepository = aR;}

    public EntityRealisateur getUnRealisateurID(int id) {
        return realisateurRepository.findById(id).orElseThrow(
                () -> new MonException("Realisateur", "id", id)
        );
    }
}
