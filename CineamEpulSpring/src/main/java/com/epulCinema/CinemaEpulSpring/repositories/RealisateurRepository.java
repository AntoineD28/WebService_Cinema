package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityRealisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisateurRepository extends JpaRepository<EntityRealisateur, Integer> {
}
