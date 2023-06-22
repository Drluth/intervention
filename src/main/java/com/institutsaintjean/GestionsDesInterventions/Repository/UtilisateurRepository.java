package com.institutsaintjean.GestionsDesInterventions.Repository;

import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer > {

    Optional<Utilisateur> findEmployeByEmail(String email);
    Optional<Utilisateur> findUtilisateurByEmail(String email);
}
