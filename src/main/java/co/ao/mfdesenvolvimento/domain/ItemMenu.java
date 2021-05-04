package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;

public class ItemMenu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String item;
	private Double preco;
	private String descricao;
	private Boolean pratoDoDia;
	
	public ItemMenu() {
	}

	public ItemMenu(Integer id, String item, Double preco, String descricao, Boolean pratoDoDia) {
		super();
		this.id = id;
		this.item = item;
		this.preco = preco;
		this.descricao = descricao;
		this.pratoDoDia = pratoDoDia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getPratoDoDia() {
		return pratoDoDia;
	}

	public void setPratoDoDia(Boolean pratoDoDia) {
		this.pratoDoDia = pratoDoDia;
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
		ItemMenu other = (ItemMenu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
