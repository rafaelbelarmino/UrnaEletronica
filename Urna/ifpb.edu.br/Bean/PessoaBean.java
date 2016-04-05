package Bean;

import java.util.List;


import Dao.PessoaDao;
import entidade.Pessoa;

public class PessoaBean {

public static void main(String[] args) {
		
		List<Pessoa> pessoas = PessoaDAO.getInstance().getAll();
		
		for (Pessoa pessoa: pessoas) {
			System.out.println(pessoa.getId());
			System.out.println(pessoa.getNome());
		}
		
	}
}
	