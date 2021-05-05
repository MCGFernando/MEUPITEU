package co.ao.mfdesenvolvimento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.domain.Municipio;
import co.ao.mfdesenvolvimento.domain.Provincia;
import co.ao.mfdesenvolvimento.repositories.ContaRepository;
import co.ao.mfdesenvolvimento.repositories.MunicipioRepository;
import co.ao.mfdesenvolvimento.repositories.ProvinciaRepository;

@SpringBootApplication
public class MeupiteuApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MeupiteuApplication.class, args);
	}
	
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Conta cont1 = new Conta(1, "Joao Baluard da Costa", "joaocosta@gmail.com", "123456", df.parse("01/05/2021 23:52"), true);
		Conta cont2 = new Conta(2, "Felisberta Amborsio", "saboresdaterra@gmail.com", "654321", df.parse("29/04/2021 13:40"), true);
		cont1.getContactos().addAll(Arrays.asList("911911911"));
		cont2.getContactos().addAll(Arrays.asList("921921921","923923923"));
		
		contaRepository.saveAll(Arrays.asList(cont1,cont2));
		
		Provincia prov1 = new Provincia(null, "Luanda");
		Municipio mun1 = new Municipio(null, "Talatona", prov1);
		prov1.getMunicipios().addAll(Arrays.asList(mun1));
		
		provinciaRepository.saveAll(Arrays.asList(prov1));
		municipioRepository.saveAll(Arrays.asList(mun1));
		
	}
	
}
