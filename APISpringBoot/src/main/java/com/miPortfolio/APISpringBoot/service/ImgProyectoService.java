
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.InterImgProyecto;
import com.miPortfolio.APISpringBoot.model.ImgProyecto;
import com.miPortfolio.APISpringBoot.repository.ImgProyectoRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ImgProyectoService implements InterImgProyecto {
    
    @Autowired private ImgProyectoRepository repository;

    @Override
    public void saveImgProyecto(ImgProyecto imgProyecto) {
        
        repository.save(imgProyecto);
    }

    @Override
    public void deleteImgProyectoById(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<ImgProyecto> getAllImgProyectos() {
        
        return repository.findAll();
    }

    @Override
    public ImgProyecto getImgProyectoById(Long id) {
        
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    @Override
    public boolean existById(Long id) {
        
        return repository.existsById(id);
    }
    
    /* Si existe Actividad recibe String, devuelve true si hay
       registros, else false*/
    
    @Override
    public boolean existByImagen(String img) {
        
        return repository.existsByImagen(img);
    }
    
    /* Devuelve un objeto Actividad que coincida con el parametro String */
    
    @Override
    public ImgProyecto findByImagen(String img) {
        
        return repository.findByImagen(img);
    }
    
    /* Verifica que un registro de actividad este en las dos listas *
       una es de Actividad entity y la otra esta enlazada con *,
       en caso de que los registros coincidan devuelve true, else false*/
    
    @Override
    public boolean verificaExistenciaImg(Set<ImgProyecto> _pro, List<ImgProyecto> _img) {
        
        boolean retorno = false;
        
        for (ImgProyecto actividadExp : _img) {
            for (ImgProyecto actividadExp1 : _pro) {
                if (actividadExp.getImagen().equalsIgnoreCase(actividadExp1.getImagen())) {
                    retorno = true;
                }
            }
        }
        return retorno;
    }
}
