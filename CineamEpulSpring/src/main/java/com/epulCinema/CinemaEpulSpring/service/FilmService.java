package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import com.epulCinema.CinemaEpulSpring.domains.EntityPersonnage;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    public FilmService(FilmRepository fR){this.filmRepository = fR;};

    public EntityFilm getFilmID(int id){
        return filmRepository.findById(id).orElseThrow(
                ()->new MonException("Film", "id", id)
        );
    }

    public List<EntityFilm> getFilmsByCategorie(String id){
        return filmRepository.findByCodeCat(id);
    }

    public List<EntityFilm> getFilmsByActeur(int id){
        return filmRepository.findByNoAct(id);
    }

    public List<EntityFilm> getAllFilms(){
        return filmRepository.findAll();
    }

    public void delete(int id){filmRepository.deleteById(id);}

    public void saveOrUpdate(EntityFilm film){
        for (EntityPersonnage pers : film.getPersonnages()){
            pers.setFilm(film);
        }
        filmRepository.save(film);}
}
