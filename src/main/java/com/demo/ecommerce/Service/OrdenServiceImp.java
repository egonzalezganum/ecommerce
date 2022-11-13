package com.demo.ecommerce.Service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Orden> findAll() {
		return ordenRepository.findAll();
	}

	@SuppressWarnings("null")
	public String generarOrden() {

		Integer num = 0;
		String numConcat = "";

		List<Orden> ordenes = findAll();

		List<Integer> numeros = new ArrayList<Integer>();

		ordenes.stream().forEach(orden -> numeros.add(Integer.parseInt(orden.getNumero())));

		if (ordenes.isEmpty()) {
			num = 1;
		} else {

			num = numeros.stream().max(Integer::compare).get();
			num++;
		}
		if (num<10) {
			numConcat = "000000000"+String.valueOf(num);
		} else if(num<100) {
			numConcat = "00000000"+String.valueOf(num);
		}else if(num<1000) {
			numConcat = "0000000"+String.valueOf(num);
		}else if(num<10000) {
			numConcat = "0000000"+String.valueOf(num);
		}

		return numConcat;
	}

}
