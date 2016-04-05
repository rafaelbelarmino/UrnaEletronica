package Bean;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Dao.CandidatoDAO;
import Dao.EleitorDAO;
import Dao.VotoDAO;
import entidade.Apuracao;
import entidade.Candidato;
import entidade.Eleitor;
import entidade.Voto;


@SessionScoped
@ManagedBean	

public class VotacaoBean {
  
	Eleitor eleitor;
	Candidato candidato;
	Voto voto;  
	
	public VotacaoBean() {
		
		this.eleitor = new Eleitor();
		this.candidato = new Candidato();
		this.voto = new Voto();
	}

	public void verificarTitulo() throws IOException{
		EleitorDAO eleitorDAO = new EleitorDAO();
		Eleitor eleitor_aux = eleitorDAO.getByTitulo(eleitor.getTitulo_votacao());
		
		VotoDAO votoDAO = new VotoDAO();
		List<Voto> voto_aux = votoDAO.getByVoto(eleitor_aux.getId());
			
		if((eleitor_aux!=null)&&(voto_aux.size()==0)){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eleitor", eleitor_aux);
			FacesContext.getCurrentInstance().getExternalContext().redirect("votar.xhtml");
		}else{
			System.out.println("É nulo");
		}
	}
	
	public void votar(){			
		
	}
	 public void votarPrefeito() throws IOException{
		 Date data = new Date();
			CandidatoDAO candidatoDAO = new CandidatoDAO();
			
			eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

			Candidato candidato = candidatoDAO.getByNumero(voto.getVoto_candidato());
			
			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);

			VotoDAO votoDAO = new VotoDAO();
			votoDAO.insert(voto);
			System.out.println("ok");
			FacesContext.getCurrentInstance().getExternalContext().redirect("votar-governador.xhtml");
	 }
	 
	 public void votarGovernador() throws IOException{
		 Date data = new Date();
			CandidatoDAO candidatoDAO = new CandidatoDAO();
			
			eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

			Candidato candidato = candidatoDAO.getByNumero(voto.getVoto_candidato());
			
			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
	
			VotoDAO votoDAO = new VotoDAO();
			votoDAO.insert(voto);
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("votar-presidente.xhtml");
	 }
	public void votarPresidente() throws IOException{
		Date data = new Date();
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

		Candidato candidato = candidatoDAO.getByNumero(voto.getVoto_candidato());
		
		voto.setData(data);
		voto.setEleitor(eleitor);
		voto.setCandidato(candidato);
		
		VotoDAO votoDAO = new VotoDAO();
		votoDAO.insert(voto);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("entrar-eleicao.xhtml");	
	}
	
	
	public void votar_branco(){
		Date data = new Date();
		
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");
				
		voto.setData(data);
		voto.setEleitor(eleitor);
		voto.setCandidato(null);
		voto.setVoto_candidato(0);
			
		VotoDAO votoDAO = new VotoDAO();
		votoDAO.insert(voto);	
		
	}
	
	public void encerrar_eleicao(){
		
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		VotoDAO votoDAO = new VotoDAO();
		Apuracao apuracao = new Apuracao();
		
		apuracao.setQnt_votos(votoDAO.getAll().size());
		
		List<Candidato> candidatos = candidatoDAO.getAllCandidatos();
		System.out.println("deu certo");
			
		for (Candidato candidato_aux : candidatos) {
			candidato_aux.setNum_votos(votoDAO.getVotosCandidato(candidato_aux.getNumero()));
			
			if(apuracao.getCandidato_mais_votado().getNum_votos() < candidato_aux.getNum_votos()){
				apuracao.setCandidato_eleito(candidato_aux);
				
			}else if(apuracao.getCandidato_menos_votado().getNum_votos() > candidato_aux.getNum_votos())
				apuracao.setCandidato_menos_votado(candidato_aux);
		}
		
		System.out.println("deu certo");
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

}
	


