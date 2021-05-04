package co.ao.mfdesenvolvimento.domain;

import java.util.Date;

import co.ao.mfdesenvolvimento.domain.enumeration.EstadoPagamento;
import co.ao.mfdesenvolvimento.domain.enumeration.TipoPagamento;

public class ProntoPagamento extends Pagamento{
	private int parcelas;

	public ProntoPagamento() {
	}

	public ProntoPagamento(Integer id, EstadoPagamento estado, TipoPagamento tipoPagamento, int parcelas) {
		super(id, estado, tipoPagamento);
		this.parcelas = parcelas;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
