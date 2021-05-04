package co.ao.mfdesenvolvimento.domain.enumeration;



public enum TipoPagamento {
	DINHEIRO(1, "Dinheiro"),
	REFERENCIA_BANCARIA(2, "Referência Bancária"),
	CARTAO(3, "Cartão Multicaixa");
	
	private int cod;
	private String descricao;
	
	private TipoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPagamento toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for (TipoPagamento x : TipoPagamento.values()) {
			if ( cod.equals(x.getCod())) return x;
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}
}
