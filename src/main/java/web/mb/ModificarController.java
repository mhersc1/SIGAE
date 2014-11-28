package web.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import web.util.UsarPlantilla;

@ManagedBean
@SessionScoped
public class ModificarController {

	List<UsarPlantilla> list;
	UsarPlantilla selectedmodi;

	@PostConstruct
	public void init() {
		selectedmodi = new UsarPlantilla();
		

	}

	public void añadir() {

	}

	public void generar() {

	}
	
	public void guardar(){
		
		
		
	}
	public void eliminarFila(){
		
		
		
	}
	
	public void modificarFila(){
		
		
	}
	
	public void añadirFila(){
		
		
	}

	public List<UsarPlantilla> getList() {
		return list;
	}

	public void setList(List<UsarPlantilla> list) {
		this.list = list;
	}

	public UsarPlantilla getSelectedmodi() {
		return selectedmodi;
	}

	public void setSelectedmodi(UsarPlantilla selectedmodi) {
		this.selectedmodi = selectedmodi;
	}
	
	


}
