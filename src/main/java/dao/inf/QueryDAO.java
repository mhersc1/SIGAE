package dao.inf;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import model.Query;
import model.QueryId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Query.
 * @see .Query
 * @author Hibernate Tools
 */
public interface QueryDAO {
public boolean save(Query query);
public Integer lastId();
}
