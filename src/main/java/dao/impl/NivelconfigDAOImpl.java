package dao.impl;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import hibernate.HibernateUtil;
import model.Nivelconfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.inf.NivelconfigDAO;

/**
 * Home object for domain model class Nivelconfig.
 * @see .Nivelconfig
 * @author Hibernate Tools
 */
public class NivelconfigDAOImpl implements NivelconfigDAO {

	private static final Log log = LogFactory.getLog(NivelconfigDAOImpl.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Integer lastId() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Integer lastId=1;
		try {			
			String sql="select max(idNivelConfig)+1 from Nivelconfig";
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

	@Override
	public boolean save(Nivelconfig nivel) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();		
		try {
			session.getTransaction().begin();
			session.save(nivel);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
			return false;
		}
	}
	

}
