
package com.miPortfolio.APISpringBoot.repository;

import com.miPortfolio.APISpringBoot.model.ImgProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImgProyectoRepository extends JpaRepository<ImgProyecto, Long> {
    
    /* Query derivada, devuelve booleanos en caso de que exista 
       un registro coincidente con el parametro String */
    
     boolean existsByImagen(String img);
    
     /* Devuelve un objeto Imagen que coincida con el parametro String */
     
     ImgProyecto findByImagen(String img);
}
