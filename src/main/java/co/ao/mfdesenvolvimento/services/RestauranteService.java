package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.domain.Restaurante;
import co.ao.mfdesenvolvimento.repositories.RestauranteRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;



@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository repo;
	
	public Restaurante buscar(Integer id) {
		Optional<Restaurante> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Restaurante.class.getName()
						)
				);
	}
	
	@Transactional
	public Restaurante save(Restaurante restaurante) {
		restaurante.setId(null);
		return repo.save(restaurante); 
	}
}
