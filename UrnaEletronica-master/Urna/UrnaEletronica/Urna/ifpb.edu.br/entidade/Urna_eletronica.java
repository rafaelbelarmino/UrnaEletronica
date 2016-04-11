package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_urna_eletronica")
@NamedQuery(name = "Urna_eletronica.getAll", query = "from Urna_eletronica")

public class Urna_eletronica {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_urna")
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}

