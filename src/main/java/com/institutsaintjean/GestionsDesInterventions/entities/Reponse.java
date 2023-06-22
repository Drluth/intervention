package com.institutsaintjean.GestionsDesInterventions.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_reponse;


    private int intervention_id;

    @Column(length =255,nullable = false)
    private String date_reponse;

    @Column(length =255,nullable = false)
    private String Contenu;

    @Column(length =255,nullable = false)
    private String departement;

    private int personnel;



}
