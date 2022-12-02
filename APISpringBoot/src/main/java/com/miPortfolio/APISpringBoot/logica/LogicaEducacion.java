/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.EducacionDao;
import com.miPortfolio.APISpringBoot.dto.EducacionDto;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.APISpringBoot.service.EducacionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class LogicaEducacion {
    
    @Autowired private EducacionService eduService;
    
    public List<EducacionDto> getListEducacion() {
        
        List<Educacion> listaEducacion = eduService.getAllFormaciones();
        
        List<EducacionDto> listDto = new ArrayList<>();
        
        for (Educacion educacion : listaEducacion) {
            
            EducacionDto eduDto = new EducacionDto(educacion.getId(), educacion.getTitulo_des(),
                    educacion.getImagen(), educacion.getVinculo_img(),
                    educacion.getSobre_educacion());
            
            listDto.add(eduDto);
        }
        
        return listDto;
    }
    
    public ResponseEntity<Mensaje> crearItemEducacion(EducacionDao dao, Usuario user) {
        
        Educacion NuevaEdu = new Educacion(dao.getTitulo_des(), dao.getImagen(),
        dao.getVinculo_img(), dao.getSobre_educacion(), user);
        
        eduService.saveEducacion(NuevaEdu);
        
        return new ResponseEntity<>(new Mensaje("Item Educacion creado"), HttpStatus.CREATED);
    }
}
