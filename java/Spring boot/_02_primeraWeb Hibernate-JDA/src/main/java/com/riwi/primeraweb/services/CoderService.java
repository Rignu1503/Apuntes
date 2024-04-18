package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {

    // Los sercivios usa las repositorio

    /* Hacemos la inyección de dependencias */

    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll() {
        return objCoderRepository.findAll();
    }

    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }

    public Coder update(Long id, Coder objCoder) {
        /*
         * Buscamos al coder con ese ID
         * orElse(null): en caso que no encuentre un ID retorna un null
         */
        Coder objCoderDB = this.findById(id);

        if (objCoderDB == null)
            return null;

        /* Actualizar el coder antiguo */
        objCoderDB = objCoder;

        return this.objCoderRepository.save(objCoder);
    }

    public Coder findById(Long id) {
        return this.objCoderRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        this.objCoderRepository.deleteById(id);
    }

    /* Metodo para listar los coders de forma paginada */

    public Page<Coder> fingPaginated(int page, int size){
        if(page < 0){
            page = 1;
        }

        //Crear el objeto de paginación 
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPageable);
    }
}
