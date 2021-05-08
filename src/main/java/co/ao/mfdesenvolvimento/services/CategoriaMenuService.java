package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.ao.mfdesenvolvimento.domain.CategoriaMenu;
import co.ao.mfdesenvolvimento.repositories.CategoriaMenuRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaMenuService {
	@Autowired
	private CategoriaMenuRepository repo;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CategoriaMenu buscar(Integer id) {
		Optional<CategoriaMenu> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + CategoriaMenu.class.getName()
						)
				);
	}
}
