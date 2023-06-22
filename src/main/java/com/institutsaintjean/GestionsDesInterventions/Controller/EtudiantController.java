package com.institutsaintjean.GestionsDesInterventions.Controller;

import com.institutsaintjean.GestionsDesInterventions.entities.Etudiant;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class EtudiantController {


    @GetMapping("/users_profile")
    public String users_profile(Model model){
        Etudiant etudiant=new Etudiant();
       // model.addAttribute("etudiant",etudiant);
        return "users_profile";
    }

    @PostMapping("/change user")
    public String New_intervention(@ModelAttribute("etudiant") Etudiant etudiant, Model model){



        return "users_profile";
    }
}
