package dao.impl;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import hibernate.HibernateUtil;
import model.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.inf.QueryDAO;

/**
 * Home object for domain model class Query.
 * @see .Query
 * @author Hibernate Tools
 */
public class QueryDAOImpl implements QueryDAO{

	private static final Log log = LogFactory.getLog(QueryDAOImpl.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean save(Query query) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();		
		try {
			session.getTransaction().begin();
			session.save(query);
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
			String sql="select max(idQuery)+1 from Query";
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
