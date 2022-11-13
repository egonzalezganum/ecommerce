package com.demo.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ecommerce.model.Orden;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{

	
	
}
