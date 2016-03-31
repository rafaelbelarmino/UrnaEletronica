package entidade;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "tb_candidato")
@DiscriminatorValue(value = "2")
@NamedQuery(name = "Candidato.getAll", query = "from Candidato")

public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidato")
	private Integer numero;
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
