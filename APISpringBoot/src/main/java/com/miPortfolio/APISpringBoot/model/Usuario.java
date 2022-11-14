/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator (name = "usuario_generator", sequenceName = "usuario_sq")
    private Long id;
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "password")
    private String password;

    public Usuario() {}

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
}
