package Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import entidade.Voto;
import hibernate.HibernateUtil;

public class VotoDao extends GenericDAO<Voto>  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Voto> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Voto> votos = null;

		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("Voto.getAll");
			votos = (List<Voto>) query.list();
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		return votos;
	}

	@Override
	public Voto getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Voto voto = null;

		try {
			session.beginTransaction();
			voto = (Voto) session.get(Voto.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return voto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Voto> getByVoto(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto as a"
					+ " where a.eleitor.id = :id";

			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			votos = (List<Voto>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return votos;
	}

	@SuppressWarnings("unchecked")
	public int getVotosCandidato(int numero) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto as a"
					+ " where a.voto = :numero";

			Query query = session.createQuery(hql);
			query.setParameter("numero", numero);

			votos = (List<Voto>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return votos.size();
	}
}

