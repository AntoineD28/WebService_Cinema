package com.epulCinema.CinemaEpulSpring.domains;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private int numUtil;
    private String nomUtil;
    private String role;

    public JwtResponse(String jwttoken, int numUtil, String nomUtil, String role) {
        this.jwttoken = jwttoken;
        this.numUtil=numUtil;
        this.nomUtil=nomUtil;
        this.role=role;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public int getNumUtil() {
        return numUtil;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public String getRole() {
        return role;
    }
}
