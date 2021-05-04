package co.ao.mfdesenvolvimento.domain.enumeration;

public enum EstadoEncomenda {
	PENDENTE (1, "Pendente"),
	ENTREGUE(2, "Entregue"),
	CANCELADA (3, "Cancelada");
	
	private int cod;
	private String descricao;
	
	private EstadoEncomenda(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoEncomenda toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(EstadoEncomenda x : EstadoEncomenda.values()) {
			if(cod.equals(x.getCod())) return x;
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}
}
