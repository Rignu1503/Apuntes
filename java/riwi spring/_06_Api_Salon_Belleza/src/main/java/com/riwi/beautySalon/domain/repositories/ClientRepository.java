package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.beautySalon.domain.entities.ClientEntity;

public interface ClientRepository extends JpaRepository <ClientEntity, Long>{
    
}
