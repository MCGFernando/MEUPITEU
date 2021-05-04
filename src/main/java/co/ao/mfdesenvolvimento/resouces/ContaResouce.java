package co.ao.mfdesenvolvimento.resouces;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ao.mfdesenvolvimento.domain.Conta;

@RestController
@RequestMapping(value = "/contas")
public class ContaResouce {
	@RequestMapping(method = RequestMethod.GET)
	public List<Conta> listar(){
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
	}
}
