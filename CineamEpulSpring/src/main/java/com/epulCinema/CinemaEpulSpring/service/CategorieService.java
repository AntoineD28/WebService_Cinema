package com.epulCinema.CinemaEpulSpring.service;

import com.epulCinema.CinemaEpulSpring.domains.EntityCategorie;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository cR){this.categorieRepository = cR;}

    public EntityCategorie getCategorieID(String code) {
        return categorieRepository.findById(code).orElseThrow(
                () -> new MonException("Client", "code", code)
        );
    }

    public List<EntityCategorie> getAllCategories(){
        return categorieRepository.findAll();
    }
}
