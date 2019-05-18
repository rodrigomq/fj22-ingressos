package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	private Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private LocalTime getHorario() {
		return horario;
	}

	private void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	private Sala getSala() {
		return sala;
	}

	private void setSala(Sala sala) {
		this.sala = sala;
	}

	private Filme getFilme() {
		return filme;
	}

	private void setFilme(Filme filme) {
		this.filme = filme;
	}

	/**
	 * @deprecated hibernate only
     */
    public Sessao() {
    
    }
	
	public Sessao(LocalTime horario, Filme filme, Sala sala) {
        this.horario = horario;
        this.setFilme(filme);
        this.sala = sala;
    }

    public LocalTime getHorarioTermino() {
        return this.horario.plusMinutes(filme.getDuracao().toMinutes());
    }
}
