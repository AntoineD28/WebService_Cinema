package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "film")
public class EntityFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nofilm;
    @Column(name="titre")
    private String titre;
    @Column(name="duree")
    private int duree;
    @Column(name="datesortie")
    private Date dateSortie;
    @Column(name="budget")
    private int budget;
    @Column(name="montantrecette")
    private int montantRecette;

    @ManyToOne
    @JoinColumn(name="norea")
    private EntityRealisateur realisateur;

    @ManyToOne
    @JoinColumn(name = "codecat")
    private EntityCategorie categorie;

    @OneToMany(mappedBy = "film")
    private List<EntityPersonnage> personnages;

    public EntityFilm(){}

    public int getNoFilm() {
        return nofilm;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public int getBudget() {
        return budget;
    }

    public int getMontantRecette() {
        return montantRecette;
    }

    public EntityRealisateur getRealisateur() {
        return realisateur;
    }

    public EntityCategorie getCategorie() {
        return categorie;
    }

    public List<EntityPersonnage> getPersonnages() {
        return personnages;
    }
}
