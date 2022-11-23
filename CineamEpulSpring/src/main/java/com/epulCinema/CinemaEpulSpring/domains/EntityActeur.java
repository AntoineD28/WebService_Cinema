package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.util.Date;

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

    public Date getDateDeces() {
        return dateDeces;
    }
}
