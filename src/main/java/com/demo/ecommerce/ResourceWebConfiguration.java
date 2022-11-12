package com.demo.ecommerce;

/*
 * Esta clase se crea para permitirnos apuntar hacia los recursos de imagenes
 * para poder obtenerlos de manera relativa en cualquier lugar solo apuntando
 * hacia esa url
 */


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *la anotamos como una clase de configuracion que va a ser un path relativo 
 *para apuntar desde cualquier lugar hacia los recursos de imagenes
 *hacemos que implemente de una interface que se llama WebMvcConfigurer 
 */

@Configuration
public class ResourceWebConfiguration implements WebMvcConfigurer {

	/*
	 * en los () del .addResourceHandler ponemos la cadena que es la ruta donde va a tomar todo lo que hay en el directorio
	 * en el .addResourceLocations es la ubicacion hacia donde deberia apuntar
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
	}

}
