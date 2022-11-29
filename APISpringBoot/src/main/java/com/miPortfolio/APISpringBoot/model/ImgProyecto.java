
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table (name = "imgProyectos")
@Setter @Getter
@Entity
public class ImgProyecto implements Serializable{
    
   
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "imgProyecto_generator")
    @SequenceGenerator (name = "imgProyecto_generator", sequenceName = "imgProyecto_sq", initialValue = 1)
    private Long id;
    
    private String imagen;
    
    private String nombre_img;
    
    private String viculo_img;
    
    /*Relacion ManyToMany entre Actividad --> Experiencia*/
    
    @JsonBackReference          //Serialzacion Json
    @ManyToMany (mappedBy = "imgs")
    private Set<Proyecto> proyectos;

    /* Costructores*/
    
    public ImgProyecto() {
    }

    public ImgProyecto(String imagen, String nombre_img, String viculo_img) {
        this.imagen = imagen;
        this.nombre_img = nombre_img;
        this.viculo_img = viculo_img;
    }

    

    
    
    
}
