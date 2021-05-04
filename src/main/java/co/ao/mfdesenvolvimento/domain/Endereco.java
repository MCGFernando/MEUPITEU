package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;

public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String endereco;
	private String bairro;
	private String quarteirao;
	private String sector;
	private String rua;
	private String edificio;
	private String andar;
	private String casa;
	private String referencia;
	
	public Endereco() {
	}

	public Endereco(Integer id, String endereco, String bairro, String quarteirao, String sector, String rua,
			String edificio, String andar, String casa, String referencia) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.bairro = bairro;
		this.quarteirao = quarteirao;
		this.sector = sector;
		this.rua = rua;
		this.edificio = edificio;
		this.andar = andar;
		this.casa = casa;
		this.referencia = referencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getQuarteirao() {
		return quarteirao;
	}

	public void setQuarteirao(String quarteirao) {
		this.quarteirao = quarteirao;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
