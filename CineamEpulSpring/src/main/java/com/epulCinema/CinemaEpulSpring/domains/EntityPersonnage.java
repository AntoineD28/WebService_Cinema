package com.epulCinema.CinemaEpulSpring.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;

@Entity(name = "personnage")
@IdClass(EntityPersonnageID.class)
public class EntityPersonnage {

    @Column(name = "nompers")
    private String nomPers;

    @Id
    @ManyToOne
    @JoinColumn(name="noact")
    //@JsonIgnore
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

    /*public EntityActeur getActeur() {
        return acteur;
    }

    public EntityFilm getFilm() {
        return film;
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityPersonnage that = (EntityPersonnage) o;
        return Objects.equals(nomPers, that.nomPers) &&
                Objects.equals(acteur, that.acteur) &&
                Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomPers, acteur, film);
    }*/
}

