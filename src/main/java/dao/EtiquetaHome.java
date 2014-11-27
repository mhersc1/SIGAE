package dao;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import model.Etiqueta;
import model.EtiquetaId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Etiqueta.
 * @see .Etiqueta
 * @author Hibernate Tools
 */
public class EtiquetaHome {

	private static final Log log = LogFactory.getLog(EtiquetaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Etiqueta transientInstance) {
		log.debug("persisting Etiqueta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Etiqueta instance) {
		log.debug("attaching dirty Etiqueta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Etiqueta instance) {
		log.debug("attaching clean Etiqueta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Etiqueta persistentInstance) {
		log.debug("deleting Etiqueta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Etiqueta merge(Etiqueta detachedInstance) {
		log.debug("merging Etiqueta instance");
		try {
			Etiqueta result = (Etiqueta) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Etiqueta findById(EtiquetaId id) {
		log.debug("getting Etiqueta instance with id: " + id);
		try {
			Etiqueta instance = (Etiqueta) sessionFactory.getCurrentSession()
					.get("Etiqueta", id);
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

	public List findByExample(Etiqueta instance) {
		log.debug("finding Etiqueta instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Etiqueta").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
