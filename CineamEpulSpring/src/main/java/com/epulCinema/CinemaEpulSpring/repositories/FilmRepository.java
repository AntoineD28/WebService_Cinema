package com.epulCinema.CinemaEpulSpring.repositories;

import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<EntityFilm, Integer> {

    @Query("SELECT EF " +
            "FROM film EF, categorie EC " +
            "WHERE EF.categorie = EC and EC.codecat = :codeCategorie")
    public List<EntityFilm> findByCodeCat(String codeCategorie);

    @Query("SELECT P.film " +
            "FROM personnage P, acteur A " +
            "WHERE P.acteur = A and A.noact = :noAct")
    public List<EntityFilm> findByNoAct(int noAct);

}
