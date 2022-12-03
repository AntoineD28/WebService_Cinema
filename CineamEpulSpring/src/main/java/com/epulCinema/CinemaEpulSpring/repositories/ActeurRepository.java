package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityActeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepository extends JpaRepository<EntityActeur, Integer> {
}
