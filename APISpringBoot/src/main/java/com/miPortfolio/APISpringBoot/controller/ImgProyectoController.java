/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.ImgProyecto;
import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.service.ImgProyectoService;
import com.miPortfolio.APISpringBoot.service.ProyectoService;
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
public class ImgProyectoController {
  
    @Autowired private ImgProyectoService imgService;
    
    @Autowired private ProyectoService proService;
    
   /* @GetMapping ("/booleano")
    public String qteEncuentro() {
        
        if (imgService.findIntento("cuartetoooo!")) {
            return "funciona";
        }else {
            return "No funciona";
        }
    }*/
    
    // Crea
    
    /* Si no existe un registro de imgs lo crea y añade a la lista enlaszada
       en proyecto*/
    
    @PostMapping ("/imagen/proyecto/{id}/crear")
    public ResponseEntity<ImgProyecto> saveImgProyectos(@PathVariable Long id,
                                   @RequestBody ImgProyecto postImg) {
         
        /* Busca la proyecto en base al id que recibe, puede lanzar una excepcion*/
        
            Proyecto pro= proService.getProyectoById(id);
            
            /* Si no existe un registro de imgs lo crea y añade a la lista enlaszada
            en proyecto*/
            
        if (!imgService.existByImagen(postImg.getImagen()) ) {
            
            pro.addImg(postImg);
        
            imgService.saveImgProyecto(postImg);
            
            return new ResponseEntity<>(postImg, HttpStatus.OK);
       
            
            /*Si el registro existe en ambos extremos no hace nada */
        }else if (imgService.verificaExistenciaImg(pro.getImgs(), imgService.getAllImgProyectos()) ) {
       
            
            return new ResponseEntity<>(new ImgProyecto("ya existe un registro con ese nombre, en el proyecto indicado", "", ""), HttpStatus.CONFLICT);
        }else {
            
            // Si existe la imgs solo la agrega a la lista en proyecto
             ImgProyecto existAct = imgService.findByImagen(postImg.getImagen());
            
            pro.addImg(existAct);
            
            proService.saveProyecto(pro);
            
            return new ResponseEntity<>(new ImgProyecto("ya existe un registro con ese nombre, Agregado a proyecto", "", ""), HttpStatus.CONFLICT);
        }
         
    }
    
    
    //Trae todos
    
    @GetMapping ("/imagen/traer")
    public List<ImgProyecto> getAllImgProyectos() {
        
        return imgService.getAllImgProyectos();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/imagen/{id}/traer")
    public ImgProyecto getImgProyectoById(@PathVariable Long id) {
        
        return imgService.getImgProyectoById(id);
    }
    
    //Elimina 1 por id
    
    /* Para borrar una imgs hay que eliminarla primero de la lista de Proyecto */
    
    @DeleteMapping ("/imagen/delete/{id}")
    public String deleteImagenById(@PathVariable Long id) {
        
        imgService.deleteImgProyectoById(id);
        
        return "ImgProyecto elimanado";
    }
    
    @DeleteMapping ("/delete/imagen/{id}/proyecto/{idPro}")
    public String deleteImgProyectoById(@PathVariable Long id,
                                 @PathVariable Long idPro) {
        
        ImgProyecto img = imgService.getImgProyectoById(id);
        
        Proyecto pro = proService.getProyectoById(idPro);
        
        pro.removeObject(img);
        
        proService.saveProyecto(pro);
        
        return "ImgProyecto elimanada de proyecto";
    }
    
    //Edita 1 por id 
    
    @PutMapping ("/imagen/editar/{id}")
    public ResponseEntity<ImgProyecto>editarImgProyecto(@PathVariable Long id,
                                                @RequestParam String imagen,
                                                @RequestParam String nombre_img,
                                                @RequestParam String vinculo_img) {
        
        
        ImgProyecto editImg = imgService.getImgProyectoById(id);
        
        editImg.setImagen(imagen);
        editImg.setNombre_img(nombre_img);
        editImg.setViculo_img(vinculo_img);
        
        imgService.saveImgProyecto(editImg);
        
        
        return new ResponseEntity<>(editImg, HttpStatus.OK);
    }
}
