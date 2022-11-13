package com.demo.ecommerce.Controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.ecommerce.Service.ProductoService;
import com.demo.ecommerce.Service.UploadFileService;
import com.demo.ecommerce.model.Producto;
import com.demo.ecommerce.model.Usuario;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoService productoService;

	@Autowired
	private UploadFileService upload;

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
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
//		LOGGER.info("objeto de la vista {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		// imagen
		if (producto.getId() == null) {// cuando se crea un producto
			String nombreImg = upload.saveImage(file);
			producto.setImagen(nombreImg);
		} else {
		}
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
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

		Producto p = new Producto();
		p = productoService.get(producto.getId()).get();

		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagen

			producto.setImagen(p.getImagen());

		} else {// editamos el producto y cambiamos la imagen

			// eliminar cuando no sea la imagen por defecto

			if (p.getImagen().equals("default.jpg")) {

				upload.deleteImage(p.getImagen());
			}

			String nombreImg = upload.saveImage(file);
			producto.setImagen(nombreImg);
		}

		producto.setUsuario(p.getUsuario());

		productoService.update(producto);
		return "redirect:/productos";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		Producto p = new Producto();
		p = productoService.get(id).get();
		// eliminar cuando no sea la imagen por defecto
		if (p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());
		}

		productoService.delete(id);
		return "redirect:/productos";
	}

}
