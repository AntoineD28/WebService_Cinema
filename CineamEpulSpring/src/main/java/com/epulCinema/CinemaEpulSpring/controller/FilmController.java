package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityFilm;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/films")
@CrossOrigin
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/{id}")
    public EntityFilm get(@PathVariable(value= "id")int id) {
        EntityFilm film =null;
        try{
            film = filmService.getFilmID(id);
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return film;
    }

    @GetMapping("/byCategorie/{id}")
    public List<EntityFilm> getByCategorie(@PathVariable(value = "id")String id){
        List<EntityFilm> films =new ArrayList<>();
        try{
            films = filmService.getFilmsByCategorie(id);
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return films;
    }

    @GetMapping("/byActeur/{id}")
    public List<EntityFilm> getByActeur(@PathVariable(value = "id")int id){
        List<EntityFilm> films =new ArrayList<>();
        try{
            films = filmService.getFilmsByActeur(id);
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return films;
    }

    @GetMapping("/all")
    public List<EntityFilm> getAll(){
        List<EntityFilm> films= new ArrayList<>();
        try{
            films = filmService.getAllFilms();
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return films;
    }

    @PostMapping("/create")
    public int createFilm(@RequestBody EntityFilm film){
        filmService.saveOrUpdate(film);
        return film.getNoFilm();
    }

    @DeleteMapping("delete/{id}")
    public void deleteFilm(@PathVariable("id")int id){
        filmService.delete(id);
    }

    @PutMapping("/update")
    public int updateFilm(@RequestBody EntityFilm film){
        filmService.saveOrUpdate(film);
        return film.getNoFilm();
    }
}
