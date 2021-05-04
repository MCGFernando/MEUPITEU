package co.ao.mfdesenvolvimento.domain;

import java.util.Date;

import co.ao.mfdesenvolvimento.domain.enumeration.EstadoEncomenda;


public class Encomenda {
	private Integer id;
	private Date dataPedido;
	private Integer estado;
	
	public Encomenda() {
	}

	public Encomenda(Integer id, Date dataPedido, EstadoEncomenda estado) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.estado = estado.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public EstadoEncomenda getEstado() {
		return EstadoEncomenda.toEnum(estado);
	}

	public void setEstado(EstadoEncomenda estado) {
		this.estado = estado.getCod();
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
		Encomenda other = (Encomenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
