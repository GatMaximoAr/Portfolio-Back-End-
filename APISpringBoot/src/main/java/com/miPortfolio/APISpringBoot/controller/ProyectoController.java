/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.ProyectoService;
import com.miPortfolio.APISpringBoot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProyectoController {
    
    @Autowired private ProyectoService proService;
    
    @Autowired private UsuarioService userService;
    
    // Crea
    
    @PostMapping ("/proyecto/usuario/{id}/crear")
    public ResponseEntity<Proyecto> saveProyecto(@PathVariable Long id,
                                   @RequestBody Proyecto postProyec) {
                                   
        Usuario user = userService.getUsuarioById(id);
        postProyec.setUser(user);
        
        proService.saveProyecto(postProyec);
        
        return new ResponseEntity<>(postProyec, HttpStatus.OK);
    }
    
    
    //Trae todos
    
    @GetMapping ("/proyecto/traer")
    public List<Proyecto> getAllProyectos() {
        
        return proService.getAllProyectos();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/proyecto/{id}/traer")
    public Proyecto getProyectoById(@PathVariable Long id) {
        
        return proService.getProyectoById(id);
    }
    
    //Elimina 1 por id
    
    @DeleteMapping ("/proyecto/delete/{id}")
    public String deleteProyectoById(@PathVariable Long id) {
        
        proService.deleteProyectoById(id);
        
        return "Proyecto elimanado";
    }
    
    //Edita 1 por id 
    
    @PutMapping ("/proyecto/editar/{id}")
    public ResponseEntity<Proyecto>editarProyecto(@PathVariable Long id,
                                                @RequestParam String titulo) {
        
        
        Proyecto editProyec = proService.getProyectoById(id);
        editProyec.setTitulo(titulo);
        
        proService.saveProyecto(editProyec);
        
        
        return new ResponseEntity<>(editProyec, HttpStatus.OK);
    }
}
