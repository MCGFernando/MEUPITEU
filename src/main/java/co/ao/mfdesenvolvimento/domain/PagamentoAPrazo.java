package co.ao.mfdesenvolvimento.domain;

import java.util.Date;

import co.ao.mfdesenvolvimento.domain.enumeration.EstadoPagamento;
import co.ao.mfdesenvolvimento.domain.enumeration.TipoPagamento;

public class PagamentoAPrazo extends Pagamento{
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoAPrazo() {
	}
	
	public PagamentoAPrazo(Integer id, EstadoPagamento estado, TipoPagamento tipoPagamento, Date dataVencimento, Date dataPagamento) {
		super(id, estado, tipoPagamento);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
}
