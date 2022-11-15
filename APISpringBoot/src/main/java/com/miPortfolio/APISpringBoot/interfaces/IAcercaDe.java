/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.AcercaDe;
import java.util.List;

/**
 *
 * @author maximo
 */
public interface IAcercaDe {
    
    public void saveAcercaDe(AcercaDe acercaDe);
    
    public void deleteAcercaDeById(Long id);
    
    public List<AcercaDe> getAllAcercaDe();
    
    public AcercaDe getAcercaDeById(Long id);
}
