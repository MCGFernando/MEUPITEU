package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ao.mfdesenvolvimento.domain.Provincia;
import co.ao.mfdesenvolvimento.repositories.ProvinciaRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;



@Service
public class ProvinciaService {
	@Autowired
	private ProvinciaRepository repo;
	public Provincia find(Integer id) {
		Optional<Provincia> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Provincia.class.getName()
						)
				);
	}
	
	public Provincia save(Provincia provincia) {
		provincia.setId(null);
		return repo.save(provincia);
	}
}
