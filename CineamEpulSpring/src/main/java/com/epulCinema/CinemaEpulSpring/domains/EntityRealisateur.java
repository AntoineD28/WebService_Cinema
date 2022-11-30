package com.epulCinema.CinemaEpulSpring.domains;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "realisateur")
public class EntityRealisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int norea;
    @Column(name = "nomrea")
    private String nomRea;
    @Column(name = "prenrea")
    private String prenRea;

    public EntityRealisateur(){
    }

    public int getNorea() {
        return norea;
    }

    public String getNomRea() {
        return nomRea;
    }

    public String getPrenRea() {
        return prenRea;
    }
}
