package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidato")
@NamedQuery(name = "Candidato.getAll", query = "from Candidato")

public class Candidato extends Eleitor{

	@Column(name = "numero_candidato")
	private int numero;
	
	@Column(name = "cargo_candidato")
	private String cargo;
	
	@Column(name = "num_votos")
	private int num_votos;
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getNum_votos() {
		return num_votos;
	}

	public void setNum_votos(int num_votos) {
		this.num_votos = num_votos;
	}
	
	

}