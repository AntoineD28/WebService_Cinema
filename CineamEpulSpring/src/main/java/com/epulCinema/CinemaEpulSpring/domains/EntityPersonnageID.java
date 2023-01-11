package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EntityPersonnageID implements Serializable {
    @ManyToOne
    @JoinColumn(name="noact")
    private EntityActeur acteur;

    @ManyToOne
    @JoinColumn(name="nofilm")
    private EntityFilm film;

    @Column(name = "nompers")
    private String nomPers;

    public EntityActeur getActeur() {
        return acteur;
    }

    public void setActeur(EntityActeur acteur) {
        this.acteur = acteur;
    }

    public EntityFilm getFilm() {
        return film;
    }

    public void setFilm(EntityFilm film) {
        this.film = film;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityPersonnageID that = (EntityPersonnageID) o;
        return Objects.equals(acteur, that.acteur) && Objects.equals(film, that.film) && Objects.equals(nomPers, that.nomPers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acteur, film, nomPers);
    }
}
