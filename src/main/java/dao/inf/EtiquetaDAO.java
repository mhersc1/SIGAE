package dao.inf;
// Generated 27/11/2014 02:39:51 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import model.Etiqueta;
import model.EtiquetaId;
import model.Plantilla;

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
public interface EtiquetaDAO {
	public boolean save(Etiqueta etiqueta);
	public boolean update(Etiqueta etiqueta);
	public Integer lastId();
}
