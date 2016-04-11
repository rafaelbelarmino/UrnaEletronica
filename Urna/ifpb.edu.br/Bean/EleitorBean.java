package Bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Dao.EleitorDao;
import entidade.Eleitor;

@ManagedBean(name = "eleitorBean")
@RequestScoped
public class EleitorBean {

	private Eleitor eleitor;

	public EleitorBean(){

		this.eleitor = new Eleitor();
	}

	public List<Eleitor> getEleitores(){

		return new EleitorDao().getAll();

	}

	public void inserir() throws IOException{
		
		System.out.println("Aqui");
		
		EleitorDao eleitorDao = new EleitorDao();
		eleitorDao.insert(eleitor);

		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 	
	    
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

}