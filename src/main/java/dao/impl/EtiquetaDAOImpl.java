package dao.impl;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import hibernate.HibernateUtil;
import model.Etiqueta;
import model.Plantilla;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.inf.EtiquetaDAO;

/**
 * Home object for domain model class Etiqueta.
 * @see .Etiqueta
 * @author Hibernate Tools
 */
public class EtiquetaDAOImpl implements EtiquetaDAO{

	private static final Log log = LogFactory.getLog(EtiquetaDAOImpl.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	@Override
	public boolean save(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();		
		try {
			session.getTransaction().begin();
			session.save(etiqueta);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
			return false;
		}
	}

	@Override
	public boolean update(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(etiqueta);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
			return false;
		}		
	}

	@Override
	public Integer lastId() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		Integer lastId= 1;
		try {			
			String sql="select max(idEtiqueta)+1 from Etiqueta";
			Integer value=(Integer) session.createQuery(sql).uniqueResult();
			if (value!=null) {
				lastId = value;
			}
			return lastId;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}		
	}
}
