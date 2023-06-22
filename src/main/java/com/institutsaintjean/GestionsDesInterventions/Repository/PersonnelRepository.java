package com.institutsaintjean.GestionsDesInterventions.Repository;

import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

//    Optional<Personnel> findPersonnelById(int Email);
}
