/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IUsuario;
import com.miPortfolio.APISpringBoot.model.Usuario;
import com.miPortfolio.APISpringBoot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuario{

    @Autowired
            
    private UsuarioRepository repository;
    
    @Override
    public void saveUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElseThrow();
    }
    
}
