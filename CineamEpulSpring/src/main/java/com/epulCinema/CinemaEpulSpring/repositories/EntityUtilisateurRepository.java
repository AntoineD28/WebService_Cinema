package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityUtilisateurRepository extends JpaRepository<EntityUtilisateur, Integer> {

   public EntityUtilisateur rechercheNom(String login);

   public EntityUtilisateur findByNomUtil(String nomUtil);
}
