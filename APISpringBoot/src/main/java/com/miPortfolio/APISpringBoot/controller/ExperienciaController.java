/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.ExperienciaService;
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

/* Controler de end point usuario */

@RestController
public class ExperienciaController {
    
    @Autowired private ExperienciaService expService;
    @Autowired private UsuarioService userService;
    
    // Crea
    
    @PostMapping ("/experiencia/usuario/{id}/crear")
    public ResponseEntity<Experiencia> saveExperiencias(@PathVariable Long id,
                                   @RequestBody Experiencia postExp) {
                                   
        Usuario user = userService.getUsuarioById(id);
        postExp.setUser(user);
        
        expService.saveExperiencia(postExp);
        
        return new ResponseEntity<>(postExp, HttpStatus.OK);
    }
    
    
    //Trae todos
    
    @GetMapping ("/experiencia/traer")
    public List<Experiencia> getAllExperiencias() {
        
        return expService.getAllExperiencias();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/experiencia/{id}/traer")
    public Experiencia getExperienciaById(@PathVariable Long id) {
        
        return expService.getExperienciaById(id);
    }
    
    //Elimina 1 por id
    
    @DeleteMapping ("/experiencia/delete/{id}")
    public String deleteExpById(@PathVariable Long id) {
        
        expService.deleteExperienciaById(id);
        
        return "Experiencia elimanado";
    }
    
    //Edita 1 por id 
    
    @PutMapping ("/experiencia/editar/{id}")
    public ResponseEntity<Experiencia>editarExperiencia(@PathVariable Long id,
                                                @RequestParam String img_experiencia,
                                                @RequestParam String sobre_experiencia) {
        
        
        Experiencia editExp = expService.getExperienciaById(id);
        editExp.setImg_experiencia(img_experiencia);
        editExp.setSobre_experiencia(sobre_experiencia);
        expService.saveExperiencia(editExp);
        
        
        return new ResponseEntity<>(editExp, HttpStatus.OK);
    }
}
