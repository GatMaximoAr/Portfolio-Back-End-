/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IExperiencia;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExperienciaService implements IExperiencia{

    @Autowired 
    private ExperienciaRepository repository;
    
    @Override
    public void saveExperiencia(Experiencia experiencia) {
        
        repository.save(experiencia);
    }

    @Override
    public void deleteExperienciaById(Long id) {
        
        repository.deleteById(id);
    }

    @Override
    public List<Experiencia> getAllExperiencias() {
        
        return repository.findAll();
    }

    // Deberia tratar de personalizar esta excepcion
    
    @Override
    public Experiencia getExperienciaById(Long id) {
        
        return repository.findById(id).orElseThrow();
    }
    
}
