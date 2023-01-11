package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "acteur")
public class EntityActeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noact;
    @Column(name = "nomact")
    private String nomAct;
    @Column(name = "prenact")
    private String prenAct;
    @Column(name = "datenaiss")
    private Date dateNaiss;
    @Column(name = "datedeces")
    private Date dateDeces;

    @OneToMany(mappedBy = "acteur", cascade = CascadeType.ALL)
    private List<EntityPersonnage> personnages;

    public List<EntityPersonnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(List<EntityPersonnage> personnages) {
        this.personnages = personnages;
    }

    public EntityActeur(){
    }

    public int getNoAct() {
        return noact;
    }

    public String getNomAct() {
        return nomAct;
    }

    public String getPrenAct() {
        return prenAct;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public int getNoact() {
        return noact;
    }

    public void setNoact(int noact) {
        this.noact = noact;
    }

    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

    public void setPrenAct(String prenAct) {
        this.prenAct = prenAct;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public Date getDateDeces() {
        return dateDeces;
    }
}
