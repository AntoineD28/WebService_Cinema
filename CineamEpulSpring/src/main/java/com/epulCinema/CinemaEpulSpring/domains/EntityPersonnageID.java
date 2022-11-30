package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class EntityPersonnageID implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="noact")
    //@JsonIgnore
    private EntityActeur acteur;

    @Id
    @ManyToOne
    @JoinColumn(name="nofilm")
    private EntityFilm film;

    @Column(name = "nompers")
    private String nomPers;

}
