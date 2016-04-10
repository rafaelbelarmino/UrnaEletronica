package Bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Dao.CandidatoDao;
import entidade.Candidato;

@RequestScoped	
@ManagedBean

public class CandidatoBean {
  
	private Candidato candidato;
	
	public CandidatoBean() {
		
		this.candidato = new Candidato();		
	}
	
	public void cadastrarCandidato() throws IOException{
		
		CandidatoDao candidatoDAO = new CandidatoDao();
		candidatoDAO.insert(candidato);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}
	
	public void deletarCandidato() throws IOException{
		
		CandidatoDao candidatoDAO = new CandidatoDao();
		candidatoDAO.delete(candidato);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
}