package com.demo.ecommerce.Controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.ecommerce.Service.ProductoService;
import com.demo.ecommerce.model.Producto;
import com.demo.ecommerce.model.Usuario;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoService productoService;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/show";
	}

	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}

	@PostMapping("/save")
	public String save(Producto producto) {
//		LOGGER.info("objeto de la vista {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		return "redirect:/productos";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optional = productoService.get(id);
		producto = optional.get();
		
		LOGGER.info("producto buscado {} ", producto);
		model.addAttribute("producto", producto);
		
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto) {
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoService.delete(id);
		return "redirect:/productos";
	}

}