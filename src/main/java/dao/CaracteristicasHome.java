package dao;
import hibernate.HibernateUtil;

import java.util.List;

import javax.naming.InitialContext;

import model.Caracteristicas;
import model.CaracteristicasId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Caracteristicas.
 * @see .Caracteristicas
 * @author Hibernate Tools
 */
public class CaracteristicasHome {

	private static final Log log = LogFactory.getLog(CaracteristicasHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	public void persist(Caracteristicas transientInstance) {
		log.debug("persisting Caracteristicas instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Caracteristicas instance) {
		log.debug("attaching dirty Caracteristicas instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Caracteristicas instance) {
		log.debug("attaching clean Caracteristicas instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Caracteristicas persistentInstance) {
		log.debug("deleting Caracteristicas instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Caracteristicas merge(Caracteristicas detachedInstance) {
		log.debug("merging Caracteristicas instance");
		try {
			Caracteristicas result = (Caracteristicas) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Caracteristicas findById(CaracteristicasId id) {
		log.debug("getting Caracteristicas instance with id: " + id);
		try {
			Caracteristicas instance = (Caracteristicas) sessionFactory
					.getCurrentSession().get("Caracteristicas", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Caracteristicas instance) {
		log.debug("finding Caracteristicas instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Caracteristicas")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Caracteristicas> getAll(){
		Session session=this.sessionFactory.openSession();
		return session.createQuery("from Caracteristicas").list();
	}
}