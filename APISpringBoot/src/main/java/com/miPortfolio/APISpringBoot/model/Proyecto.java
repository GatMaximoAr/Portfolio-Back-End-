
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    
    //@JsonManagedReference(value = "el pro1")//Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    
    /*Relacion ManyToMany entre Experiencia --> Actividades*/
    
    @JoinTable(
        name = "rel_proyec_imgs",
            joinColumns = @JoinColumn(name = "FK_proyec"),
            inverseJoinColumns = @JoinColumn (name = "FK_img"))
    
   //@JsonBackReference(value = "el pro2")
  // @JsonManagedReference("pi")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ImgProyecto> imgs;
    
    
    /* Costructores*/

    public Proyecto() {
    }

    public Proyecto(String titulo, Usuario user) {
        this.titulo = titulo;
        this.user = user;
    }
    
    
    public void addImg(ImgProyecto img) {
        
        this.imgs.add(img);
    }
    
    public void removeObject(ImgProyecto img) {
        this.imgs.remove(img);
    }
}
