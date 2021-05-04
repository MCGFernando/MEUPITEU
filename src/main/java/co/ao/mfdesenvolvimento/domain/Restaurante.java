package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurante implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String restaurante;
	private String descricao;
	private Date dataCriacao;
	private Boolean estado;
	private Set<String> contactos = new HashSet<>();
	private List<String> tags = new ArrayList<>();
	
	public Restaurante() {
	}

	public Restaurante(Integer id, String restaurante, String descricao, Date dataCriacao, Boolean estado) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<String> getContactos() {
		return contactos;
	}

	public void setContactos(Set<String> contactos) {
		this.contactos = contactos;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
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
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
