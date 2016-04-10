package Bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Dao.CandidatoDao;
import Dao.VotoDao;
import entidade.Apuracao;
import entidade.Candidato;

@ManagedBean(name = "ApuracaoBean")
@SessionScoped
public class ApuracaoBean {

	Apuracao apuracao;

	public ApuracaoBean(){

		this.apuracao = new Apuracao();
	}

	public void ApuracaoFinal() throws IOException{
		System.out.println("Olha eu aqui");
		CandidatoDao candidatoDAO = new CandidatoDao();
		VotoDao votoDAO = new VotoDao();

		apuracao.setQnt_votos(votoDAO.getAll().size());

		List<Candidato> candidatos = candidatoDAO.getAllCandidatos();

		for(Candidato candidatoDynamic : candidatos){

			switch (candidatoDynamic.getCargo()) {

			case "Prefeito":

				candidatoDynamic.setNum_votos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(), candidatoDynamic.getCargo()));

				if(apuracao.getCandidato_mais_votado() == null){

					apuracao.setCandidato_mais_votado(candidatoDynamic);

				}else if(apuracao.getCandidato_mais_votado().getNum_votos() < candidatoDynamic.getNum_votos()){

					apuracao.setCandidato_mais_votado(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Governador":

				candidatoDynamic.setNum_votos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));

				if(apuracao.getGovernorVoto() == null){

					apuracao.setGovernorVoted(candidatoDynamic);

				}else if(apuracao.getGovernorVoto().getNum_votos() < candidatoDynamic.getNum_votos()){

					apuracao.setgovern_eleito(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Presidente":

				candidatoDynamic.setNum_votos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));
					
				if(apuracao.getPresidentVoted() == null){

					apuracao.setPresidentVoted(candidatoDynamic);

				}else if(apuracao.getPresidentVoted().getNum_votos() < candidatoDynamic.getNum_votos()){

					apuracao.setPresident_eleito(candidatoDynamic);

				}

				System.out.println("");
				break;

			default:

				break;
			}

		}

		apuracao.setCandidato_mais_votado(apuracao.getCandidato_mais_votado());
		apuracao.setgovern_eleito(apuracao.getGovernorVoto());
		apuracao.setPresident_eleito(apuracao.getPresidentVoted());
		apuracao.setQnt_brancos(votoDAO.getVotosEmBranco());
		apuracao.setQnt_votos(votoDAO.getAll().size());

		FacesContext.getCurrentInstance().getExternalContext().redirect("apuracaoFinal.xhtml"); 	
		System.out.println(apuracao.getCandidato_mais_votado());
		System.out.println(apuracao.getGovernorVoto());
		System.out.println(apuracao.getPresidentVoted());
		System.out.println("aquiPOSADASJDHS");
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}

}