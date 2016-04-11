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
		CandidatoDao candidatoDao = new CandidatoDao();
		VotoDao votoDao = new VotoDao();

		apuracao.setQuantVotos(votoDao.getAll().size());

		List<Candidato> candidatos = candidatoDao.getAllCandidatos();

		for(Candidato candidatoDynamic : candidatos){

			switch (candidatoDynamic.getCargo()) {

			case "Prefeito":

				candidatoDynamic.setNumeroVotos(votoDao.getVotosCandidato(candidatoDynamic.getNumero(), candidatoDynamic.getCargo()));

				if(apuracao.getPref_votado() == null){

					apuracao.setPref_votado(candidatoDynamic);

				}else if(apuracao.getPref_votado().getnum_votos() < candidatoDynamic.getnum_votos()){

					apuracao.setPrefeitoeleito(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Governador":

				candidatoDynamic.setNumeroVotos(votoDao.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));

				if(apuracao.getGovern_votado() == null){

					apuracao.setGovern_votado(candidatoDynamic);

				}else if(apuracao.getGovern_votado().getnum_votos() < candidatoDynamic.getnum_votos()){

					apuracao.setGoverneleito(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Presidente":

				candidatoDynamic.setNumeroVotos(votoDao.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));
					
				if(apuracao.getPresid_votado() == null){

					apuracao.setPresid_votado(candidatoDynamic);

				}else if(apuracao.getPresid_votado().getnum_votos() < candidatoDynamic.getnum_votos()){

					apuracao.setPresident_eleito(candidatoDynamic);

				}

				System.out.println("");
				break;

			default:

				break;
			}

		}

		apuracao.setPrefeitoeleito(apuracao.getPref_votado());
		apuracao.setGoverneleito(apuracao.getGovern_votado());
		apuracao.setPresident_eleito(apuracao.getPresid_votado());
		apuracao.setQuantBrancos(votoDao.getVotosEmBranco());
		apuracao.setQuantVotos(votoDao.getAll().size());

		FacesContext.getCurrentInstance().getExternalContext().redirect("apuracaoFinal.xhtml"); 	
		System.out.println(apuracao.getPref_votado());
		System.out.println(apuracao.getGovern_votado());
		System.out.println(apuracao.getPresid_votado());
		System.out.println("aquiPOSADASJDHS");
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}

}