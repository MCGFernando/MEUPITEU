package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class ItemMenu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String item;
	private Double preco;
	private String descricao;
	private Boolean pratoDoDia;
	@JsonBackReference
	@ManyToMany
	@JoinTable(
			name = "ItemMenu_CategoriaMenu",
			joinColumns = @JoinColumn(name="itemMenu_id"),
			inverseJoinColumns = @JoinColumn(name="categoriaMenu_id")
			)
	private List<CategoriaMenu> categorias = new ArrayList<>();
	@OneToMany(mappedBy = "id.itemMenu")
	private Set<ItensEncomenda> itens = new HashSet<ItensEncomenda>();
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

	public List<Encomenda> getEncomendas (){
		List<Encomenda> lista = new ArrayList<>();
		for(ItensEncomenda x : itens) {
			lista.add(x.getEncomenda());
		}
		return lista;
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

	public List<CategoriaMenu> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaMenu> categorias) {
		this.categorias = categorias;
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
		ItemMenu other = (ItemMenu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
