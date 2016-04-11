package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_candidato")
@NamedQuery(name="Candidato.getAll", query=" from Candidato")
public class Candidato extends Pessoa{
	
	@Column(name="numero", unique = true)
	private Integer numero;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name ="numVotos")
	private Integer num_Votos;
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getnum_votos() {
		return getnum_votos();
	}

	public void setNumeroVotos(Integer num_Votos) {
		this.num_Votos = num_Votos;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}