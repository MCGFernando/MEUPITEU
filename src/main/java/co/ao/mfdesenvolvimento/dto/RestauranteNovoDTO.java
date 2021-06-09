package co.ao.mfdesenvolvimento.dto;

import java.io.Serializable;
import java.util.Date;

public class RestauranteNovoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String restaurante;
	private String descricao;
	private Date dataCriacao;
	private Boolean estado;
	
	private String endereco;
	private String bairro;
	private String quarteirao;
	private String sector;
	private String rua;
	private String edificio;
	private String andar;
	private String casa;
	private String referencia;
	
	private Integer contaID;
	private Integer municipioID;

	public RestauranteNovoDTO() {
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

	public Integer getContaID() {
		return contaID;
	}

	public void setContaID(Integer contaID) {
		this.contaID = contaID;
	}

	public Integer getMunicipioID() {
		return municipioID;
	}

	public void setMunicipioID(Integer municipioID) {
		this.municipioID = municipioID;
	}
	
	
	
	
}
