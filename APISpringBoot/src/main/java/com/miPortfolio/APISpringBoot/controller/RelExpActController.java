/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.ActividadExp;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.RelExpAct;
import com.miPortfolio.APISpringBoot.service.ActividadExpService;
import com.miPortfolio.APISpringBoot.service.RelExpActService;
import com.miPortfolio.APISpringBoot.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelExpActController {
    
    @Autowired private RelExpActService relacionService;
    
    @Autowired private ExperienciaService expService;
    
    @Autowired private ActividadExpService actService;
    
    
    @PostMapping("/relacion/exp/{id}/act/{ids}/crear")
    public ResponseEntity<RelExpAct> saveEntity(@PathVariable Long id,
                                                @PathVariable Long ids) {
        
        Experiencia exp = expService.getExperienciaById(id);
        ActividadExp act = actService.getActividadExpById(ids);
        
        RelExpAct nuevaRel = new RelExpAct(exp, act);
        relacionService.saveRelacion(nuevaRel);
        
        return new ResponseEntity<>(nuevaRel, HttpStatus.CREATED);
    }
    
    @GetMapping("/relacion/traer")
    public List<RelExpAct> getAllRelaciones() {
        
        return relacionService.findAllRelaciones();
    }
}
