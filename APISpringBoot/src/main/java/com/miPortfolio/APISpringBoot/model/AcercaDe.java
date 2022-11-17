
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//proximo inicio de 0 BD custimizar table name
@Table (name = "acercaDe_usuarios")
@Entity
@Getter @Setter
public class AcercaDe implements Serializable{
    
    /* 
        Tabla Acerca_de_usuario Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "acercaDe_generator")
    @SequenceGenerator (name = "acercaDe_generator", sequenceName = "acercaDe_sq")
    private Long id_acercaDe;
    
    /* Nombre de las columnas customizado*/
    
    @Column (name = "nombre")
    private String nombre_usuario;
    
    @Column (name = "apellido")
    private String apellido_usuario;
    
    @Column (name = "imagem")
    private String imagen;
    
    @Column (columnDefinition = "TEXT", name = "sobre_usuario")
    private String sobre_usuario;
    
    @Column (name = "ocupacion")
    private String ocupacion;
    
    /* Relacion 1-1 con clase entidad "Usuario", (no fuciona como quisiera: no se
        se puede borrar unicamente el registro AcercaDe asociado, depende de 
        la existencia de father) children */
    
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario_id;

    /* Costructores*/
    
    public AcercaDe() {
    }

    public AcercaDe(String nombre_usuario, String apellido_usuario, String imagen, String sobre_usuario, String ocupacion) {
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.imagen = imagen;
        this.sobre_usuario = sobre_usuario;
        this.ocupacion = ocupacion;
    }

    
    
    
}
