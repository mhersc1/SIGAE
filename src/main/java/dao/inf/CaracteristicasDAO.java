package dao.inf;
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
public interface CaracteristicasDAO {
public boolean save(Caracteristicas caract);
public Integer lastId();
}
