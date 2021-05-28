package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Controller
public class CompraController {
	private static final Log LOGGER = LogFactory.getLog(CompraController.class);
	
	@Autowired
	private Compra compra;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("CompraImp")
	private ICompraService compraService;
	
	
	@GetMapping("/compra/nueva")
	public String getCompraPage(Model model){
		model.addAttribute("compra",compra);
		model.addAttribute("productos",productoService.getAllProductos());
		return "compraform";
	}
	
	
	@PostMapping("/compra/guardar")
	public ModelAndView guardarCompra(@ModelAttribute("compra")Compra compra) {
		ModelAndView modelView = new ModelAndView("lista-compras");
		Producto producto = productoService.getProductoForId(compra.getProducto().getCodigo());
		LOGGER.info("producto---> "+ productoService.getProductoForId(compra.getProducto().getCodigo()).getNombre());
		compra.setProducto(producto);
		LOGGER.info("---->PRODUCTO CARGADO: "+producto.getNombre());
		//LOGGER.info("---->NOMBRE "+compra.getCantidad());
		compraService.guardarCompras(compra);
		modelView.addObject("listacompras",compraService.obtenerCompras());
		return modelView;
	}
	
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraListadoPage() {
		
		ModelAndView modelView = new ModelAndView("lista-compras");
		if(compraService.obtenerCompras()==null) {
			compraService.generarTablaCompras();
		}
		modelView.addObject("listacompras",compraService.obtenerCompras());
		return modelView;
	}
	
}
