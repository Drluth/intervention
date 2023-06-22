package com.institutsaintjean.GestionsDesInterventions.Repository;

import com.institutsaintjean.GestionsDesInterventions.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
    //List<Reponse> findByDepartement(int b);
}
