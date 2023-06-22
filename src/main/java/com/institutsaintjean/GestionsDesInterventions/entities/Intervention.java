package com.institutsaintjean.GestionsDesInterventions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Intervention;

    @Column(length =255,nullable = false)
    private String Date_creation;

    @Column(length =255,nullable = false)
    private String statut;

    @Column(length =255,nullable = false)
    private String departement;

    @Column(length =255,nullable = false)
    private String Contenu;

    private int matricule_Etudiant;





}
