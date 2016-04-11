package Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.HibernateUtil;
import entidade.Urna_eletronica;

public class UrnaEletronicaDao extends GenericDao<Integer, Urna_eletronica>{

	@Override
	public Urna_eletronica find(Urna_eletronica entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Urna_eletronica> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Urna_eletronica getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Urna_eletronica urnaEletronica = null;

		try {
			
			session.beginTransaction();
			urnaEletronica = (Urna_eletronica) session.get(Urna_eletronica.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return urnaEletronica;
	}

}
