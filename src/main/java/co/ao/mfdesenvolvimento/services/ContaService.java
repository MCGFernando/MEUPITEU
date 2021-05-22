package co.ao.mfdesenvolvimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.repositories.ContaRepository;
import co.ao.mfdesenvolvimento.services.exceptions.ObjectNotFoundException;



@Service
public class ContaService {
	@Autowired
	private ContaRepository repo;
	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objecto nao encontrado. Id: " + id + ", Tipo: " + Conta.class.getName()
						)
				);
	}
	@Transactional
	public Conta save(Conta conta) {
		conta.setId(null);
		return repo.save(conta); 
	}
	
}
