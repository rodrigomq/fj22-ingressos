package br.com.caelum.ingresso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Ingresso> ingressos = new ArrayList<>();

    /**
    * @deprecated hibernate only
    */
    public Compra() {
    }

    public Compra(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

	@Override
	public String toString() {
		return "Compra [id=" + id + ", ingressos=" + ingressos + "]";
	}
    
    
}