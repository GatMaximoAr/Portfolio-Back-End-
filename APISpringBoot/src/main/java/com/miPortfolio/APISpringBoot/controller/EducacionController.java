
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dao.EducacionDao;
import com.miPortfolio.APISpringBoot.dto.EducacionDto;
import com.miPortfolio.APISpringBoot.logica.LogicaEducacion;
import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.EducacionService;
import com.miPortfolio.APISpringBoot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin (origins = "http://localhost:4200/")
@RestController
public class EducacionController {
    
    @Autowired private EducacionService eduService;
    
    @Autowired private UsuarioService userService;
    
    @Autowired private LogicaEducacion logicaEdu;
    
    // Crea
    
    @PostMapping ("/educacion/usuario/{id}/crear")
    public ResponseEntity<Mensaje> saveEducacion(@PathVariable Long id,
                                   @RequestBody EducacionDao dao) {
                                   
        Usuario user = userService.getUsuarioById(id);
        
        
        return logicaEdu.crearItemEducacion(dao, user);
    }
    
    
    //Trae todos
    
    @GetMapping ("/educacion/traer")
    public List<EducacionDto> getAllFormaciones() {
        
        return logicaEdu.getListEducacion();
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
    public ResponseEntity<EducacionDto>editarEducacion(@PathVariable Long id,
                                                    @RequestBody EducacionDao dao) {
        
        Educacion edu = eduService.getEducacionById(id);
        
        
        return logicaEdu.modificaEducacion(edu, dao);
    }
}
