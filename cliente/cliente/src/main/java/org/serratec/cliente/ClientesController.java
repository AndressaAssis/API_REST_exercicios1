package org.serratec.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	List<Clientes> clientes = new ArrayList<>();
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@GetMapping
	public List<Clientes> listarClientes() {
		return clientesRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Clientes buscarPorId(@PathVariable Long id) {
		Optional<Clientes> clienteOpt = clientesRepository.findById(id);
		
		if (clienteOpt.isEmpty()) {
			throw new RuntimeException("Cliente não encontrado");
		}
		
		return clienteOpt.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes cadastrarClientes(@RequestBody Clientes cliente) {
		return clientesRepository.save(cliente);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deletarClientes(@PathVariable Long id) {
		if (!clientesRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clientesRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clientes> alterarCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
		Optional<Clientes> clienteOptional = clientesRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Clientes clienteDB = clienteOptional.get();
		clienteDB.setId(cliente.getId());
		clienteDB.setNome(cliente.getNome());
		clienteDB.setCpf(cliente.getCpf());
		clienteDB.setEmail(cliente.getEmail());
		clienteDB.setDataDeNascimento(cliente.getDataDeNascimento());
		
		cliente = clientesRepository.save(clienteDB);
		return ResponseEntity.ok(cliente);
	}
}






