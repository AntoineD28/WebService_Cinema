package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityUtilisateur;
import com.epulCinema.CinemaEpulSpring.repositories.EntityUtilisateurRepository;
import com.epulCinema.CinemaEpulSpring.service.JwtUserDetailsService;
import com.epulCinema.CinemaEpulSpring.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.epulCinema.CinemaEpulSpring.config.JwtTokenUtil;
import com.epulCinema.CinemaEpulSpring.domains.JwtResponse;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    private EntityUtilisateurRepository unUtilisateurRepostory;

    private UtilisateurService utilisateurService;
    // on initialise
    @Autowired
    public JwtAuthenticationController(EntityUtilisateurRepository UtilisateurRepostory, UtilisateurService us) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
        this.utilisateurService = us;
    }
    // auhentification  qui va généré un jeton
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody EntityUtilisateur unUti)
            throws Exception {
        try {
            UserDetails userDetails= appelAuthentication(unUti.getNomUtil(), unUti.getMotPasse());
            final String token = jwtTokenUtil.generateToken(userDetails);
            EntityUtilisateur utilisateur = utilisateurService.getUtilisateur(unUti.getNomUtil());
            return ResponseEntity.ok(new JwtResponse(token, utilisateur.getNumUtil(), utilisateur.getNomUtil(), utilisateur.getRole()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    private UserDetails appelAuthentication(String username, String password) throws Exception {

        try {
            Authentication  authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails= (UserDetails) authentication.getPrincipal();
            return userDetails;
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
