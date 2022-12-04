
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{
    
    /* 
        Tabla usuario Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator (name = "usuario_generator", sequenceName = "usuario_sq")
    private Long id;
    
    /* Nombre de las columnas customizado*/
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "password")
    private String password;
    
    /* Relacion 1-1 con clase entidad "AcercaDe", (no fuciona como quisiera)  */
    
  
    
    /*Relacion uno a muchos con clase entity "Experiencia" */
    
    @JsonBackReference (value = "experiencia")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Experiencia> exp;  // cambiar a experiencias
    
    
    /*Relacion uno a muchos con clase entity "Educacion" */
    
    @JsonBackReference (value = "formaciones")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Educacion> formaciones;
    
    /*Relacion uno a muchos con clase entity "Proyecto" */
    
    @JsonBackReference (value = "proyectos")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Proyecto> proyectos;
    
    /* Costructores*/
    
    public Usuario() {}

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
}
