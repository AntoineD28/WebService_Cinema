package com.epulCinema.CinemaEpulSpring.service;

import java.util.ArrayList;

import com.epulCinema.CinemaEpulSpring.domains.EntityUtilisateur;
import com.epulCinema.CinemaEpulSpring.repositories.EntityUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private EntityUtilisateurRepository unUtilisateurRepostory;

    // on initialise
    @Autowired
    public JwtUserDetailsService(EntityUtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    EntityUtilisateur unUtilisateur = null;
    // on accède à l'utilisateur
    unUtilisateur = unUtilisateurRepostory.rechercheNom(username);
    if (unUtilisateur != null) {
        return new User(unUtilisateur.getNomUtil(), unUtilisateur.getMotPasse(),
                new ArrayList<>());
    } else {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
}