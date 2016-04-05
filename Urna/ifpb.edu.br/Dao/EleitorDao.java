package Dao;

import java.util.List;

import javax.servlet.GenericServlet;
import javax.ws.rs.core.GenericEntity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Eleitor;
import hibernate.HibernateUtil;

public class EleitorDao  extends GenericDao<Eleitor>{

	@SuppressWarnings("unchecked")
	public List<Eleitor> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Eleitor> eleitores = null;

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("Eleitor.getAll");
			eleitores = (List<Eleitor>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		return eleitores;
	}
	
	public Eleitor getByTitulo(String titulo) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Eleitor eleitor = null;
		
		try {
			
			String hql = "from Eleitor as a"
					+ " where a.titulo_votacao = :titulo";
			
			Query query = session.createQuery(hql);
			query.setParameter("titulo", titulo);
			
			eleitor = (Eleitor) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		
		return eleitor;
	}

	public Eleitor getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Eleitor eleitor = null;

		try {
			session.beginTransaction();
			eleitor = (Eleitor) session.get(Eleitor.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return eleitor;
	}
}
