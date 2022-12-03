package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<EntityCategorie, String> {
}
