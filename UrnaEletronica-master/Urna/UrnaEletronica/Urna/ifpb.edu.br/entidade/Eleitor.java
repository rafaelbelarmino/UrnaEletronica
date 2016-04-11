package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import entidade.Pessoa;

@Entity
@Table(name = "tb_eleitor")
@NamedQuery(name = "Eleitor.getAll", query = "from Eleitor")


public class Eleitor extends Pessoa{

	@Column(name = "titulo_pessoa")
	private String titulo_votacao;
	

	public String getTitulo_votacao() {
		return titulo_votacao;
	}

	public void setTitulo_votacao(String titulo_votacao) {
		this.titulo_votacao = titulo_votacao;
	}
	
}

