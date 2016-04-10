package Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.HibernateUtil;
import entidade.Pessoa;

public class PessoaDao extends GenericDao<Integer, Pessoa>{

	private static PessoaDao instance;

	public static PessoaDao getInstance() {	

		instance = new PessoaDao();		
		return instance;
	}

	@Override
	public Pessoa find(Pessoa entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = null;

		try {
			session.beginTransaction();
			pessoa = (Pessoa) session.get(Pessoa.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return pessoa;
	}
}
