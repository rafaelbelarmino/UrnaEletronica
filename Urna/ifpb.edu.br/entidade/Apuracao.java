package entidade;

import entidade.Candidato;

public class Apuracao {

    private int id;
	
	private int num_votos;

	private int num_brancos;
	
	private int num_nulos;
	
	private int num_ausentes;
	
	private Candidato candidato_mais_votado;
	
	
	private Candidato candidato_menos_votado;
	
	
	private Candidato candidato_eleito;
	
	
	private Candidato candidatos_segundo_turno;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQnt_votos() {
		return num_votos;
	}

	public void setQnt_votos(int qnt_votos) {
		this.num_votos = qnt_votos;
	}

	public int getQnt_brancos() {
		return num_brancos;
	}

	public void setQnt_brancos(int qnt_brancos) {
		this.num_brancos = qnt_brancos;
	}

	public int getQnt_nulos() {
		return num_nulos;
	}

	public void setQnt_nulos(int num_nulos) {
		this.num_nulos = num_nulos;
	}

	public int getQnt_ausentes() {
		return num_ausentes;
	}

	public void setQnt_ausentes(int num_ausentes) {
		this.num_ausentes = num_ausentes;
	}

	public Candidato getCandidato_mais_votado() {
		return candidato_mais_votado;
	}

	public void setCandidato_mais_votado(Candidato candidato_mais_votado) {
		this.candidato_mais_votado = candidato_mais_votado;
	}

	public Candidato getCandidato_menos_votado() {
		return candidato_menos_votado;
	}

	public void setCandidato_menos_votado(Candidato candidato_menos_votado) {
		this.candidato_menos_votado = candidato_menos_votado;
	}

	public Candidato getCandidato_eleito() {
		return candidato_eleito;
	}

	public void setCandidato_eleito(Candidato candidato_eleito) {
		this.candidato_eleito = candidato_eleito;
	}

	public Candidato getCandidatos_segundo_turno() {
		return candidatos_segundo_turno;
	}

	public void setCandidatos_segundo_turno(Candidato candidatos_segundo_turno) {
		this.candidatos_segundo_turno = candidatos_segundo_turno;
	}

}

