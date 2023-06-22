package com.institutsaintjean.GestionsDesInterventions.Repository;

import com.institutsaintjean.GestionsDesInterventions.entities.Etudiant;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

}
