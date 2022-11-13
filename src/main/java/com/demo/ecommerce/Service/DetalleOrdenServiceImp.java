package com.demo.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.Repository.IDetalleOrdenRepository;
import com.demo.ecommerce.model.DetalleOrden;

@Service
public class DetalleOrdenServiceImp implements IDetalleOrdenService{

	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenRepository.save(detalleOrden);
	}

		
	
}
