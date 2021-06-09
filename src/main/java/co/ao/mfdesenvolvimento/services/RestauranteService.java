package co.ao.mfdesenvolvimento.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.domain.Endereco;
import co.ao.mfdesenvolvimento.domain.Municipio;
import co.ao.mfdesenvolvimento.domain.Restaurante;
import co.ao.mfdesenvolvimento.dto.RestauranteNovoDTO;
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
	
	public Restaurante fromDTO(RestauranteNovoDTO restauranteDTO) {
		Conta conta = new Conta(restauranteDTO.getContaID(), null, null, null, null, null);
		Restaurante restaurante = new Restaurante(null, restauranteDTO.getRestaurante(), restauranteDTO.getDescricao(), 
				restauranteDTO.getDataCriacao(), restauranteDTO.getEstado(), conta);
		
		Municipio municipio = new Municipio(restauranteDTO.getMunicipioID(), null, null);
		
		Endereco end = new Endereco(null, restauranteDTO.getEndereco(),
				restauranteDTO.getBairro(), restauranteDTO.getQuarteirao(), restauranteDTO.getSector(),
				restauranteDTO.getRua(), restauranteDTO.getEdificio(), restauranteDTO.getAndar(), restauranteDTO.getCasa(),
				restauranteDTO.getReferencia(), municipio);

		
		restaurante.getEnderecos().addAll(Arrays.asList(end));
		
		return restaurante;
		
	}
}
