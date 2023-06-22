package com.institutsaintjean.GestionsDesInterventions.Repository;

import com.institutsaintjean.GestionsDesInterventions.entities.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface InterventionRepository extends JpaRepository<Intervention,Integer> {
   //List<Intervention> findInterventionsByMatricule_Etudiant(String s);
   //List<Intervention> findInterventionByDepartement(String departement);

}
