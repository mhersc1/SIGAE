package service.impl;
import hibernate.HibernateUtil;

import java.util.List;
import java.util.Map;

import model.Caracteristicas;
import model.CaracteristicasId;
import model.Etiqueta;
import model.EtiquetaId;
import model.Nivelconfig;
import model.NivelconfigId;
import model.Plantilla;
import model.Query;
import model.QueryId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import service.inf.PlantillaService;
import web.form.RowTemplate;
import dao.impl.CaracteristicasDAOImpl;
import dao.impl.EtiquetaDAOImpl;
import dao.impl.NivelconfigDAOImpl;
import dao.impl.PlantillaDAOImpl;
import dao.impl.QueryDAOImpl;
import dao.inf.CaracteristicasDAO;
import dao.inf.EtiquetaDAO;
import dao.inf.NivelconfigDAO;
import dao.inf.PlantillaDAO;
import dao.inf.QueryDAO;

public class PlantillaServiceImpl implements PlantillaService {
	
	private static final Log log = LogFactory.getLog(PlantillaServiceImpl.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	PlantillaDAO plantillaDAO;
	EtiquetaDAO etiquetaDAO;
	NivelconfigDAO nivelDAO;
	CaracteristicasDAO caracteristicasDAO;
	QueryDAO queryDAO;
	
	@Override
	public boolean save(String query, Map<String,Integer> etiquetas,List<RowTemplate> rowsTemplate) {
		// TODO Auto-generated method stub
		boolean flagP,flagE,flagN,flagC,flagQ;
		//Plantilla		
		
		plantillaDAO=new PlantillaDAOImpl();
		etiquetaDAO=new EtiquetaDAOImpl();
		nivelDAO=new NivelconfigDAOImpl();
		caracteristicasDAO=new CaracteristicasDAOImpl();
		queryDAO=new QueryDAOImpl();
		
		Integer idP=plantillaDAO.lastId();
		Plantilla plantilla = new Plantilla();
		
		plantilla.setIdPlantilla(idP);
		plantilla.setNombre("Plantilla_"+idP);
		plantilla.setDireccion("C:/Users/lel");
		plantilla.setQuery(query);
		
		flagP=plantillaDAO.save(plantilla);
		
		if (flagP) {
			//Etiquetas
			for (String key : etiquetas.keySet()) {//Etiquetas i.e: H, D y F.
				Integer idE = etiquetaDAO.lastId();
				int cantidad = etiquetas.get(key);
				Etiqueta etiqueta = new Etiqueta();
				EtiquetaId IDE = new EtiquetaId(idE, idP);
				etiqueta.setId(IDE);
				etiqueta.setTipoEtiqueta(key);
				etiqueta.setCantidad(cantidad);

				etiqueta.setPlantilla(plantilla);
				flagE = etiquetaDAO.save(etiqueta);
				//Nivel Config

				if (flagE) {
					for (int posicion = 1; posicion <= cantidad; posicion++) {//Etiquetas 1, ... , N.

						Integer idN = nivelDAO.lastId();
						Nivelconfig nivel = new Nivelconfig();
						NivelconfigId IDN = new NivelconfigId(idN, idE, idP);
						nivel.setId(IDN);
						nivel.setPosicion(posicion);

						nivel.setEtiqueta(etiqueta);
						flagN = nivelDAO.save(nivel);



						if (flagN) {
							for (RowTemplate row : rowsTemplate) {//Recorredor de Campos por NivelConfig							
								if (row.getItem().equals(
										etiqueta.getTipoEtiqueta()
												+ nivel.getPosicion())) {
									Integer idC = caracteristicasDAO.lastId();
									Caracteristicas caracteristicas = new Caracteristicas();
									CaracteristicasId IDC = new CaracteristicasId(
											idC, idN, idE, idP);
									caracteristicas.setId(IDC);
									caracteristicas
											.setTamanio(row.getTamanio());
									caracteristicas.setTipoDato(row.getTipo());
									caracteristicas
											.setCifrado(row.isCifrado() ? "S"
													: "N");
									if (row.getTransformado().isTransformado()) {
										caracteristicas.setTransformado("S");
										caracteristicas.setCaracter(row
												.getTransformado()
												.getCaracter());
										caracteristicas.setPosicion(row
												.getTransformado()
												.getPosicion());
									} else {
										caracteristicas.setTransformado("N");
									}
									caracteristicas.setCampo(row.getNombre());
									caracteristicas.setDescripcion(row
											.getNombrePers());
									caracteristicas.setOrden(row.getId());
									caracteristicas.setNivelconfig(nivel);
									flagC = caracteristicasDAO
											.save(caracteristicas);

									if (flagC) {
										if (row.getQuery() != null) {
											if (!row.getQuery().getTextoQuery()
													.equals("")) {
												Integer idQ = queryDAO.lastId();
												Query queri = new Query();
												queri.setId(new QueryId(idQ,
														idC, idN, idE, idP));
												queri.setDescripcion(row
														.getQuery()
														.getDescripcion());
												queri.setNombre(row.getQuery()
														.getNombre());
												queri.setTextoQuery(row
														.getQuery()
														.getTextoQuery());
												queri.setCaracteristicas(caracteristicas);
												flagQ = queryDAO.save(queri);
											}
										}
									}else{
										log.info("No se pudo grabar la plantilla.Error al grabar los campos");
									}
								}
							}
						}else{
							log.info("No se pudo grabar la plantilla.Error al grabar los Niveles de Configuración");
						}
					}
				}else{
					log.info("No se pudo grabar la plantilla.Error al grabar las etiquetas");
				}

			}
		}else{
			log.info("Error al grabar la plantilla.");
		}
		return false;
	}
	
	private void registrarCaracteristicas(List<RowTemplate> rows){
		
		
	}
	@Override
	public boolean update(Plantilla plantilla) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(plantilla);
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
