/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
//proximo inicio de 0 BD custimizar table name
public class Experiencia implements Serializable{
    
    /* 
        Tabla experiencia Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "exp_generator")
    @SequenceGenerator (name = "exp_generator", sequenceName = "exp_sq", initialValue = 1)
    private Long id;
    
    /* Nombre de las columnas customizado*/
    
    @Column(name ="imgen_experiencia" )
    private String img_experiencia;
    
    @Column(columnDefinition = "TEXT")
    private String sobre_experiencia;
    
    /*Relacion muchos a uno con clase entity "Usuario" */

    @JsonBackReference  //Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    /* Costructores*/
    
    public Experiencia() {
    }

    public Experiencia(String img_experiencia, String sobre_experiencia, Usuario user) {
        this.img_experiencia = img_experiencia;
        this.sobre_experiencia = sobre_experiencia;
        this.user = user;
    }

    
    
    
}
