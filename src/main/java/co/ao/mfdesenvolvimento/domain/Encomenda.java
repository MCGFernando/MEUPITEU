package co.ao.mfdesenvolvimento.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@JsonBackReference
	//@JsonIgnore
	private Conta conta;	
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "id.encomenda")
	private Set<ItensEncomenda> itens = new HashSet<>();
	public Encomenda() {
	}

	public Encomenda(Integer id, Date dataPedido, EstadoEncomenda estado, Conta conta) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.estado = estado.getCod();
		this.conta =  conta;
	}
	//@JsonIgnore
	public List<ItemMenu> getItemMenu (){
		List<ItemMenu> lista = new ArrayList<>();
		for(ItensEncomenda x : itens) {
			lista.add(x.getItemMenu());
		}
		return lista;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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

	public void setEstadoEncomenda(Integer estado) {
		this.estado = estado;
	}

	public Set<ItensEncomenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItensEncomenda> itens) {
		this.itens = itens;
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
