package Dao;

import java.util.List;

import hibernate.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public abstract class GenericDao <PK, T>{

public int insert(T entity) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return 0;
	}
	
	public void update(T entity) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(T entity) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public abstract List<T> getAll();

	public abstract T getById(Integer pk);
	
}