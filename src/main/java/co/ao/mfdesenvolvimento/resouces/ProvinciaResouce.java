package co.ao.mfdesenvolvimento.resouces;


import java.net.URI;

import javax.security.auth.message.config.ServerAuthContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.ao.mfdesenvolvimento.domain.Provincia;
import co.ao.mfdesenvolvimento.services.ProvinciaService;

@RestController
@RequestMapping(value = "/provincias")
public class ProvinciaResouce {
	@Autowired
	private ProvinciaService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Provincia obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Provincia provincia){
		provincia = service.save(provincia);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(provincia.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
