package com.demo.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.ecommerce.Service.ProductoService;
import com.demo.ecommerce.model.DetalleOrden;
import com.demo.ecommerce.model.Orden;
import com.demo.ecommerce.model.Producto;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductoService productoService;
	
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();//para almacenar los detalles de la orden 
	
	
	Orden orden = new Orden(); //datos de la orden
	

	@GetMapping("")
	public String home(Model model) {

		model.addAttribute("productos", productoService.findAll());

		return "usuario/home";
	}

	@GetMapping("/productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {// PathVariable identifica que el id lo toma desde la url
		log.info("id enviado como parametro {} ", id);

		Producto producto = new Producto();

		Optional<Producto> productoOpt = productoService.get(id);
		producto = productoOpt.get();
		model.addAttribute("producto", producto);

		return "usuario/productohome";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad) {
		
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal = 0; 

		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("producto añadido al carrito: {} ",optionalProducto.get());
		log.info("cantidad: {} ",cantidad);
		
		return "usuario/carrito";
		
	}

}
