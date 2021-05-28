package ar.edu.unju.fi.tp4.serviceImp;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.Util.TablaCliente;
import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;


@Service("clienteUltilService")
public  class ClienteServiceImp implements IClienteService {
	
	private List<Cliente> clientes;
	@Override
	public void generarTablaClientes() {
		clientes = TablaCliente.listaClientes;
		clientes.add(new Cliente("DNI", 43276686, "Coronel Abril ", "abrilCC@gmail.com" , "Secreto123", LocalDate.of(2001, 4, 9), 388, 504563,  LocalDate.of(2015, 12, 7)));
	}
	
	@Override
	public List<Cliente> obtenerClientes() {
	
		return clientes;
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		if(clientes == null) {
			generarTablaClientes();
		}
		clientes.add(cliente);
	}
	

}
