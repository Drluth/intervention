package com.institutsaintjean.GestionsDesInterventions.Controller;

import com.institutsaintjean.GestionsDesInterventions.Repository.PersonnelRepository;
import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.service.UtilisateurService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerPersonnel {
//    @Autowired
//    private PersonnelRepository repository;
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String loginForm() {

        return "loginpage";
    }

    @RequestMapping("/")
    public String loginPage(){
        return "loginpage";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model, Personnel personnel) {


//        if(!employe.equals()){
//            model.addAttribute("notActive", true);
//        }
        model.addAttribute("loginError", true);
        return "loginpage";

    }
    @RequestMapping("/accueil")
    public String login(){
        System.out.println(utilisateurService.UtilisateurConnecter().getRoles());
        if(utilisateurService.UtilisateurConnecter().getRoles().equals("Etudiant")){
            return "homepage";
        }else {
            System.out.println(0000);
            return "index-personel";
        }
//        System.out.println(principal);
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        System.out.printf(authentication.getAuthorities().toString());
//        System.out.printf(authentication.getPrincipal().toString());
//        System.out.printf(authentication.getCredentials().toString());

    }


    @RequestMapping("/access-denied")
    public String accesrefuse(){
        return "accesrefuse";
    }

    @RequestMapping("/erreur404")
    public String errornotfound(HttpServletRequest request, ch.qos.logback.core.model.Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        System.out.println(status);
        return "error404";
    }

}
