package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.beautySalon.domain.entities.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    
}
