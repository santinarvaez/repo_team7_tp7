package ar.edu.unju.fi.tp4.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Controller
public class ProductoController {
	@Autowired
	IProductoService productosService ;
	private static final Log LOGGER = LogFactory.getLog(ProductoController.class);
	
	@GetMapping("/producto/nuevo")
	public String getNuevoPage(Model model) {
		LOGGER.info("CONTROLLER: ProductoController with /nuevo get method");
		LOGGER.info("METHOD: getNuevoPage()");
		LOGGER.info("RESULT: visualiza la página nuevo.html");
		model.addAttribute("producto", productosService.getProducto());
		return "nuevoProducto";
	}
	

	@PostMapping("/producto/guardar")
	public String getResultPage(@ModelAttribute("producto") Producto unProducto) {
		productosService.addProducto(unProducto);	
		return "resultado";
	}
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProductoPage(Model model) {
		ModelAndView modelView = new ModelAndView("ultimoproducto");
		
		modelView.addObject("producto", productosService.getUltimoProducto());
		return modelView;
	}
	@GetMapping("/producto/listar")
	public String getEmpleadosPage(Model model) {
		model.addAttribute("producto", productosService.getAllProductos());
		return "lista-producto";
	}
	
	
}
