package Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Candidato;
import hibernate.HibernateUtil;

public class CandidatoDAO extends GenericDao<Candidato> {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidato> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Candidato> candidatos = null;

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("Candidato.getAll");
			candidatos = (List<Candidato>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		return candidatos;
	}
	
	public Candidato getByNumero(int numero) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Candidato candidato = null;
		
		try {
			
			String hql = "from Candidato as a"
					+ " where a.numero = :numero";
			
			Query query = session.createQuery(hql);
			query.setParameter("numero", numero);
			
			candidato = (Candidato) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		
		return candidato;
	}
	
	@SuppressWarnings("unchecked")
	public List <Candidato> getAllCandidatos() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List <Candidato> candidatos = null;
		
		try {
			
			String hql = "from Pessoa as a"
					+ " where a.DTYPE = :candidato";
			
			Query query = session.createQuery(hql);
			query.setParameter("candidato", "candidato");
			
			candidatos = (List<Candidato>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		
		return candidatos;
	}


	@Override
	public Candidato getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Candidato candidato = null;

		try {
			session.beginTransaction();
			candidato = (Candidato) session.get(Candidato.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return candidato;
	}

	public void delete(Candidato candidato) {
		// TODO Auto-generated method stub
		
	}
}
