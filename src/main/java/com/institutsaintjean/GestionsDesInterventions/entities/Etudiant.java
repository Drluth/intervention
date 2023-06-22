package com.institutsaintjean.GestionsDesInterventions.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricule;

    @Column(length =255,nullable = false)
    private String nom_Etudiant;

    @Column(length =255,nullable = false)
    private String Prenom_Etudiant;

    @Column(length = 255,nullable = false)
    private String  code_authentification;

    @Column(length =255,nullable = false)
    private String email;

    @Column(length =105,nullable = false)
    private String created_date;
//
//    @OneToMany
//    private Set<Intervention> interventions;


}
