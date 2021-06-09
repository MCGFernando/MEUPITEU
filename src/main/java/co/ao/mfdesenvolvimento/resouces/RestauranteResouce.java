package co.ao.mfdesenvolvimento.resouces;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.ao.mfdesenvolvimento.domain.Restaurante;
import co.ao.mfdesenvolvimento.dto.RestauranteNovoDTO;
import co.ao.mfdesenvolvimento.services.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteResouce {
	@Autowired
	private RestauranteService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Restaurante obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody RestauranteNovoDTO restauranteDTO){
		Restaurante restaurante = service.fromDTO(restauranteDTO);
		restaurante = service.save(restaurante);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(restaurante.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
