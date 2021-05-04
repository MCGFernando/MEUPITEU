package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;

import co.ao.mfdesenvolvimento.domain.enumeration.EstadoPagamento;
import co.ao.mfdesenvolvimento.domain.enumeration.TipoPagamento;

public abstract class Pagamento implements Serializable{
	private Integer id;
	private Integer estado;
	private Integer tipoPagamento;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estado, TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.tipoPagamento = tipoPagamento.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
