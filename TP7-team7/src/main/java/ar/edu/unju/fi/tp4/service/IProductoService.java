package ar.edu.unju.fi.tp4.service;


import java.util.List;

import ar.edu.unju.fi.tp4.model.Producto;

public interface IProductoService {

	public void addProducto(Producto producto);
	public Producto getUltimoProducto();
	public Producto getProducto();
	public List<Producto> getAllProductos();
	public Producto getProductoForId(int id);
}
