package co.ao.mfdesenvolvimento.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.sym.Name;

import co.ao.mfdesenvolvimento.domain.enumeration.EstadoEncomenda;

@Entity
public class Encomenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataPedido;
	private Integer estado;
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;	
	public Encomenda() {
	}

	public Encomenda(Integer id, Date dataPedido, EstadoEncomenda estado, Conta conta) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.estado = estado.getCod();
		this.conta =  conta;
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

	public void setEstado(Integer estado) {
		this.estado = estado;
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
