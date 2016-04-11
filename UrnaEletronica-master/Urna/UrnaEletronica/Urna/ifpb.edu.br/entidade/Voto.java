package entidade;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entidade.Candidato;
import entidade.Eleitor;
import entidade.Urna_eletronica;

@Entity
@Table(name = "tb_voto")
@NamedQuery(name = "Voto.getAll", query = "from Voto")


public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voto")
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "eleitor_FK")
	private Eleitor eleitor;
	
	@ManyToOne
	@JoinColumn(name = "candidato_FK")
	private Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name = "urna_FK")
	private Urna_eletronica urna;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name="voto")
	private int voto_candidato;
	
	

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Urna_eletronica getUrna_eletronica() {
		return urna;
	}

	public void setUrna(Urna_eletronica urna) {
		this.urna = urna;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVoto_candidato() {
		return voto_candidato;
	}

	public void setVoto_candidato(int voto_candidato) {
		this.voto_candidato = voto_candidato;
	}	
}

  
	

	


