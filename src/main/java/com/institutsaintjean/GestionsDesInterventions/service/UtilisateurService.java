package com.institutsaintjean.GestionsDesInterventions.service;

import com.institutsaintjean.GestionsDesInterventions.Repository.PersonnelRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.UtilisateurRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    public int UtilisateurConnectere(){

        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String address ="";
        if(principal instanceof UserDetails){
            String username=((UserDetails)principal).getUsername();
            //String mtp=((UserDetails)principal).
            System.out.println(username);
            address =username;
        }else {
            String username=principal.toString();
            System.out.println(username);
            address =username;
        }

        Optional<Utilisateur> utilisateurs=utilisateurRepository.findUtilisateurByEmail(address);

        return  utilisateurs.get().getPersonnel();
    }

    public Personnel personnelConnecter(int id){
      Personnel personnel=personnelRepository.getReferenceById(id);
      return personnel;
    }
    public Utilisateur UtilisateurConnecter(){

        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String address ="";
        if(principal instanceof UserDetails){
            String username=((UserDetails)principal).getUsername();
            //String mtp=((UserDetails)principal).
            System.out.println(username);
            address =username;
        }else {
            String username=principal.toString();
            System.out.println(username);
            address =username;
        }

        Optional<Utilisateur> utilisateurs=utilisateurRepository.findUtilisateurByEmail(address);
        return utilisateurs.get();
    }

}
