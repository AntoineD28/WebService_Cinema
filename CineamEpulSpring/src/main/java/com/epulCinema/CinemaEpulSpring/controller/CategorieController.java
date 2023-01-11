package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityCategorie;
import com.epulCinema.CinemaEpulSpring.mesExceptions.MonException;
import com.epulCinema.CinemaEpulSpring.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/{id}")
    public String get(@PathVariable(value = "id") String id) {
        EntityCategorie categorie = null;
        try {
            categorie = categorieService.getCategorieID(id);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return categorie.getLibelleCat();
    }

    @GetMapping("/all")
    public List<EntityCategorie> getAll(){
        List<EntityCategorie> categories= new ArrayList<>();
        try{
            categories = categorieService.getAllCategories();
        }catch(MonException e){
            ResponseEntity.notFound().build();
        }catch(Exception e){
            ResponseEntity.notFound().build();
        }
        return categories;
    }
}
