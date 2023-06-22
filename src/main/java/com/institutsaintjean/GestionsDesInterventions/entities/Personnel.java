package com.institutsaintjean.GestionsDesInterventions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Personnel")
public class Personnel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_personnel;

    @Column(length =255,nullable = false)
    private String Nom_personnel;

    @Column(length =255,nullable = false)
    private String Prenom_personnel;

    @Column(length =255,nullable = false)
    private String mot_de_passe;

    @Column(length =255,nullable = false)
    private String email;

    @Column(length =255,nullable = false)
    private String roles;

    @Column(length =255,nullable = false)
    private String departement;



}
