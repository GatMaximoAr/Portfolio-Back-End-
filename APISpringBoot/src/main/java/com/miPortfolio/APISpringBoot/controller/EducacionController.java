
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.EducacionService;
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
public class EducacionController {
    
    @Autowired private EducacionService eduService;
    
    @Autowired private UsuarioService userService;
    
    // Crea
    
    @PostMapping ("/educacion/usuario/{id}/crear")
    public ResponseEntity<Educacion> saveEducacion(@PathVariable Long id,
                                   @RequestBody Educacion postEdu) {
                                   
        Usuario user = userService.getUsuarioById(id);
        postEdu.setUser(user);
        
        eduService.saveEducacion(postEdu);
        
        return new ResponseEntity<>(postEdu, HttpStatus.OK);
    }
    
    
    //Trae todos
    
    @GetMapping ("/educacion/traer")
    public List<Educacion> getAllFormaciones() {
        
        return eduService.getAllFormaciones();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/educacion/{id}/traer")
    public Educacion getEducacionById(@PathVariable Long id) {
        
        return eduService.getEducacionById(id);
    }
    
    //Elimina 1 por id
    
    @DeleteMapping ("/educacion/delete/{id}")
    public String deleteEducacionById(@PathVariable Long id) {
        
        eduService.deleteEducacionById(id);
        
        return "Educacion elimanado";
    }
    
    //Edita 1 por id 
    
    @PutMapping ("/educacion/editar/{id}")
    public ResponseEntity<Educacion>editarEducacion(@PathVariable Long id,
                                                @RequestParam String titulo_des,
                                                @RequestParam String imagen,
                                                @RequestParam String sobre_educacion) {
        
        
        Educacion editEdu = eduService.getEducacionById(id);
        editEdu.setTitulo_des(titulo_des);
        editEdu.setImagen(imagen);
        editEdu.setSobre_educacion(sobre_educacion);
        
        eduService.saveEducacion(editEdu);
        
        
        return new ResponseEntity<>(editEdu, HttpStatus.OK);
    }
}
