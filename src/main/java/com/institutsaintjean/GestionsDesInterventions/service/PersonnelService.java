package com.institutsaintjean.GestionsDesInterventions.service;

import com.institutsaintjean.GestionsDesInterventions.Repository.InterventionRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Intervention;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonnelService {

   @Autowired
   private UtilisateurService utilisateurService;
   @Autowired
   private InterventionRepository interventionRepository;
    //private PersonnelRepository personnelRepository;

    //private UtilisateurRepository utilisateurRepository;
    /*public Personnel PersonnelConnecter(){

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

        Optional<Personnel> personnels=personnelRepository.findEmployeByEmail(address);
        return personnels.get();
    }*/


    public List ListInterventionParDepartement(){
        Personnel personnel=new Personnel();
        personnel=utilisateurService.personnelConnecter(utilisateurService.UtilisateurConnectere());
        List<Intervention> interventionOptional=interventionRepository.findAll();
        List<Intervention> interventionList=new ArrayList<>();
        Intervention interventions=new Intervention();
        for (Intervention intervention : interventionOptional) {
            if(intervention.getDepartement().equals(personnel.getDepartement())){
                interventions=intervention;
                interventionList.add(interventions);
            }

        }
        return interventionList;
    }

}
