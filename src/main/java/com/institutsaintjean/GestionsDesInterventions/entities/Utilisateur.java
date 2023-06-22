package com.institutsaintjean.GestionsDesInterventions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_utilisateur;
    private String mot_de_passe;
    private String roles;
    private  int matricule;
    private  int personnel;
    private String email ;
}
