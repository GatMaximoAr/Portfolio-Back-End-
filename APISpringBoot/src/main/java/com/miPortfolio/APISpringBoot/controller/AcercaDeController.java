/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.service.AcercaDeService;
import com.miPortfolio.APISpringBoot.model.AcercaDe;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* Controler de end point AcercaDe */


@CrossOrigin (origins = "http://localhost:8080")
@RestController
public class AcercaDeController {
    
    // 2 injecciones necesarias
    
    @Autowired private AcercaDeService serviceAcerca;
    @Autowired private UsuarioService serviceUsuario;
    
    //Crea si no hay registros, else Mensaje
    
    @PostMapping ("acerca/usuario/{id}/crear")
    public String saveUsuarios(@PathVariable Long id, @RequestBody AcercaDe acerca) {
        
        Usuario user = serviceUsuario.getUsuarioById(id);
        
        if (user.getAcerca() == null) {
            
            acerca.setUsuario_id(user);
            
            serviceAcerca.saveAcercaDe(acerca);
            
            return "No habia registros, registro creado";
        }else {
            
            return "Error: un usuario solo puede tener un 'acerca de'"
                    + "Modifique o borre el existente, para continuar";
        } 
        
    }
    
    //Trae todos
    
    @GetMapping ("/acerca/usuario/traer")
    public List<AcercaDe> getAllUsuarios() {
        
        return serviceAcerca.getAllAcercaDe();
    }
    
    //trae 1 por id
    
    @GetMapping ("/acerca/{id}/traer")
    public AcercaDe getAcercaDeById(@PathVariable Long id) {
        
        return serviceAcerca.getAcercaDeById(id);
    }
    
    //edita 1 por id 
    
    @PutMapping ("/acerca/editar/{id}")
    public ResponseEntity<AcercaDe> editAcercaDe(@PathVariable Long id,
                               @RequestParam String nombre_usuario,
                               @RequestParam String apellido_usuario,
                               @RequestParam String imagen,
                               @RequestParam String sobre_usuario,
                               @RequestParam String ocupacion) {
        
        
        
        AcercaDe editAcerca = serviceAcerca.getAcercaDeById(id);
        
        editAcerca.setNombre_usuario(nombre_usuario);
        editAcerca.setApellido_usuario(apellido_usuario);
        editAcerca.setImagen(imagen);
        editAcerca.setSobre_usuario(sobre_usuario);
        editAcerca.setOcupacion(ocupacion);
        serviceAcerca.saveAcercaDe(editAcerca);
        
        return new ResponseEntity<>(editAcerca, HttpStatus.OK);
    }
}
