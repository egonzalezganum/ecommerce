package com.demo.ecommerce.Service;

import java.util.Optional;

import com.demo.ecommerce.model.Usuario;

public interface IUsuarioService {

	Optional<Usuario> findById(Integer id);

}
