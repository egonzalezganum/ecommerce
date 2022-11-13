package com.demo.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.Repository.IOrdenRepository;
import com.demo.ecommerce.model.Orden;

@Service
public class OrdenServiceImp implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;

	@Override
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

}
