package com.institutsaintjean.GestionsDesInterventions.config;

import com.institutsaintjean.GestionsDesInterventions.Repository.PersonnelRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.UtilisateurRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class EmployeDetailsService implements UserDetailsService {


  //  @Autowired
   // private PersonnelRepository personnelRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByEmail(email);
//        System.out.println(employe.map(EmployeDetails::new));
        return utilisateur.map(EmployeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

    }


}
