package com.epulCinema.CinemaEpulSpring.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "personnage")
@IdClass(EntityPersonnageID.class)
public class EntityPersonnage {

    @Column(name = "nompers")
    private String nomPers;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="noact")
    @JsonIgnoreProperties("personnages")
    private EntityActeur acteur;

    @Id
    @ManyToOne
    @JoinColumn(name="nofilm")
    @JsonIgnoreProperties("personnages")
    private EntityFilm film;

    public EntityPersonnage(){
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setFilm(EntityFilm film){
        this.film=film;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public void setActeur(EntityActeur acteur) {
        this.acteur = acteur;
    }

    public EntityActeur getActeur() {
        return acteur;
    }

    public EntityFilm getFilm() {
        return film;
    }
}

