package com.institutsaintjean.GestionsDesInterventions.Controller;

import com.institutsaintjean.GestionsDesInterventions.Repository.EtudiantRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.InterventionRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.PersonnelRepository;
import com.institutsaintjean.GestionsDesInterventions.Repository.ReponseRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Etudiant;
import com.institutsaintjean.GestionsDesInterventions.entities.Intervention;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.entities.Reponse;
import com.institutsaintjean.GestionsDesInterventions.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ControllerReponse {

    @Autowired
    private ReponseRepository reponseRepository;
    @Autowired
    private InterventionRepository interventionRepository;
    @Autowired
    private UtilisateurService utilisateurService;
    private EtudiantRepository etudiantRepository;
    private PersonnelRepository personnelRepository;
    @GetMapping("/Repondre/{id_Intervention}")
    public String reponse(@PathVariable(value = "id_Intervention") int id_Intervention, Model model){
        Reponse reponse=new Reponse();
        Optional<Intervention> intervention=interventionRepository.findById(id_Intervention);
        intervention.get().setStatut("En cours de traitement");
        interventionRepository.save(intervention.get());
        reponse.setIntervention_id(id_Intervention);
        LocalDate dated=LocalDate.now();
        String date =dated.toString();
        System.out.println(15555);
        reponse.setPersonnel(utilisateurService.UtilisateurConnectere());
        reponse.setDate_reponse(date);
        reponse.setContenu(" ");
        reponse.setDepartement(intervention.get().getDepartement());
        reponseRepository.save(reponse);
        model.addAttribute("Reponse",reponse);
        return "redirect:/triat";
    }

    @GetMapping("/triat")
    public String moder(Model model){
        Reponse reponse=new Reponse();
        model.addAttribute("Reponse",reponse);
        return "traitement-personel";
    }
    @PostMapping("/reponseInter")
    public String envoiereponse(@ModelAttribute("Reponse") Reponse reponse,Model model){
        List<Reponse> reponseList=reponseRepository.findAll();
        int indice=reponseList.get(reponseList.size()-1).getId_reponse();
        Optional<Reponse> reponse1=reponseRepository.findById(indice);
        reponse1.get().setContenu(reponse.getContenu());
        reponseRepository.save(reponse1.get());
        model.addAttribute("Reponse",reponse1);
        Optional<Intervention> intervention=interventionRepository.findById(reponse1.get().getIntervention_id());
        intervention.get().setStatut("Traiter");
        interventionRepository.save(intervention.get());
        Etudiant etudiant=new Etudiant();
        etudiant=etudiantRepository.getReferenceById(intervention.get().getMatricule_Etudiant());
        model.addAttribute("Etudiant",etudiant);
        return "redirect:/ListeReponse";
    }

    @GetMapping("/ListeReponse")
    public  String Listereponse(Model model){
        List<Reponse>reponseList=reponseRepository.findAll();
        List<Reponse> reponses=new ArrayList<>();
        List<Intervention> interventionList=new ArrayList<>();
        List<Etudiant> etudiantList=new ArrayList<>();
        List<Personnel> personnels=new ArrayList<>();
        for (Reponse reponse : reponseList) {
            if (reponse.getDepartement().equals(utilisateurService.personnelConnecter(utilisateurService.UtilisateurConnectere()).getDepartement())){
                reponses.add(reponse);
                interventionList.add(interventionRepository.getReferenceById(reponse.getIntervention_id()));
                Intervention intervention=new Intervention();
                intervention=interventionRepository.getReferenceById(reponse.getIntervention_id());
                etudiantList.add(etudiantRepository.getReferenceById(intervention.getMatricule_Etudiant()));
                personnels.add(personnelRepository.getReferenceById(reponse.getPersonnel()));
            }
        }

        model.addAttribute("Reponse",reponses);
        model.addAttribute("Intervention",interventionList);
        model.addAttribute("Etudiant",etudiantList);
        model.addAttribute("Personnel",personnels);
      return "listereponse";
    }

}
