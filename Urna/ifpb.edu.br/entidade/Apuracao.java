package entidade;

public class Apuracao {

	private int id;

	private int quantVotos, quantBrancos;

	private Candidato pref_votado, govern_votado, presid_votado;

	private Candidato prefeitoeleito, governeleito, president_eleito;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantVotos() {
		return quantVotos;
	}

	public void setQuantVotos(int quantVotos) {
		this.quantVotos = quantVotos;
	}

	public int getQuantBrancos() {
		return quantBrancos;
	}

	public void setQuantBrancos(int quantBrancos) {
		this.quantBrancos = quantBrancos;
	}

	public Candidato getPref_votado() {
		return pref_votado;
	}

	public void setPref_votado(Candidato pref_votado) {
		this.pref_votado = pref_votado;
	}

	public Candidato getGovern_votado() {
		return govern_votado;
	}

	public void setGovern_votado(Candidato govern_votado) {
		this.govern_votado = govern_votado;
	}

	public Candidato getPresid_votado() {
		return presid_votado;
	}

	public void setPresid_votado(Candidato presid_votado) {
		this.presid_votado = presid_votado;
	}

	public Candidato getPrefeitoeleito() {
		return prefeitoeleito;
	}

	public void setPrefeitoeleito(Candidato prefeitoeleito) {
		this.prefeitoeleito = prefeitoeleito;
	}

	public Candidato getGoverneleito() {
		return governeleito;
	}

	public void setGoverneleito(Candidato governeleito) {
		this.governeleito = governeleito;
	}

	public Candidato getPresident_eleito() {
		return president_eleito;
	}

	public void setPresident_eleito(Candidato president_eleito) {
		this.president_eleito = president_eleito;
	}

}