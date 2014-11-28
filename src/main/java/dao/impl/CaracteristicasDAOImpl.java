package dao.impl;
import hibernate.HibernateUtil;

import java.util.List;

import model.Caracteristicas;
import model.CaracteristicasId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import dao.inf.CaracteristicasDAO;

/**
 * Home object for domain model class Caracteristicas.
 * @see .Caracteristicas
 * @author Hibernate Tools
 */
public class CaracteristicasDAOImpl implements CaracteristicasDAO{

	private static final Log log = LogFactory.getLog(CaracteristicasDAOImpl.class);
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public boolean save(Caracteristicas caract) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();		
		try {
			session.getTransaction().begin();
			session.save(caract);
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
		Integer lastId=1;
		try {			
			String sql="select max(idCaracteristicas)+1 from Caracteristicas";
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
