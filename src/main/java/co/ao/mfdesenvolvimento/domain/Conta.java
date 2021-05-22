package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	private String email;
	private String senha;
	private Date dataCriacao; 
	private Boolean estado;
	@ElementCollection
	@CollectionTable(name = "contacto")
	private Set<String> contactos = new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "conta")
	private List<Encomenda> encomendas = new ArrayList<>();
	/*@OneToOne(cascade = CascadeType.ALL, mappedBy = "conta", optional = true, fetch = FetchType.LAZY)
	private Restaurante restaurante;*/
	
	public Conta() {
	}

	public Conta(Integer id, String nome, String email, String senha, Date dataCriacao, Boolean estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
		this.estado = estado;
		//this.restaurante = restaurante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	@JsonSetter("estado_conta")
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<String> getContactos() {
		return contactos;
	}

	public void setContactos(Set<String> contactos) {
		this.contactos = contactos;
	}

	
	public List<Encomenda> getEncomendas() {
		return encomendas;
	}
	
	public void setEncomendas(List<Encomenda> encomendas) {
		this.encomendas = encomendas;
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
