package web.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Caracteristicas;
import model.EtiquetaId;
import model.Nivelconfig;
import model.Plantilla;
import service.inf.UsarService;

@ManagedBean
@SessionScoped
public class UsarController implements Serializable {

	@ManagedProperty(value="#{usarService}")
	private UsarService usarService;
	
	Plantilla plant;
	
	
	
	List<Plantilla> plantilla;
	List<Caracteristicas> caracteristicas;
	List<EtiquetaId> etiqueta;
	List<Nivelconfig> nivel;

	@PostConstruct
	public void init() {
		

		

	}

	public void consultar() {
		
		int i=0;
		
		if (plant.getNombre().equals(plantilla.get(i).getNombre())){
			
			
		}
		

	}

	public String generar() {
		return "modificar";
	}

	public List<Plantilla> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(List<Plantilla> plantilla) {
		this.plantilla = plantilla;
	}

	public Plantilla getPlant() {
		return plant;
	}

	public void setPlant(Plantilla plant) {
		this.plant = plant;
	}

	public List<Caracteristicas> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristicas> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<EtiquetaId> getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(List<EtiquetaId> etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<Nivelconfig> getNivel() {
		return nivel;
	}

	public void setNivel(List<Nivelconfig> nivel) {
		this.nivel = nivel;
	}

	public UsarService getUsarService() {
		return usarService;
	}

	public void setUsarService(UsarService usarService) {
		this.usarService = usarService;
	}
	

}
