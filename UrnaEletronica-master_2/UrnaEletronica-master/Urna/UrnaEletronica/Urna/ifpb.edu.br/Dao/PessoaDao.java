package Dao;

import java.util.List;

import entidade.Pessoa;
import hibernate.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class PessoaDao extends GenericDAO<Pessoa>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Pessoa> pessoas = null;

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("Pessoa.getAll");
			pessoas = (List<Pessoa>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		return pessoas;
	}

	@Override
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
