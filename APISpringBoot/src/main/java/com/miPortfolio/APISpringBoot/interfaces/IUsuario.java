/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.Usuario;
import java.util.List;


public interface IUsuario {
    
    public void saveUsuario(Usuario usuario);
    
    public void deleteUsuarioById(Long id);
    
    public List<Usuario> getAllUsuarios();
    
    public Usuario getUsuarioById(Long id);
    
    
}
