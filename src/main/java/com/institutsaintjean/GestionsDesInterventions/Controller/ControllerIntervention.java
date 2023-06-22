package com.institutsaintjean.GestionsDesInterventions.Controller;

import com.institutsaintjean.GestionsDesInterventions.Repository.EtudiantRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.InterventionRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Etudiant;
import com.institutsaintjean.GestionsDesInterventions.entities.Intervention;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.service.InterventionService;
import com.institutsaintjean.GestionsDesInterventions.service.PersonnelService;
import com.institutsaintjean.GestionsDesInterventions.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ControllerIntervention {

    @Autowired
    private InterventionService interventionService;
    @Autowired
    private InterventionRepository interventionRepository;
    @Autowired
    private PersonnelService personnelService;
   @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private EtudiantRepository etudiantRepository;



    @GetMapping("/filtrePersonInter")
    public String filtreInterP(Model model){
     List<Intervention> interventionList=personnelService.ListInterventionParDepartement();
     List<Etudiant> etudiant=new ArrayList<>();
    for (Intervention intervention : interventionList) {
        etudiant.add(etudiantRepository.getReferenceById(intervention.getMatricule_Etudiant()));
     }

        model.addAttribute("interventions",interventionList);
        model.addAttribute("Etudiant",etudiant);
        return "listeintervention";
    }











    @GetMapping("/demande-intervention")
    public String listPersonnel(Model model){
        Intervention intervention=new Intervention();
        model.addAttribute("Intervention",intervention);
        return "demande-intervention";
    }

    @PostMapping("/AjouterIntervention")
    public String New_intervention(@ModelAttribute("Intervention") Intervention intervention,Model model){
//        Personnel personnel=new Personnel();
//        personnel= personnelService.PersonnelConnecter();
        String statut="Non traite";

        LocalDate dated=LocalDate.now();
        String date =dated.toString();
        System.out.printf(String.valueOf(utilisateurService.UtilisateurConnecter().getMatricule()));
        intervention.setMatricule_Etudiant(utilisateurService.UtilisateurConnecter().getMatricule());
        intervention.setStatut(statut);
        intervention.setDate_creation(date);
        interventionRepository.save(intervention);

        List<Intervention> interventions=interventionRepository.findAll();
        model.addAttribute("Interventtion",interventions);

        return "demande-intervention";
    }

    @GetMapping("/listeDemande-etudiant")
    public String filtreInter(Model model){
        List<Intervention> interventionOptional=interventionRepository.findAll();
        List<Intervention> interventionList=new ArrayList<>();
        Intervention interventions=new Intervention();

        for (Intervention intervention : interventionOptional) {
            System.out.println(utilisateurService.UtilisateurConnecter().getMatricule());

            if(Objects.equals(intervention.getMatricule_Etudiant(), utilisateurService.UtilisateurConnecter().getMatricule())){
                System.out.println(utilisateurService.UtilisateurConnecter().getMatricule());
                interventionList.add(intervention);
            }
        }
        model.addAttribute("Intervention",interventionList);

        return "listeDemande-etudiant";
    }




}
