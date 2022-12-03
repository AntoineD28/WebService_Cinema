package com.epulCinema.CinemaEpulSpring.domains;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity(name = "categorie")
public class EntityCategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codecat;
    @Column(name = "libellecat")
    private String libelleCat;
    @Column(name = "image")
    private String image;

    public EntityCategorie(){}

    public String getCodecat() {
        return codecat;
    }

    public String getLibelleCat() {
        return libelleCat;
    }

    public String getImage() {
        return image;
    }
}
