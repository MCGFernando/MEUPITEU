package co.ao.mfdesenvolvimento.resouces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ao.mfdesenvolvimento.domain.CategoriaMenu;

import co.ao.mfdesenvolvimento.services.CategoriaMenuService;

@RestController
@RequestMapping(value = "/menus")
public class CategoriaMenuResouce {
	@Autowired
	private CategoriaMenuService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id){
		CategoriaMenu obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
