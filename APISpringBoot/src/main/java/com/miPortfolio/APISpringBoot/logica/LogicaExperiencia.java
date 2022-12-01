/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.ExperienciaDao;
import com.miPortfolio.APISpringBoot.dto.ExperienciaDto;
import com.miPortfolio.APISpringBoot.model.ActividadExp;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.RelExpAct;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.ActividadExpService;
import com.miPortfolio.APISpringBoot.service.RelExpActService;
import com.miPortfolio.APISpringBoot.service.ExperienciaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LogicaExperiencia {
    
    @Autowired private RelExpActService relacion;
    
    @Autowired private ExperienciaService expService;
    
    @Autowired private ActividadExpService actService;
    
    public ResponseEntity<ExperienciaDto> CreateAndSave(ExperienciaDao dao, Usuario user) {
        
       
        
        List<RelExpAct> relaciones = relacion.findAllRelaciones();
        
        Experiencia exp = new Experiencia(dao.getImg_experiencia(), dao.getImg_href(),
                dao.getSobre_experiencia(), user);
        
        expService.saveExperiencia(exp);
        
        ExperienciaDto expDto = new ExperienciaDto(exp.getId(), exp.getImg_experiencia(), exp.getImg_href(),
        exp.getSobre_experiencia());
        
        for (String actividad : dao.getActividad()) {
             //List<String> listaAct = new ArrayList<>();
            
            
            if (!actService.existByActividad(actividad)) {
                    
                    ActividadExp nuevaAct = new ActividadExp(actividad);
                    
                    actService.saveActividadExp(nuevaAct);
                    
                    RelExpAct rel = new RelExpAct(exp, nuevaAct);
                    
                    relacion.saveRelacion(rel);
                    
                    expDto.addActividad(actividad);
                    
                }else {
            
            for (RelExpAct relacionItem : relaciones) {
                
               ActividadExp act = actService.findByActividad(actividad);
               
                if (!relacionItem.getId().equals(new RelExpAct(exp, act).getId())) {
                    
                    //System.out.println(relacionItem.getId().equals(new RelExpAct(exp, act).getId()));
                    
                    if (relacionItem.getId().getActividadId() != act.getId() || relacionItem.getId().getExperienciaId() != exp.getId()) {
                        
                       RelExpAct rel = new RelExpAct(exp, act);
                    
                        relacion.saveRelacion(rel);
                    }
                }
             expDto.addActividad(actividad);
            }

            }
            //listaAct.add(actividad); // metodo add
        //expDto.setActividad(listaAct);    
        }
        
        
        return new ResponseEntity<>(expDto, HttpStatus.CREATED);
    }
    
    public List<ExperienciaDto> GetDtoRelacion() {
        
        List<Experiencia> listaExp = expService.getAllExperiencias();
        
        List<ExperienciaDto> listaDto = new ArrayList<>();
        
        for (Experiencia experiencia : listaExp) {
            
            ExperienciaDto expDto = new ExperienciaDto(experiencia.getId(), experiencia.getImg_experiencia(), experiencia.getImg_href(),
                    experiencia.getSobre_experiencia());
            
            for(RelExpAct relacionExp : experiencia.getRelaciones()) {
                
                ActividadExp act = actService.getActividadExpById(relacionExp.getId().getActividadId());
                
                expDto.addActividad(act.getActividad());
            }
            listaDto.add(expDto);
        }
        
        return listaDto;
    }
}
