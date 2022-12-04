/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.AcercaDeDao;
import com.miPortfolio.APISpringBoot.dto.AcercaDeDto;
import com.miPortfolio.APISpringBoot.model.AcercaDe;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.AcercaDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogicaAcercaDe {
    
    @Autowired AcercaDeService acercaService;
    
    public ResponseEntity<AcercaDeDto> crearAcerca(AcercaDeDao dao, Usuario user) {
        
        AcercaDe newAcerca = new AcercaDe(dao.getNombre_usuario(), dao.getApellido_usuario(),
                dao.getImagen(), dao.getSobre_usuario(), dao.getOcupacion(),
                dao.getImg_portada(), user);
        
        acercaService.saveAcercaDe(newAcerca);
        
        AcercaDeDto acercaDto = new AcercaDeDto(newAcerca.getNombre_usuario(), newAcerca.getApellido_usuario(),
                newAcerca.getImagen(), newAcerca.getSobre_usuario(), newAcerca.getOcupacion(),
                newAcerca.getImg_portada());
        
        return new ResponseEntity<>(acercaDto, HttpStatus.CREATED);
    }
}
