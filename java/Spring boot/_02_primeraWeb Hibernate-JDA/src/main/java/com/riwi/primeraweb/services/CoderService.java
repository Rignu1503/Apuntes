package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {
    
    //Los sercivios usa las repositorio

    /*Hacemos la inyección de dependencias */

        @Autowired
        private CoderRepository objCoderRepository;

        public List<Coder> findAll(){
            return objCoderRepository.findAll();

        }

        // public Object insert(Object){
            
        //     return "";
        // }
    
}
