package com.demo.ecommerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.Repository.IUsuarioRepository;
import com.demo.ecommerce.model.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {

		return iUsuarioRepository.findById(id);
	}

}
