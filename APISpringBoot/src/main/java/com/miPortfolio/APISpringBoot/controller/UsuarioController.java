/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/* Controler de end point usuario */


//@CrossOrigin (origins = "http://localhost:8080")
// @RequestMapping ("/api")
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService serviceUser;
    
    
    @GetMapping("/saludo")
    public String saludo() {
        
        return "holaa";
    }
    
    // Crea
    
    @PostMapping ("/usuario/crear")
    public String saveUsuarios(@RequestBody Usuario usuario) {
        
        serviceUser.saveUsuario(usuario);
        
        return "Registro creado";
    }
    
    
    //Trae todos
    
    @GetMapping ("/usuario/traer")
    public List<Usuario> getAllUsuarios() {
        
        return serviceUser.getAllUsuarios();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/usuario/{id}/traer")
    public Usuario getUsuarioById(@PathVariable Long id) {
        
        return serviceUser.getUsuarioById(id);
    }
    
    //Elimina 1 por id
    
    @DeleteMapping ("/usuario/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        
        serviceUser.deleteUsuarioById(id);
        
        return "Usuario elimanado";
    }
    
    //Edita 1 por id 
    
    @PutMapping ("/usuario/editar/{id}")
    public ResponseEntity<Usuario>editarUsuario(@PathVariable Long id,
                                                @RequestParam String name,
                                                @RequestParam String password) {
        
        
        Usuario editUser = serviceUser.getUsuarioById(id);
        
        editUser.setName(name);
        editUser.setPassword(password);
        serviceUser.saveUsuario(editUser);
        
        return new ResponseEntity<>(editUser, HttpStatus.OK);
    }
}
