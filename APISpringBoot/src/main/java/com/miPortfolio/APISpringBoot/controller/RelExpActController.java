/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dao.ExperienciaDao;
import com.miPortfolio.APISpringBoot.dto.ExperienciaDto;
import com.miPortfolio.APISpringBoot.logica.LogicaExperiencia;
import com.miPortfolio.APISpringBoot.model.ActividadExp;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.RelExpAct;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelExpActController {
    
    @Autowired private RelExpActService relacionService;
    
    @Autowired private UsuarioService userService;
    
    @Autowired private ExperienciaService expService;
    
    @Autowired private ActividadExpService actService;
    
    @Autowired private LogicaExperiencia loicaService;
    
    
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
    
    @PostMapping("/relacioxp/usuario/{id}")
    public ResponseEntity<ExperienciaDto> crear(@RequestBody ExperienciaDao dao,
                                               @PathVariable Long id) {
    
        Usuario user = userService.getUsuarioById(id);
        
        return loicaService.CreateAndSave(dao, user);
    }
    
    @GetMapping("/relacionxp/traer")
    public List<ExperienciaDto> traerDtoRelaciones() {
        
        return loicaService.GetDtoRelacion();
    }
}
