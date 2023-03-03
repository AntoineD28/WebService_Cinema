package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityUtilisateur;
import com.epulCinema.CinemaEpulSpring.repositories.EntityUtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private EntityUtilisateurRepository utilisateurRepository;

    public UtilisateurService(EntityUtilisateurRepository uR){this.utilisateurRepository=uR;}

    public EntityUtilisateur getUtilisateur(String nomUtil){
        return utilisateurRepository.findByNomUtil(nomUtil);
    }
}
