package com.demo.ecommerce.Service;

import java.util.List;

import com.demo.ecommerce.model.Orden;

public interface IOrdenService {

	List<Orden> findAll();
	
	Orden save(Orden orden); 
	
}
