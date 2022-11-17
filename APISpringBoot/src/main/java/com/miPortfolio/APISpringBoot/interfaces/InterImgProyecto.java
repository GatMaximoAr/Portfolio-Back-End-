/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.ImgProyecto;
import com.miPortfolio.APISpringBoot.model.ImgProyecto;
import java.util.List;
import java.util.Set;

/**
 *
 * @author maximo
 */
public interface InterImgProyecto {
    
    public void saveImgProyecto(ImgProyecto imgProyecto);
    
    public void deleteImgProyectoById(Long id);
    
    public List<ImgProyecto> getAllImgProyectos();
    
    public ImgProyecto getImgProyectoById(Long id);
    
    public boolean existById(Long id);
    
    public boolean existByImagen(String act);
    
    public ImgProyecto findByImagen(String act);
    
    public boolean verificaExistenciaImg(Set<ImgProyecto> _pro, List<ImgProyecto> _img);
}
