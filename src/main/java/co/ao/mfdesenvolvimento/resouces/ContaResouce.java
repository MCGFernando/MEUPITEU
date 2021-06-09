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

import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResouce {
	@Autowired
	private ContaService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Conta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Conta conta){
		conta = service.save(conta);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Conta conta,@PathVariable Integer id){
		conta.setId(id);
		conta = service.update(conta);
		return ResponseEntity.noContent().build();
	}
	
	
	
	/*public List<Conta> listar(){
		List<Conta> lst = new ArrayList<>();
		try {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Conta cont1 = new Conta(1, "Joao Baluard da Costa", "joaocosta@gmail.com", "123456", df.parse("01/05/2021 23:52"), true);
		Conta cont2 = new Conta(2, "Felisberta Amborsio", "saboresdaterra@gmail.com", "654321", df.parse("29/04/2021 13:40"), true);
		lst.add(cont1);
		lst.add(cont2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}*/
}
