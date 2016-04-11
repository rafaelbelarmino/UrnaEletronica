package Bean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Dao.CandidatoDao;
import Dao.EleitorDao;
import Dao.VotoDao;
import entidade.Candidato;
import entidade.Eleitor;
import entidade.Voto;

@ManagedBean (name = "VotacaoBean")
@SessionScoped
public class VotacaoBean {

	private Eleitor eleitor;
	private Voto voto;
	private Candidato candidato;
	private int count = 3;


	public VotacaoBean(){

		this.eleitor = new Eleitor();
		this.candidato = new Candidato();
		this.voto = new Voto();

	}

	public void ValidacaoEleitor()throws IOException{
		EleitorDao eleitorDAO = new EleitorDao();
		Eleitor eleitorValidacao = new Eleitor();

		eleitorValidacao = eleitorDAO.getByTitulo(eleitor.getTituloVotacao());
		if (eleitorValidacao != null){

			VotoDao votoDAO = new VotoDao();
			List<Voto> voto_aux = votoDAO.getByVoto(eleitorValidacao.getIdpessoa());

			if(voto_aux.size()==0){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eleitor", eleitorValidacao);
				FacesContext.getCurrentInstance().getExternalContext().redirect("votacaoPrefeito.xhtml");

			}else{
				FacesContext.getCurrentInstance().addMessage(
						"messages",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Eleitor já votou", null));
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(
					"messages",
					new FacesMessage(FacesMessage.SEVERITY_WARN,"Eleitor não cadastrado", null));
		}
	}


	public void Votar() throws IOException{

		Date data = new Date();
		
		CandidatoDao candidatoDAO = new CandidatoDao();
		
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

		Candidato candidato = candidatoDAO.getByNumero(voto.getVotoCandidato());

		VotoDao votoDAO = new VotoDao();

		switch (count) {
		
		case 3:

			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Prefeito");

			FacesContext.getCurrentInstance().getExternalContext().redirect("votacaoGovernador.xhtml");
			count--;
			
			break;
			
		case 2:

			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Governador");

			FacesContext.getCurrentInstance().getExternalContext().redirect("votacaoPresidente.xhtml");
			count--;
			
			break;

		case 1:

			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Presidente");

			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			count = 3;
			
			break;

		default:
			
			break;
			
		}

		votoDAO.insert(voto);
	}

	public void VotarBranco() throws IOException{
		
		Date data = new Date();
		
		voto.setData(data);
		voto.setEleitor(null);
		voto.setCandidato(null);
		voto.setVotoCandidato(0);
			
		VotoDao votoDAO = new VotoDao();
		votoDAO.insert(voto);
		
		switch (count) {
		case 3:
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("votacaoGovernador.xhtml");
			count--;
			
			break;
			
		case 2:
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("votacaoPresidente.xhtml");
			count--;
			
			break;
			
		case 1:
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			count = 3;
			
			break;

		default:
			
			break;
			
		}
	}
	
	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}