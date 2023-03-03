package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityPersonnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonnageRepository extends JpaRepository<EntityPersonnage, Integer> {

    /*@Query("SELECT P.film " +
            "FROM personnage P, acteur A " +
            "WHERE P.acteur = A and A.noact = :noAct")
    public List<EntityPersonnage> findALLByFilmId(int filmId);*/
}
