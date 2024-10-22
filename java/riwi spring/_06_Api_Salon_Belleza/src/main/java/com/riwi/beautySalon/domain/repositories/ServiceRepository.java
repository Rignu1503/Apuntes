package com.riwi.beautySalon.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riwi.beautySalon.domain.entities.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    
    @Query("select s from service s where s.price between :min and :max")
    public  List<ServiceEntity> selectBetweenPrice(BigDecimal min, BigDecimal max);


    public List<ServiceEntity> findByNameContaining(String search);
}
