package org.serratec.doces;

import java.util.List;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doces")
public class DocesController {
	
	@Autowired
	private DocesRepository repositorio;
	
	@GetMapping
	public List<Doces> obterDoces() {
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doces> obterPorId(@PathVariable Long id) {
		if (!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repositorio.findById(id).get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Doces> cadastrarDoce(@Valid @RequestBody Doces doce) {
		Doces doceSalvo = repositorio.save(doce);
		return ResponseEntity.status(HttpStatus.CREATED).body(doceSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirDoce(@PathVariable Long id) {
		if (!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doces> alterarDoce(@PathVariable Long id, @Valid @RequestBody Doces doce) {
		if (!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		doce.setId(id);
		repositorio.save(doce);
		return ResponseEntity.ok(doce);
	}
}
