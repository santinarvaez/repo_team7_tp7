package ar.edu.unju.fi.tp4.serviceImp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.Util.TablaCompra;
import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;

@Service("CompraImp")
public class CompraServiceImp implements ICompraService{
	private List<Compra> compras = TablaCompra.listaCompras;

	
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	
	
	public void guardarCompras(Compra compra){
		
		if(compra==null) {
			generarTablaCompras();
		}
		LOGGER.info("COMPRA----------->" + compra.getProducto().getNombre());
		compras.add(compra); 
		
	}
	
	public List<Compra> obtenerCompras(){
		return compras;
	}

	@Override
	public void generarTablaCompras() {
		// TODO Auto-generated method stub
		
	}

}
