package co.ao.mfdesenvolvimento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.ao.mfdesenvolvimento.domain.CategoriaMenu;
import co.ao.mfdesenvolvimento.domain.Conta;
import co.ao.mfdesenvolvimento.domain.Encomenda;
import co.ao.mfdesenvolvimento.domain.Endereco;
import co.ao.mfdesenvolvimento.domain.ItemMenu;
import co.ao.mfdesenvolvimento.domain.Municipio;
import co.ao.mfdesenvolvimento.domain.Provincia;
import co.ao.mfdesenvolvimento.domain.Restaurante;
import co.ao.mfdesenvolvimento.domain.enumeration.EstadoEncomenda;
import co.ao.mfdesenvolvimento.repositories.CategoriaMenuRepository;
import co.ao.mfdesenvolvimento.repositories.ContaRepository;
import co.ao.mfdesenvolvimento.repositories.EncomendaRepository;
import co.ao.mfdesenvolvimento.repositories.EnderecoRepository;
import co.ao.mfdesenvolvimento.repositories.ItemMenuRepository;
import co.ao.mfdesenvolvimento.repositories.MunicipioRepository;
import co.ao.mfdesenvolvimento.repositories.ProvinciaRepository;
import co.ao.mfdesenvolvimento.repositories.RestauranteRepository;

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
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private CategoriaMenuRepository categoriaMenuRepository;
	@Autowired
	private ItemMenuRepository itensMenuRepository;
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Conta cont1 = new Conta(1, "Joao Baluard da Costa", "joaocosta@gmail.com", "123456", df.parse("01/05/2021 23:52"), true);
		Conta cont2 = new Conta(2, "Felisberta Amborsio", "saboresdaterra@gmail.com", "654321", df.parse("29/04/2021 13:40"), true);
		cont1.getContactos().addAll(Arrays.asList("911911911"));
		cont2.getContactos().addAll(Arrays.asList("921921921","923923923"));
		
		Restaurante rest1 = new Restaurante(null, "Sabores da Terra", "Cozina e Esplanada", df.parse("01/05/2021 12:52"), true, cont2);
		rest1.getTags().addAll(Arrays.asList("Cozinha", "Esplanada"));
		//cont2.setRestaurante(rest1);
		
		contaRepository.saveAll(Arrays.asList(cont1,cont2));
		restauranteRepository.saveAll(Arrays.asList(rest1));
		
		Provincia prov1 = new Provincia(null, "Luanda");
		Municipio mun1 = new Municipio(null, "Talatona", prov1);
		prov1.getMunicipios().addAll(Arrays.asList(mun1));
		
		provinciaRepository.saveAll(Arrays.asList(prov1));
		municipioRepository.saveAll(Arrays.asList(mun1));
		
		Endereco end1 = new Endereco(null, "Av 21 de Janeiro", "Morro Bento 2", "3Q", "D", "Pé da Lê", null, null, "3C", "Proximo ao condominio da sonangol", mun1);
		Endereco end2 = new Endereco(null, "Av Sao Paulo", "Sao Paulo", null, null, "Sebastiao Desta Vez", "184", "3º", "2C Lado B", null, mun1);
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		CategoriaMenu cat1 = new CategoriaMenu(null, "Pratos Principais", rest1);
		CategoriaMenu cat2 = new CategoriaMenu(null, "Bebidas", rest1);
		
		ItemMenu itens1 = new ItemMenu(null, "Massa Com Todos", 2000D, "Mistura de massa com coxa de frango, moela, entrecosto", true);
		ItemMenu itens2 = new ItemMenu(null, "Coca-Cola", 500D, null, false);
		
		cat1.getItens().addAll(Arrays.asList(itens1));
		cat2.getItens().addAll(Arrays.asList(itens2));
		
		itens1.getCategorias().addAll(Arrays.asList(cat1));
		itens2.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaMenuRepository.saveAll(Arrays.asList(cat1,cat2));
		itensMenuRepository.saveAll(Arrays.asList(itens1, itens2));
		
		Encomenda enc1 = new Encomenda(null, df.parse("01/05/2021 13:45"), EstadoEncomenda.PENDENTE, cont1);
		Encomenda enc2 = new Encomenda(null, df.parse("01/05/2021 17:03"), EstadoEncomenda.ENTREGUE, cont1);
		cont1.getEncomendas().addAll(Arrays.asList(enc1, enc2));
		
		encomendaRepository.saveAll(Arrays.asList(enc1, enc2));
	}
	
}
