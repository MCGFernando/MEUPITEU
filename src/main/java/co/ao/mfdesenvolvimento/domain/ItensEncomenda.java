package co.ao.mfdesenvolvimento.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ItensEncomenda {
	@JsonIgnore
	@EmbeddedId
	private ItensEncomendaPK id = new ItensEncomendaPK();
	private Double preco;
	private Double desconto;
	private Integer quantidade;
		
	public ItensEncomenda() {
	}

	public ItensEncomenda(Encomenda encomenda, ItemMenu itemMenu, Double preco, Double desconto, Integer quantidade) {
		super();
		this.preco = preco;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.id.setEncomenda(encomenda);
		this.id.setItemMenu(itemMenu);
	}

	public Encomenda getEncomenda() {
		return id.getEncomenda();
	}
	
	public ItemMenu getItemMenu() {
		return id.getItemMenu();
	}
	public ItensEncomendaPK getId() {
		return id;
	}

	public void setId(ItensEncomendaPK id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		ItensEncomenda other = (ItensEncomenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
