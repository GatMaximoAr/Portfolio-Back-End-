
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table (name = "actividades")
@Setter @Getter
@Entity
public class ActividadExp implements Serializable{
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "exp_act_generator")
    @SequenceGenerator (name = "exp_act_generator", sequenceName = "exp_act_sq", initialValue = 1)
    private Long id;
    
    @Column (name = "actividad")
    private String actividad;
    
    
    /*Relacion ManyToMany entre Actividad --> Experiencia*/
    
    @JsonBackReference(value = "expAc")          //Serialzacion Json
    @ManyToMany (mappedBy = "actividad")
    private Set<Experiencia> exps;

    
    /* Costructores*/
    
    public ActividadExp() {
    }

    public ActividadExp(String actividad) {
        this.actividad = actividad;
    }
    

}
