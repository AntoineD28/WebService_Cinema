package com.epulCinema.CinemaEpulSpring.controller;

import com.epulCinema.CinemaEpulSpring.domains.EntityUtilisateur;
import com.epulCinema.CinemaEpulSpring.repositories.EntityUtilisateurRepository;
import com.epulCinema.CinemaEpulSpring.service.JwtUserDetailsService;
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

    // on initialise
    @Autowired
    public JwtAuthenticationController(EntityUtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }
    // auhentification  qui va généré un jeton
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody EntityUtilisateur unUti)
            throws Exception {
        try {
            // On contrôle l'utilisateur
            UserDetails userDetails= appelAuthentication(unUti.getNomUtil(), unUti.getMotPasse());
            // on récupère les informations
            // nouvel accès à la base de données
            //final UserDetails userDetails = userDetailsService.loadUserByUsername(unUti.getNomUtil());
            // On génère le jeton
            final String token = jwtTokenUtil.generateToken(userDetails);
            // on retourne le jeton dans un flux json
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Demande d'authentification à l'aide de l'objet instancié précédemment
    // La méthode authenticate() appellera la méthode loadUserByUsername() de la classe UserDetailsServiceImpl
    // L'objet autentication contiendra l'objet userDetails dans la propriété principal
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