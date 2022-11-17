
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table (name = "proyectos")
@Setter @Getter
@Entity
public class Proyecto implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "proyecto_generator")
    @SequenceGenerator (name = "proyecto_generator", sequenceName = "proyecto_sq", initialValue = 1)
    private Long id;
    
    private String titulo;
    
    /*Relacion muchos a uno con clase entity "Usuario" */
    
    
    @JsonBackReference  //Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    
    /* Costructores*/

    public Proyecto() {
    }

    public Proyecto(String titulo, Usuario user) {
        this.titulo = titulo;
        this.user = user;
    }
    
    
}
