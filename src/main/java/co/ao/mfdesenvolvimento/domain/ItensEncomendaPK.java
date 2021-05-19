package co.ao.mfdesenvolvimento.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class ItensEncomendaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "encomenda_id")
	private Encomenda encomenda;
	@ManyToOne
	@JoinColumn(name = "itemmenu_id")
	private ItemMenu itemMenu;
	public Encomenda getEncomenda() {
		return encomenda;
	}
	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
	public ItemMenu getItemMenu() {
		return itemMenu;
	}
	public void setItemMenu(ItemMenu itemMenu) {
		this.itemMenu = itemMenu;
	}
	
}
