package com.devpro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.spring.model.Chamber;

public interface ChamberRepository extends JpaRepository<Chamber, Long>{

}
