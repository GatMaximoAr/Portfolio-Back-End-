/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.Experiencia;
import java.util.List;



public interface IExperiencia {
    
    public void saveExperiencia(Experiencia usuario);
    
    public void deleteExperienciaById(Long id);
    
    public List<Experiencia> getAllExperiencias();
    
    public Experiencia getExperienciaById(Long id);
}
