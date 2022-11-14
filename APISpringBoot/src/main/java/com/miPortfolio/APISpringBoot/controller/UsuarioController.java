/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService serviceUser;
    
    @CrossOrigin (origins = "http://localhost:8080")
    
    @GetMapping("/saludo")
    public String saludo() {
        
        return "holaa";
    }
    
    @PostMapping ("usuario/crear")
    public String saveUsuarios(@RequestBody Usuario usuario) {
        
        serviceUser.saveUsuario(usuario);
        
        return "Registro cerrado";
    }
    
    @GetMapping ("/usuario/traer")
    public List<Usuario> getAllUsuarios() {
        
        return serviceUser.getAllUsuarios();
    }
    
    @GetMapping ("/usuario/{id}/traer")
    public Usuario getUsuarioById(@PathVariable Long id) {
        
        return serviceUser.getUsuarioById(id);
    }
    
    @DeleteMapping ("/usuario/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        
        serviceUser.deleteUsuarioById(id);
        
        return "Usuario elimanado";
    }
}
