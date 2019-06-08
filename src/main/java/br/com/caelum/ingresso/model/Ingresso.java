package br.com.caelum.ingresso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso implements Serializable {

	private static final long serialVersionUID = -3017013840478197150L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@ManyToOne
    private Sessao sessao;
	
    private BigDecimal preco;
    
    @ManyToOne
    private Lugar lugar;
    
    @Enumerated(EnumType.STRING)
    private TipoDeIngresso tipoDeIngresso;

    /**
    * @deprecated hibernate only
    */
    public Ingresso(){

    }

    public Ingresso(Sessao sessao, TipoDeIngresso tipoDeDesconto, Lugar lugar) {
        this.sessao = sessao;
        this.tipoDeIngresso = tipoDeDesconto;
        this.lugar = lugar;
        this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
    }
    
    public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
        this.sessao = sessao;
        this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
    }

    public Sessao getSessao() {
        return sessao;
    }

    public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPreco() {
        return preco.setScale(2, RoundingMode.HALF_UP);
    }

	@Override
	public String toString() {
		return "Ingresso [sessao=" + sessao + ", preco=" + preco + ", lugar=" + lugar + ", tipoDeIngresso="
				+ tipoDeIngresso + "]";
	}
	
	
    
    
}